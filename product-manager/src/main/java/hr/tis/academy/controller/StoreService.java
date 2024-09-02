package hr.tis.academy.controller;

import hr.tis.academy.dto.StoreDto;

import java.util.List;

public interface StoreService {
    StoreDto gerStorebyId(Long id);
    List<StoreDto> getAllStores();
    StoreDto addStore(StoreDto store);
    StoreDto updateStore(Long id, StoreDto store);
    void deleteStore(Long id);
    StoreDto partialUpdateStore(Long id, StoreDto store);
}
