package hr.tis.academy.controller;

import hr.tis.academy.dto.StoreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {
    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/{id}")
    public StoreDto getStoreById(@PathVariable long id) {
        return storeService.gerStorebyId(id);
    }

    @GetMapping
    public List<StoreDto> getAllStores() {
        return storeService.getAllStores();
    }

    @PostMapping
    public StoreDto addStore(@RequestBody StoreDto storeDto) {
        return storeService.addStore(storeDto);
    }

    @PutMapping("/{id}")
    public StoreDto updateStore(@PathVariable Long id, @RequestBody StoreDto storeDto) {
        return storeService.updateStore(id,storeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable long id) {
        storeService.deleteStore(id);
    }

    @PatchMapping("/{id}")
    public StoreDto patchStore(@PathVariable Long id, @RequestBody StoreDto storeDto) {
        return storeService.partialUpdateStore(id, storeDto);
    }
}
