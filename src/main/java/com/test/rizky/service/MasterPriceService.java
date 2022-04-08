package com.test.rizky.service;

import com.test.rizky.dto.MasterPriceDTO;

import java.util.List;

public interface MasterPriceService {
    MasterPriceDTO addMasterPrice (MasterPriceDTO dto);
    MasterPriceDTO getById (Long id);
    List<MasterPriceDTO> getAll ();
}
