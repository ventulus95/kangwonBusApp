package com.ventulus95.reactspringboot.Controller;

import com.ventulus95.reactspringboot.DTO.BusStopDto;
import com.ventulus95.reactspringboot.Service.BusArriveTime;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.HashMap;

@RestController
public class RestapiController {

    final RestTemplate restTemplate;
    final BusArriveTime service;
    final HashMap<String, BusStopDto> transStopToNode;

    public RestapiController(RestTemplate restTemplate, BusArriveTime service, HashMap<String, BusStopDto> transStopToNode) {
        this.restTemplate = restTemplate;
        this.service = service;
        this.transStopToNode = transStopToNode;
    }

    @GetMapping(value = "/busStop/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BusStopDto busArrrivalTime(@PathVariable String id) throws URISyntaxException {
        String nodeId = transStopToNode.get(id).getNodeid();
        BusStopDto busTime = service.arrivedTime(nodeId, restTemplate);
        return busTime;

    }

}