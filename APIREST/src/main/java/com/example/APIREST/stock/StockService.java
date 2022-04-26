package com.example.APIREST.stock;

import com.example.APIREST.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    private final StockRepository stockRepository;
@Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }


    public List<Stock> getStocks(){
        return stockRepository.findAll();
    }


    public void addNewStock(Stock stock) {
        System.out.println(stock);
    }

    void deleteById(Long id) {
        stockRepository.deleteById(id);
    }

    void update(Stock stock) {
        stockRepository.save(stock);
    }

    Optional<Stock> findById(Long id) {
        return stockRepository.findById(id);
    }
}
