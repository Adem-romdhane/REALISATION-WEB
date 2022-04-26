package com.example.APIREST.store;

import com.example.APIREST.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {

    private final  StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }


    @PostMapping("/store")
    public void NewStore(@RequestBody Store store){
        storeService.addNewStore(store);
    }

    @GetMapping("/store/{id}")
    public List<Store> getStores(){
        return storeService.getStores();

    }

    @PutMapping("/store")
    public void updateStore(@RequestBody Store store, @PathVariable Long id){
        Store storeUpdate=storeService.findById(id).get();
         storeUpdate.setAdresse(store.getAdresse());
        storeUpdate.setName(store.getName());
        storeUpdate.setSIRET(store.getSIRET());

        storeService.updateStore(storeUpdate);

    }


    @DeleteMapping("/store/{id}")
    public void deleteById(@PathVariable Long id){
        storeService.deleteById(id);
    }
    @PatchMapping("/store/{id}/activate")
    public @ResponseBody
    ResponseEntity<Object> activate(@PathVariable Long id, @PathVariable Boolean activate){
        Boolean active= storeService.activeUser(activate);
        Store store;
        if (activate == Boolean.TRUE) {
             store= (Store) storeService.findById(id).get();
             store.setActive(true);
            ResponseEntity.status(201).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return null;
    }

    @PatchMapping("/store/{id}/desactivate")
    public @ResponseBody
    ResponseEntity<Object> desactivate(@PathVariable Long id, @PathVariable Boolean desactivate) {
        Boolean active = storeService.desactiveUser(desactivate);

        Store store;
        if (desactivate == Boolean.TRUE) {
            store = (Store) storeService.findById(id).get();
            store.setActive(true);
            ResponseEntity.status(201).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return null;

    }


}
