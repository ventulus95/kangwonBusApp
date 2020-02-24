package com.ventulus95.reactspringboot.DTO;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@XmlRootElement(name = "item")
public class BusStopDto {
    //버스 전용 데이터.
    private String nodeid;
    private String routeno;
    private String routetp;
    private int arrprevstationcnt;
    private String vehicletp;
    private int arrtime;
    //BUS 정류장 앱용.
    private Double gpslati;
    private Double gpslong;
    private String nodenm; // 필요한 Key값.
    private int nodeno;
    private int nodeord;
    private String routeid;
    private int updowncd; //0 남춘천, 1 춘천역 방향. -> Setter로 String값을 받는 방법이 있음.
    private String direction;

    public void setArrtime(int arrtime) {
        this.arrtime = arrtime/60;
    }

    public void setUpdowncd(int updowncd) {
        this.updowncd = updowncd;
        setDirection(updowncd);
    }

    public void setDirection(int updowncd) {
        if(updowncd == 0 ){
            this.direction = "남춘천역 방향";
        }
        else{
            this.direction = "춘천역 방향";
        }
    }
}