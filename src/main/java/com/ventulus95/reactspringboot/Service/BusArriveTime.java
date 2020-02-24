package com.ventulus95.reactspringboot.Service;

import com.ventulus95.reactspringboot.DTO.BusStopDto;
import com.ventulus95.reactspringboot.DTO.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
@EnableScheduling
public class BusArriveTime {
    @Value("${data.ServiceKey}")
    private String key;

    public BusStopDto arrivedTime(String nodeid, RestTemplate restTemplate) throws URISyntaxException {
        String url = "http://openapi.tago.go.kr/openapi/service/ArvlInfoInqireService/getSttnAcctoArvlPrearngeInfoList?serviceKey="+key
                +"&cityCode=32010&nodeId="+nodeid;
        URI uri = new URI(url); //URI 코드 % -> 25 encoding 방지.
        List<BusStopDto> list = restTemplate.getForObject(uri, Response.class).getBody().getBusStopDtos();
        if(list.size() >0 ) {
            for (int i = 0; i < list.size(); i++) {
                BusStopDto busStop = list.get(0);
                if (busStop.getRouteno().equals("300")) {
                    return busStop;
                }
            }
        }
        return new BusStopDto();

    }
}