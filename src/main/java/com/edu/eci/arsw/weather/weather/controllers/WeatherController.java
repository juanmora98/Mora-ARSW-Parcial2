/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.eci.arsw.weather.weather.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.edu.eci.arsw.weather.weather.services.WeatherServices;

/**
 *
 * @author 2124203
 */

@RestController
@RequestMapping("/weather")
public class WeatherController {
    
    
    
    @Autowired
    private WeatherServices weatherServices;

    @ResponseBody
    @RequestMapping(value="/{city}",method = RequestMethod.GET)
    public ResponseEntity<?> getWeather(@RequestBody String city){
        try{
            return new ResponseEntity<>(weatherServices.getCity(city), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
}
