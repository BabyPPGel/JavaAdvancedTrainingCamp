package io.kimmking.javacourse.demo.controller;

import io.kimmking.javacourse.demo.service.InsertDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsertDataController {
    @Autowired
    private InsertDataService insertDataService;
    @RequestMapping(value = "/saveData")
    public void saveData(){
        insertDataService.saveData();
        System.out.println("111111111111111111111111");
    }
    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}
