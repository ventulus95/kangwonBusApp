package com.ventulus95.reactspringboot.config;

import com.ventulus95.reactspringboot.DTO.BusStopDto;
import com.ventulus95.reactspringboot.DTO.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

@Configuration
public class WebConfig {
    @Value("${data.ServiceKey}")
    private String key;

    @Bean
    public RestTemplate webRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public HashMap<String, BusStopDto> busStopToNodeid() throws URISyntaxException {
        HashMap<String, BusStopDto> transLater = new HashMap<String, BusStopDto>();
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://openapi.tago.go.kr/openapi/service/BusRouteInfoInqireService/getRouteAcctoThrghSttnList?serviceKey="+key
                +"&numOfRows=100&pageNo=1&cityCode=32010&routeId=CCB250030000";
        URI uri = new URI(url); //URI 코드 % -> 25 encoding 방지.
        List<BusStopDto> list = restTemplate.getForObject(uri, Response.class).getBody().getBusStopDtos();
        for (BusStopDto bus300StopDto : list) {
            transLater.put(bus300StopDto.getDirection()+" "+bus300StopDto.getNodenm(), bus300StopDto);
        }
        return transLater;
    }
}