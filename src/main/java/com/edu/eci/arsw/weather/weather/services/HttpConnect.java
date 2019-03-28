/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.eci.arsw.weather.weather.services;

import java.io.IOException;

/**
 *
 * @author 2124203
 */
public interface HttpConnect {
    public StringBuffer getCity(String city) throws IOException;
}
