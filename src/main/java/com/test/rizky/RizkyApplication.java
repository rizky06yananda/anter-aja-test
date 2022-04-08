package com.test.rizky;

import com.test.rizky.dto.MasterPriceDTO;
import com.test.rizky.dto.response.ResponseDTO;
import com.test.rizky.service.MasterPriceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@SpringBootApplication
@RestController
public class RizkyApplication {
    private final MasterPriceService masterPriceService;

    public RizkyApplication(MasterPriceService masterPriceService) {
        this.masterPriceService = masterPriceService;
    }


    public static void main(String[] args) {
        SpringApplication.run(RizkyApplication.class, args);
    }

    @PostMapping(value = "/add/master-price")
    @ApiOperation("Api to add master price")
    public ResponseDTO addMasterPrice(@RequestBody MasterPriceDTO dto) {
        return ResponseDTO.SUCCESS(masterPriceService.addMasterPrice(dto));
    }

    @GetMapping("/get/list/master-price")
    @ApiOperation("get all list data")
    public ResponseDTO getList (){
        return ResponseDTO.SUCCESS((Serializable) masterPriceService.getAll());
    }

    @GetMapping(value = "/get/master-price/{id}")
    @ApiOperation("get master price by id")
    public ResponseDTO getMasterPrice(@PathVariable ("id") Long id){
        return ResponseDTO.SUCCESS(masterPriceService.getById(id));
    }

}
