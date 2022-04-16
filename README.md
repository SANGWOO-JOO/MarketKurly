# Market Kurly_Clone_Coding
마켓컬리 API 서버 개발(팀 프로젝트)

## 마켓컬리 API 서버 개발 
> 팀 프로젝트
- 시연 영상 : https://youtu.be/3E8qkl9ZTp8
- API 명세서: https://docs.google.com/spreadsheets/d/1BQwtbdP-mowTQb2jhn_qnb7cYjyC0OpB/edit#gid=990061567
- ERD 설계도: https://aquerytool.com/aquerymain/index/?rurl=78da7625-99c1-4f09-9871-4dcce1f33241
    - 비밀번호 : ldf34n   

### 제작 기간 & 참여 인원
- 2021년 1월 8일 ~ 1월 21일  
- 팀 프로젝트 역할 분담 
    - IOS 개발자 1명
    - 서버 개발자 2명 (서버 파트에 참여)

- 메소드 네이밍룰
  이 템플릿에서는 사용되는 메소드 명명 규칙은 User 도메인을 참고하자. 항상 이 규칙을 따라야 하는 것은 아니지만, 네이밍은 통일성 있게 해주는 게 좋다.

### 사용 기술
#### `Language`
  - Java 15
  - Spring Boot 
  - Gradle
  - Spring Data JDBC 
#### `Environment`  
  - AWS EC2 (Ubuntu 20.04)  
#### `Database`  
  - RDS (Mysql 8.0)

### 기능 구현
> 마켓컬리의 기능을 구현하였습니다.
> 주요 기능으로 상품을 조회하고 등록하고 클라이언트가 상품을 장바구니에 넣고 선물할 수가 있습니다.

### 개발 범위

- 회원가입
- 로그인, 로그아웃
- 아이디찾기 ( 이메일, 전화번호 )
- 비밀번호찾기 (이메일, 전화번호 )
- 마이컬리 ( 비회원, 회원 )
    - 회원 정보 화면 표시
    - 전체등급 보기, 다음달 예상등급 보기, 알림설정, 찜한 상품, 친구초대, 배너, 선물내역, 공지사항, 고객센터, 이용안내
    - 가입혜택보기, 컬리 퍼플 박스, 컬리 소개, 컬리패스, 배송안내
    
- 배송지
    - 배송지 선택
    - 배송지 관리
    - 배송지 추가
    - 배송지 수정, 삭제
    - 주문서에서 배송정보 입력,수정 부분
- 주문
    - 주문서 작성
    - 주문 내역 리스트
    - 주문 내역
    - 주문 내역 상세
    - 주문 상세 부분
    - 자주 사는 상품
    - 주문 후 결과 화면
- 장바구니
- 홈
    - 컬리추천 화면 ( 상품 리스트 )
        - 타이머 기능 구현
    - 신상품
    - 베스트
    - 알뜰쇼핑
    - 특가/혜택
- 카테고리
- 검색
 - 검색 첫 화면
 - 검색어를 입력만 했을 때 나타나는 검색 리스트
 - 검색어를 입력 후 나타나는 결과 리스트
- 상품 상세페이지
    - 상품설명
    - 상품정보
    - 상품 선택
    - 상품 후기
    - 후기 보기
    - 상품 문의하기
    - 문의 작성하기
- 쿠폰
    - 쿠폰 다운로드
    - 쿠폰 등록
    - 쿠폰 내역
- 이벤트
    - 이벤트 
- 적립금 내역

