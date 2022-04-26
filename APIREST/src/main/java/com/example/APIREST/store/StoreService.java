package com.example.APIREST.store;

import com.example.APIREST.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> getStores(){
        return storeRepository.findAll();
    }


    public void addNewStore(Store store) {
        System.out.println(store);
    }

    void deleteById(Long id) {
        storeRepository.deleteById(id);
    }

    void updateStore(Store store) {
        storeRepository.save(store);
    }

    Optional<Store> findById(Long id) {
        return storeRepository.findById(id);
    }

    public Boolean activeUser(Boolean activate) {
        return activate;
    }

    public Boolean desactiveUser(Boolean desactivate) {
        return desactiveUser(desactivate);
    }

}
