package hr.tis.academy.controller;

import hr.tis.academy.dto.AddressDto;
import hr.tis.academy.dto.StoreDto;
import hr.tis.academy.dto.WorkingDayDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StoreServiceImpl implements StoreService {

    private  final  Map<Long, StoreDto> storeMap = new HashMap<>();
    private  Long currentId = 1L;


    @PostConstruct
    public void init() {
        storeMap.put(currentId, new StoreDto(
                currentId++,
                "7-eleven",
                new AddressDto("New York", "USA", "5th Avenue", "101"),
                "01-234-567-8900",
                "info@seveneleven.com",
                List.of(
                        new WorkingDayDto("MONDAY", LocalTime.of(9, 0), LocalTime.of(17, 0)),
                        new WorkingDayDto("TUESDAY", LocalTime.of(9, 0), LocalTime.of(17, 0))
                )
        ));

        storeMap.put(currentId, new StoreDto(
                currentId++,
                "MegaMart",
                new AddressDto("Los Angeles", "USA", "Sunset Boulevard", "202"),
                "01-345-6789",
                "info@megamart.com",
                List.of(
                        new WorkingDayDto("WEDNESDAY", LocalTime.of(10, 0), LocalTime.of(18, 0)),
                        new WorkingDayDto("THURSDAY", LocalTime.of(10, 0), LocalTime.of(18, 0))
                )
        ));

        storeMap.put(currentId, new StoreDto(
                currentId++,
                "SuperShop",
                new AddressDto("Chicago", "USA", "State Street", "303"),
                "01-456-7890",
                "info@supershop.com",
                List.of(
                        new WorkingDayDto("FRIDAY", LocalTime.of(11, 0), LocalTime.of(19, 0)),
                        new WorkingDayDto("SATURDAY", LocalTime.of(11, 0), LocalTime.of(15, 0))
                )
        ));
    }

    @Override
    public StoreDto gerStorebyId(Long id) {
        return storeMap.get(id);
    }

    @Override
    public List<StoreDto> getAllStores() {
        return new ArrayList<>(storeMap.values());
    }

    @Override
    public StoreDto addStore(StoreDto store) {
        store.setId(currentId++);
        storeMap.put(store.getId(), store);
        return store;
    }

    @Override
    public StoreDto updateStore(Long id, StoreDto store) {
        if(storeMap.containsKey(id)){
            store.setId(id);
            storeMap.put(id, store);
            return store;
        }
        return null;
    }

    @Override
    public void deleteStore(Long id) {
        storeMap.remove(id);
    }

    @Override
    public StoreDto partialUpdateStore(Long id, StoreDto store) {
        StoreDto existingStore = storeMap.get(id);
        if(existingStore == null){
            return null;
        }

        if(store.getStoreName() != null){
            existingStore.setStoreName(store.getStoreName());
        }
        if(store.getAddress() != null){
            existingStore.setAddress(store.getAddress());
        }
        return existingStore;
    }
}
