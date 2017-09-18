package com.mit.service;

import com.mit.bean.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICarService {

    public List<Car> findAll();
}
