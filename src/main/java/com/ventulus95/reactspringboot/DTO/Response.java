package com.ventulus95.reactspringboot.DTO;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@XmlRootElement(name ="response")
public class Response {
    private Header header;
    private Body body;

}