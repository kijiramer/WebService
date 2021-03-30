package com.example.web_service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

@RestController
public class CarRentalService {

    private List<Car> cars = new ArrayList<Car>();

    public CarRentalService() {
        cars.add(new Car("11AA22", "Ferrari", 1000));
        cars.add(new Car("33BB44", "Porshe", 2222));
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Car> listOfCars(){
        return cars;
    }

    @PostMapping("/cars")
    public void addCar(@RequestBody Car car) throws Exception{
        System.out.println(car);
        cars.add(car);
    }


    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception{

        for(Car car : cars) {
            if(car.getPlateNumber().equals(plateNumber)) {
                return car;
            }
        }

        return null;

    }


    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Rent rentAndGetBack(@PathVariable("plateNumber") String plateNumber,
                               @RequestBody Rent rendUser,
                               @RequestParam(value="rent", required = true)boolean rent) throws Exception {

        System.out.println(rendUser);
        System.out.println(plateNumber);
        System.out.println(rent);

        for (Car car : cars) {
            if (car.getPlateNumber().equals(plateNumber)) {
                car.setRent(rent);

                if (car.isRent()) {
                    car.getRents().add(rendUser);
                    return car.getRents().get(car.getRents().size() -1);

                } else {
                    return null;
                }
            }
        }
        return null;
    }
}

