<h1  align="center">🚌 강원대학교 300 BUS 알림이 🚌</h1>

<p align="center"> 강원대 300번 버스 알림 웹앱 </p>



&nbsp;

<!-- TABLE OF CONTENTS -->

## 목차

* [프로젝트에 대하여](#프로젝트에-대하여)
  * [왜 이프로젝트를 기획했는가?](#왜-이-프로젝트를-기획했었는가)
* [기술 스택](#기술-스택)
*  [Getting Started](#getting-started)
*  [Details](#details)
*  *  [Description](#description)
   *  [Architecture](#architecture)
   *  [Demo](#demo)
   *  [Run](#Run)
   *  [Deploy](#deploy)
*  [Contributers](#Contributers)&nbsp;

&nbsp;&nbsp;

## 프로젝트에 대하여


### 왜 이 프로젝트를 기획했었는가?

강원대학교에 직통을 가는 버스는 지난 19년도 11월 중반쯤부터 지나다니기 시작했습니다. 문제는 이 버스가 언제 오는지 정확하게 파악하기가 **그당시에는 어려웠습니다.**  그래서 버스 알림앱을 만들어서 배포 혹은 출시를 해보면 어떨까라는 마음에 제작하게 되었습니다.

(물론 버스가 처음 돌아다닐때 쯔음에는 네이버 지도나 카카오 지도에는 안떴지만 현재는 모두 뜨고 있습니다.)

&nbsp;

### 기술 스택

- Java 8
- Spring Boot 2.2.4.RELEASE
- React 
- Maven

 &nbsp;

## Getting Started

 &nbsp;

## Details

### Description

 - API : [공공데이터포털](https://www.data.go.kr/) 중 오픈 API인  [도착정보조회서비스](https://www.data.go.kr/dataset/15000758/openapi.do?mypageFlag=Y) 와 [버스노선정보조회서비스](https://www.data.go.kr/dataset/15000758/openapi.do?mypageFlag=Y)
   <br>
    공공 데이터 포털에서 버스노선 정보조회서비스로 강원대학교 300번 버스 노선을 조회후 각 정류장마다의 도착시간을 도착정보조회 서비스로 불러들여 도착하는 시간을 체크합니다.

   <br>


 &nbsp;

&nbsp;

### Architecture

<사진 필요>

Spring Boot가 백엔드 Rest API서버를 담당하고 특정 URL에 따라서 JSON 값을 파싱해서 전달합니다. 그것을 React가 그 JSON값을 받아 화면을 구성합니다. 

&nbsp;

### Demo

<br>

### Run

1. 실행시키기 전 주의사항 `src/main/resources/application.yml` 의 키값이 있기 때문에 `application.yml` 파일을 생성해주셔야지 오류가 발생하지 않습니다.

   ```yml
   spring:
     thymeleaf.cache: false
     template.cache: false
   
   data:
     ServiceKey: [자기가 가지고있는 공공데이터 포털의 API 키값]
   ```

2. Run시 `ReactspringbootApplication` 를 직접 Run하여도 작동합니다.

   ![스크린샷 2020-03-02 오후 12 11 52](https://user-images.githubusercontent.com/17822723/75642485-056f3e80-5c7f-11ea-8e3c-0d55ace5d78a.png)


   

3. 혹은 Maven의 plug-in의 `Spring-boot:run` 을 이용해도 정상적으로 작동합니다.

   ![스크린샷 2020-03-02 오후 12 05 08](https://user-images.githubusercontent.com/17822723/75642225-19667080-5c7e-11ea-8170-4600262d0691.png)

### Deploy

1. 빌드를 하기 위해서는 Maven의 Install을 이용합니다.

`reactspringboot-0.0.1-SNAPSHOT.jar` 파일명이 저장됩니다. 

명령어인 `./mvnw clean install`를 이용하거나

![스크린샷 2020-03-02 오전 11 49 45](https://user-images.githubusercontent.com/17822723/75641550-f5a22b00-5c7b-11ea-9a86-9e04b9d143ba.png)

이미지 속의 install 이용합니다. 

간혹 이전 build가 그대로 이용되는 경우가 발생할 수도 있으므로 Clean후 Install 해주시는걸 권장합니다. 


&nbsp;

2. 파일 저장 위치

   파일은 `target/reactspringboot-0.0.1-SNAPSHOT.jar` 에 있고 `src` 폴더와 동일위치에 생성됩니다.

&nbsp;

3. 서버에 올리는 작업
   FTP 서버와 SSH를 이용하는 방법 중 SSH 선택합니다.

scp : `scp 파일주소 [ID명]@[IP주소]:[서버의폴더경로]` 를 통해서 옮깁니다.

&nbsp;

4. <b>실행 </b>


    java -jar [파일명.jar]

![스크린샷 2019-11-25 오전 12 35 49](https://user-images.githubusercontent.com/17822723/69497008-8c43ab00-0f1b-11ea-98a6-24c49e029128.png)



## Contributers

- 개발
  - 이창섭 ([ventulus95](https://github.com/ventulus95)) 
  - 김종원 ([solo95](https://github.com/solo95))
