package com.ventulus95.reactspringboot.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
@XmlRootElement(name = "body")
public class Body {
    private List<BusStopDto> busStopDtos;
    private int numOfRows;
    private int pageNo;
    private int totalCount;

    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    public List<BusStopDto> getBusStopDtos() {
        return busStopDtos;
    }
}