package com.test.rizky.service.impl;

import com.google.gson.JsonObject;
import com.test.rizky.domain.MasterPrice;
import com.test.rizky.dto.MasterPriceDTO;
import com.test.rizky.mapper.MasterPriceMapper;
import com.test.rizky.repository.MasterPriceRepository;
import com.test.rizky.service.MasterPriceService;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.test.rizky.shared.util.ObjectUtil.isExist;
import static com.test.rizky.shared.util.ValidatorUtil.validateField;


@Slf4j
@Service
public class MasterPriceServiceImpl implements MasterPriceService {
    private final MasterPriceRepository masterPriceRepository;
    private final MasterPriceMapper masterPriceMapper;

    @Autowired
    private final RedisTemplate<String, MasterPrice> redisTemplate;

    public MasterPriceServiceImpl(MasterPriceRepository masterPriceRepository, MasterPriceMapper masterPriceMapper, RedisTemplate<String, MasterPrice> redisTemplate) {
        this.masterPriceRepository = masterPriceRepository;
        this.masterPriceMapper = masterPriceMapper;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public MasterPriceDTO addMasterPrice(MasterPriceDTO dto) {
        log.info("master price request. addMasterPrice {}", dto);
        validateField(dto.getDestinationCode(), "destination code");
        validateField(dto.getOriginCode(), "origin code");
        validateField(dto.getPrice(), "price");
        validateField(dto.getProduct(),"product");

        MasterPrice masterPrice = masterPriceMapper.convertToEntity(dto);
        masterPrice = masterPriceRepository.save(masterPrice);

        redisTemplate.opsForHash().put("PRICE", masterPrice.getId(), masterPrice);
        redisTemplate.expire("PRICE", 3600, TimeUnit.SECONDS);
        return masterPriceMapper.convertToDto(masterPrice);
    }

    @Override
    public MasterPriceDTO getById(Long id) {
        validateField(id, "id");
        MasterPrice masterPrice = (MasterPrice) redisTemplate.opsForHash().get("PRICE", id);
        log.info("response get data from redis {}", masterPrice);

        return isExist(masterPrice) ? masterPriceMapper.convertToDto(masterPrice) : null;
    }

    @Override
    public List<MasterPriceDTO> getAll() {
       List<Object> masterPriceList = redisTemplate.opsForHash().values("PRICE");
        List<MasterPriceDTO> masterPriceDTOList = new ArrayList<>();
       if (masterPriceList.size() == 0){
           return masterPriceDTOList;
       }else{
           for (Object data: masterPriceList){
               MasterPrice masterPrice = (MasterPrice) data;
               MasterPriceDTO masterPriceDTO = masterPriceMapper.convertToDto(masterPrice);
               masterPriceDTOList.add(masterPriceDTO);
           }
        return  masterPriceDTOList;
       }

    }
}
