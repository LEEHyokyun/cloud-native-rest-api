# Notes.

- Spring Boot 3.3.2 ver
- Java 21 ver

## 1.  개요

> Cloud Natvie

Spring Cloud Native로 이어지는 시스템 구축을 위해 단계적으로 개발 역량을 함양하기 위한 프로젝트이다.

그 첫번째 단계로 Spring Boot를 통해 구축하는 Rest api에 대한 내용이다.

모든 내용의 본론적인 부분, 과정 및 원리에 대한 내용은 벨로그에 기술하며, 결과론적인 내용은 슬라이드 혹은 Readme에 간략하게 정리하도록 한다.

## 2. REST = Representative of Resource.

자원의 상호작용 상태를 HTTP 프로토콜에 의해 정립한 상태에 기반하여 통신, 상호작용을 하는 과정이다.

전통적인 XML방식의 SOAP(Simple Object Application Protocol) 방식에서, 
</br>
가볍고 효율적인 JSON 방식의 REST API(endPoint 구성을 통한 자원 공유) 방식으로 시스템 구축을 진행하고 있다.

> Notes

- ResponseEntity, RequestBody 편리하지만 쉽게 지나칠 수 있는 항목들
- CREATE/UPDATE/DELETE 등 POST METHOD 이후의 상태를 이어서 확인하고자 하는 방법
  - `ServletUriComponentsBuilder
- Spring AOP를 활용한 상태 재정의(UserNotFound = NG = ExceptionHandling)
  - 서버 오류가 아닌 존재하지 않은 데이터를 요청한 Client의 잘못으로 위임
  - 특정 Exception을 Customized하여 throw(ExceptionResponse)
  - 특정 상황에 대해 의도한 Exception throw 시 상태코드 및 상태메시지 등을 generic하게 가공(ExcetionResponse/ControllerAdvice)