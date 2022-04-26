package com.example.APIREST.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/stock")
    public void newStock(@RequestBody Stock stock){
        stockService.addNewStock(stock);
    }

    @GetMapping("/stock/{idStore}")
    public List<Stock> getStocks(){
        return stockService.getStocks();


    }

   // @GetMapping("/stock/{{idStore}/{idProduct}")


    @PutMapping("/stock")
    public void updateStock(@RequestBody Stock stock, @PathVariable Long id){
        Stock newStock=stockService.findById(id).get();
        //newStock.setIdStore(newStock.getIdStore());
        //newStock.setIdProduct(newStock.getIdProduct());
        newStock.setQuantité(newStock.getQuantité());

        stockService.update(stock);

    }

  //  @DeleteMapping("/stock/{idStore}/{idProduct}")
    //public void deleteById(@PathVariable Long id){
    //    stockService.deleteById(id);
    //}

    //@PatchMapping("/stock/{{idStore}/{idProduct}")


}
