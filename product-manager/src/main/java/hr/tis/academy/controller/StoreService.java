package hr.tis.academy.controller;

import hr.tis.academy.dto.StoreDto;

import java.time.LocalDate;
import java.util.List;

public interface StoreService {
    StoreDto getStorebyId(Long id);
    List<StoreDto> getAllStores();
    StoreDto addStore(StoreDto store);
    StoreDto updateStore(Long id, StoreDto store);
    void deleteStore(Long id);
    StoreDto partialUpdateStore(Long id, StoreDto store);
    boolean isStoreOpen(Long id, LocalDate date);
}
