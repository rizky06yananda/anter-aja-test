package com.test.rizky.repository;

import com.test.rizky.domain.MasterPrice;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface MasterPriceRepository extends PagingAndSortingRepository<MasterPrice, String> {
}
