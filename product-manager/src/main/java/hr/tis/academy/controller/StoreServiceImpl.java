package hr.tis.academy.controller;

import hr.tis.academy.dto.AddressDto;
import hr.tis.academy.dto.StoreDto;
import hr.tis.academy.dto.WorkingDayDto;
import hr.tis.academy.model.Address;
import hr.tis.academy.model.ProductsMetadata;
import hr.tis.academy.model.Store;
import hr.tis.academy.model.WorkingDay;
import hr.tis.academy.repository.ProductRepository;
import hr.tis.academy.repository.ProductsMetadataRepository;
import hr.tis.academy.repository.StoreRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StoreServiceImpl implements StoreService {

    //private  final  Map<Long, StoreDto> storeMap = new HashMap<>();
    private final StoreRepository storeRepository;
    //private  Long currentId = 1L;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }
    @PostConstruct
    public void init() {
        WorkingDay workingDay = new WorkingDay("MONDAY", LocalTime.of(9, 0), LocalTime.of(17, 0));

        Store store = new Store(
                "7-eleven",
                new Address("New York", "USA", "5th Avenue", "101"),
                "01-234-567-8900",
                "info@seveneleven.com",
                List.of(
                        new WorkingDay("MONDAY", LocalTime.of(9, 0), LocalTime.of(17, 0)),
                        new WorkingDay("TUESDAY", LocalTime.of(9, 0), LocalTime.of(17, 0))
                )
        );
        storeRepository.save(store);
/*
        storeRepository.save(new Store(
                "MegaMart",
                new Address("Los Angeles", "USA", "Sunset Boulevard", "202"),
                "01-345-6789",
                "info@megamart.com",
                List.of(
                        new WorkingDay(3L,"WEDNESDAY", LocalTime.of(10, 0), LocalTime.of(18, 0)),
                        new WorkingDay(4L,"THURSDAY", LocalTime.of(10, 0), LocalTime.of(18, 0))
                )
        ));

        storeRepository.save(new Store(
                "SuperShop",
                new Address("Chicago", "USA", "State Street", "303"),
                "01-456-7890",
                "info@supershop.com",
                List.of(
                        new WorkingDay(5L,"FRIDAY", LocalTime.of(11, 0), LocalTime.of(19, 0)),
                        new WorkingDay(6L,"SATURDAY", LocalTime.of(11, 0), LocalTime.of(15, 0))
                )
        ));*/
    }
    public StoreDto storeToStoreDTO(Store store) {
        return new StoreDto(store.getId(), store.getStoreName(), store.getAddress(), store.getTelephoneNumber(),
                store.getEmail(), store.getWorkingDays());
    }

    public Store storeDTOtoStore(StoreDto storeDto) {
        return new Store(storeDto.getStoreName(), storeDto.getAddress(), storeDto.getTelephoneNumber(),
                storeDto.getEmail(), storeDto.getWorkingDays());
    }

    @Override
    public StoreDto gerStorebyId(Long id) {
        Store s = storeRepository.findById(id).get();
        return storeToStoreDTO(s);
    }

    @Override
    public List<StoreDto> getAllStores() {
        List<Store> s = storeRepository.findAll();
        List<StoreDto> dtos = new ArrayList<>();
        for (Store store : s) {
            dtos.add(storeToStoreDTO(store));
        }
        return dtos;
    }

    @Override
    public StoreDto addStore(StoreDto store) {
        //store.setId(currentId++);
        //storeMap.put(store.getId(), store);
        storeRepository.save(storeDTOtoStore(store));
        return store;
    }

    @Override
    public StoreDto updateStore(Long id, StoreDto store) {
        /*if(storeMap.containsKey(id)){
            store.setId(id);
            storeMap.put(id, store);
            return store;
        }*/
        Store s = storeRepository.findById(id).get();
        s.setStoreName(store.getStoreName());
        s.setAddress(store.getAddress());
        s.setTelephoneNumber(store.getTelephoneNumber());
        s.setEmail(store.getEmail());
        s.setWorkingDays(store.getWorkingDays());
        storeRepository.save(s);
        return null;
    }

    @Override
    public void deleteStore(Long id) {
        //storeMap.remove(id);
        storeRepository.deleteById(id);
    }

    @Override
    public StoreDto partialUpdateStore(Long id, StoreDto store) {
        //StoreDto existingStore = storeMap.get(id);
        Store existingStore = storeRepository.findById(id).get();
        if(storeRepository.findById(id).isPresent()){
            return null;
        }
        if(store.getStoreName() != null){
            existingStore.setStoreName(store.getStoreName());
        }
        if(store.getAddress() != null){
            existingStore.setAddress(store.getAddress());
        }
        if(store.getTelephoneNumber() != null){
            existingStore.setTelephoneNumber(store.getTelephoneNumber());
        }
        if(store.getEmail() != null){
            existingStore.setEmail(store.getEmail());
        }
        if(store.getWorkingDays() != null){
            existingStore.setWorkingDays(store.getWorkingDays());
        }
        storeRepository.save(existingStore);
        return storeToStoreDTO(existingStore);
    }
}
