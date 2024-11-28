### **1. 프로젝트 개요**

### (1) **프로젝트 gpt4o_MeelPlan**

- 명확하고 간결하게 프로젝트의 주제를 나타내는 제목을 작성합니다.

### (2) **한 줄 소개**

- 개인 맞춤형 건강 식단 추천 및 관리 서비스

### (3) **팀 구성**

| 이름 | 담당 업무 |  | 연락처 |
| --- | --- | --- | --- |
| 문정현[팀장] | 프론트엔드, 백엔드 | 프로젝트 기획 및 전반적인 관리 |  |
| 한동민[팀원] | 프론트엔드 | UI/UX 설계 및 구현 |  |
| 조연희[팀원] | 백엔드 | DB 설계 |  |

---

### **2. 개발 동기와 목표**

### (1) **개발 동기**

- 인터넷 기반의 개인화된 건강 식단 서비스는 현대 사회에서 급변하는 생활 습관과 다양한 건강 상태에 적응하기 위한 현대인의 필요를 충족시키기 위해 개발되었습니다.
- 이 서비스는 **개인별로 맞춤화된 건강 식단과 영양제 추천을 제공**하는 것을 목표로 하며, 유아부터 노년층까지 광범위한 대상에게 적합한 솔루션을 제공합니다.
- 이를 통해 사용자들은 건강한 생활 방식을 유지하고 개선하며, 사용자 간의 경험 공유와 상호 지원이 가능하도록 커뮤니티를 형성할 수 있습니다.

### (2) **개발 목표**

- 개인화된 건강 식단과 영양제 추천을 통해 사용자들의 건강 관리를 돕는 플랫폼 구축.
    - OpenAI GPT-4.0 모델을 사용하여, 사용자 프로필 정보를 기반으로 아침, 점심, 저녁 맞춤형 식단 추천.
    • 영양제 추천과 영양제 제공을 위한 결제 서비스 구현.

---

### **3. 주요 기능**

- 프로젝트의 핵심 기능을 나열하고 각 기능의 목적과 역할을 간단히 설명합니다.
    - **사용자 프로필 관리**: 나이, 성별, 활동량 등을 입력하여 개인화된 데이터를 생성.
    - **맞춤형 식단 추천**: OpenAI GPT-4를 활용한 식단 생성.
    - **영양제 추천**: 사용자 건강 상태에 맞는 영양제 추천

---

### **4. 기술 스택**

- 사용한 기술과 도구를 항목별로 정리합니다.
    - **Backend**: Spring Boot, MySQL
    - **Frontend**: Thymeleaf, HTML, CSS, SCSS
    - **AI Model**: OpenAI GPT-4 API
    - **Cloud**: Naver Cloud Platform (서버 및 데이터베이스 호스팅)

---

### **5. 시스템 설계**

![스크린샷 2024-11-28 21.55.51.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/62fb3493-e2b2-4aa2-8bdb-1d84e0715988/1f241c7d-901e-4f69-a4cd-09d812bd5466/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-11-28_21.55.51.png)

### (1) **아키텍처 다이어그램**

[[ 유스케이스 다이어그램, 시퀀스 다이어그램 : 구글 드라이브 ]](https://drive.google.com/drive/folders/1grnJnsOIPZPQTHHkRxLKA8CMeJpULECV?usp=drive_link)

### (2) **ERD (Entity Relationship Diagram)**

### (3) **API 설계**

![스크린샷 2024-11-28 21.55.59.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/62fb3493-e2b2-4aa2-8bdb-1d84e0715988/976bd472-19e5-4e9e-95a7-06a57be23ab0/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-11-28_21.55.59.png)

---

### **6. 프로젝트 진행 과정**

### 프로젝트 자료

| 구분 | 작성일 | 상태 | 비고 |
| --- | --- | --- | --- |
| 기획서 | 4.2 | 완료 | 보고서 참고 |
| 요구사항 명세서 | 4.29 | 완료 |  |
| 설계서 | 4.29 | 완료 |  |
| 구현 코드 | 6.21 | 완료 |  |
| 테스트 결과 | 6.21 | 완료 |  |
| 최종 보고서 | 6.21 | 완료 |  |

### 일정 관리

| 단계 | 시작일 | 종료일 | 진행상태 |
| --- | --- | --- | --- |
| 기획 | 2024-03-13 | 2024-04-02 | 완료 |
| 설계 | 2024-04-01 | 2024-04-29 | 완료 |
| 구현 | 2024-05-01 | 2024-06-21 | 완료 |
| 테스트 | 2024-06-15 | 2024-06-21 | 완료 |
| 최종발표 | 2024-06-24 | 2024-06-28 | 완료 |

### (1) 프로젝트 아이템 제안

[[ 프로젝트 아이템 PDF : 구글 드라이브 ]](https://drive.google.com/drive/folders/1grnJnsOIPZPQTHHkRxLKA8CMeJpULECV?usp=drive_link)

### (2) 개발 계획서

[[ 개발 계획서 PDF : 구글 드라이브 ]](https://drive.google.com/drive/folders/1grnJnsOIPZPQTHHkRxLKA8CMeJpULECV?usp=drive_link)

### (3) **테스트 및 수정**

1. [[ 모델 테스트 : repo/openai ]](https://github.com/MungJeoNyeon/openai/blob/main/README.md)
2. 서버 테스트

![스크린샷 2024-11-26 15.34.42.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/62fb3493-e2b2-4aa2-8bdb-1d84e0715988/eebb8043-e88b-4bda-a24f-36af38449dc3/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-11-26_15.34.42.png)

![스크린샷 2024-11-28 22.48.00.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/62fb3493-e2b2-4aa2-8bdb-1d84e0715988/e4d60de7-5820-4acb-af98-e8c3f12f1e17/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-11-28_22.48.00.png)

---

### **7. 프로젝트 결과**

### (1) **성과**

[[ 발표 PDF : 구글 드라이브 ]](https://drive.google.com/drive/folders/1grnJnsOIPZPQTHHkRxLKA8CMeJpULECV?usp=drive_link)

[[ 보고서 docx : 구글 드라이브 ]](https://drive.google.com/drive/folders/1grnJnsOIPZPQTHHkRxLKA8CMeJpULECV?usp=drive_link)

[[ team5-0.0.1-SNAPSHOT.jar.zip : 구글 드라이브 ]](https://drive.google.com/drive/folders/1grnJnsOIPZPQTHHkRxLKA8CMeJpULECV?usp=drive_link)

```java
성과 :
성적 B+
개발 계획서의 90% 달성

한계 및 개선점 :
자신을 돌아봤을 때 삶의 지혜가 부족함.
-> '책을 읽자' notion space를 통해 지식을 쌓자.
```

---

### **8. 참고 자료**

- [오픈ai cookbook](https://cookbook.openai.com/)
- [오픈ai docs](https://platform.openai.com/docs/overview)
- [네이버 클라우드 플랫폼](https://www.ncloud.com/)

---

### **추가 팁**

1. **비주얼 자료 활용**:
    - [피그마 url](https://www.figma.com/files/team/1355447708285249940/project/219137301/Team-project?fuid=1253971037652292138)
2. **공유 및 피드백**:
    - 팀원들과 내용을 공유하고 피드백을 반영하여 문서를 보완하세요.

---
