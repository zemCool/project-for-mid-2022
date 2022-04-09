package com.example.midterm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    private final LaptopRepository laptopRepository;

    @Autowired
    public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }


    public List<Laptop> getLaptops() {
        return laptopRepository.findAll();
    }

    public Laptop getLaptopById(Long laptopId) {
        return laptopRepository.getById(laptopId);
    }

    public void deleteLaptop(Long laptopId) {
        laptopRepository.deleteById(laptopId);
    }

    public Laptop saveLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }
}
