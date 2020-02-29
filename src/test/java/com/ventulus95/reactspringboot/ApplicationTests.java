package com.ventulus95.reactspringboot;

import com.ventulus95.reactspringboot.DTO.BusStopDto;
import com.ventulus95.reactspringboot.DTO.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Value("${data.ServiceKey}")
	private String key;

	@Autowired
	HashMap<String, BusStopDto> checker;

	@Test
	public void contextLoads() {
	}


	@Test
	public void toxext() throws URISyntaxException {
		String url = "http://openapi.tago.go.kr/openapi/service/ArvlInfoInqireService/getSttnAcctoArvlPrearngeInfoList?serviceKey="+key
                +"&cityCode=32010&nodeId=CCB250026559";
		URI uri = new URI(url); //URI 코드 % -> 25 encoding 방지.
		RestTemplate r = new RestTemplate();
//		r.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8"))); //한글깨짐 방지
		System.out.println(r.getForObject(uri, Response.class).getBody().getBusStopDtos().toString());
//		System.out.println(r.getForEntity(uri, String.class));
	}

	@Test
	public void excuteXML() throws URISyntaxException{
		HashMap<String, BusStopDto> transLater = new HashMap<String, BusStopDto>();
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://openapi.tago.go.kr/openapi/service/BusRouteInfoInqireService/getRouteAcctoThrghSttnList?serviceKey="+key
				+"&numOfRows=100&pageNo=1&cityCode=32010&routeId=CCB250030000";
		URI uri = new URI(url); //URI 코드 % -> 25 encoding 방지.
		List<BusStopDto> list = restTemplate.getForObject(uri, Response.class).getBody().getBusStopDtos();
		for (BusStopDto bus300StopDto : list) {
			transLater.put(bus300StopDto.getDirection()+" "+bus300StopDto.getNodenm(), bus300StopDto);
		}
		System.out.println(transLater.get("춘천역 방향 강원대중앙도서관").getNodeid());
	}

}