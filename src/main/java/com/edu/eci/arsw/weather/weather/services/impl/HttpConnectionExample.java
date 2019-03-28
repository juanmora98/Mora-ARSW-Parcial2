/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.eci.arsw.weather.weather.services.impl;
import com.edu.eci.arsw.weather.weather.services.HttpConnect;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;



@Component
public class HttpConnectionExample implements HttpConnect{

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=a44dcb535c255cdb066f651b7831b146";

    private ConcurrentHashMap<String, StringBuffer> cache;
    
    
    /**
     * 
     * @throws IOException 
     */
    public HttpConnectionExample() {
        cache = new ConcurrentHashMap<>();
            
    }
    
    
    
    private StringBuffer getData(URL url) throws IOException{
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response;
        } else {
            System.out.println("GET request not worked");
            return null;
        }
    }
    
    

    @Override
    public StringBuffer getCity(String city) throws IOException {
        if(cache.containsKey(String.format(GET_URL,city))){
            return cache.get(String.format(GET_URL,city));
        }else{
            URL obj = new URL(String.format(GET_URL,city));
            return getData(obj);
        }
    }

    
    
//    if (responseCode == HttpURLConnection.HTTP_OK) { // success
//            BufferedReader in = new BufferedReader(new InputStreamReader(
//                    con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//
//            // print result
//            System.out.println(response.toString());
//        } 
    
    
    
}