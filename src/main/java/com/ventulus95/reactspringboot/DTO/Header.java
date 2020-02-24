package com.ventulus95.reactspringboot.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Header {
    private String resultCode;
    private String resultMsg;
}