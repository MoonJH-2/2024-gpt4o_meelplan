# 개인화된 건강 식단 서비스

## 시스템 개요

### 1.1 개발 동기
인터넷 기반의 개인화된 건강 식단 서비스는 현대 사회에서 급변하는 생활 습관과 다양한 건강 상태에 적응하기 위한 현대인의 필요를 충족시키기 위해 개발되었습니다.  
이 서비스는 **개인별로 맞춤화된 건강 식단과 영양제 추천을 제공**하는 것을 목표로 하며, 유아부터 노년층까지 광범위한 대상에게 적합한 솔루션을 제공합니다.  

이를 통해 사용자들은 건강한 생활 방식을 유지하고 개선하며, 사용자 간의 경험 공유와 상호 지원이 가능하도록 커뮤니티를 형성할 수 있습니다.

---

### 1.2 개발 목표
- 웹 브라우저를 통한 개인 맞춤 식단 데이터 제공.
- 영양제 추천과 영양제 제공을 위한 결제 서비스 구현.
- **OpenAI GPT-4.0 모델**을 사용하여, 사용자 프로필 정보를 기반으로 아침, 점심, 저녁 맞춤형 식단 추천.

---

## 주요 기능
1. **사용자 맞춤 식단 추천**
   - 사용자의 나이, 키, 체중, 활동량 등 프로필 정보를 기반으로 GPT-4.0을 활용해 맞춤형 식단 생성.
   
2. **영양제 추천**
   - 건강 상태에 따라 필요한 영양제를 분석하고 추천.

---

. **결제 서비스**
   - 추천된 식단과 영양제 구매를 위한 결제 시스템 제공.

. **건강 커뮤니티**
   - 사용자들이 경험을 공유하고 상호 지원할 수 있는 커뮤니티 기능.

---

## 기술 스택
- **Backend**: Spring Boot, JPA, MySQL
- **Frontend**: Thymeleaf, HTML, CSS, SCSS
- **AI Model**: OpenAI GPT-4.0
- **Database**: MySQL
- **Cloud Platform**: Naver Cloud Platform (서버 및 데이터베이스 호스팅)

---

## 프로젝트 실행 방법

### 1. 프로젝트 클론
```bash
git clone https://github.com/MoonJH-2/Graduation-work.git
cd Graduation-work
```

### 2. 환경 변수 설정
- 프로젝트 루트 디렉토리에 `.env` 파일을 생성하고 `.env.example` 참고하여 환경 변수를 추가하세요.

### 3. Naver Cloud Platform에서 서버 설정
1. 노션 url 참고 부탁드립니다.

### 4. 애플리케이션 실행
1. 로컬에서 실행:
   ```bash
   ./gradlew bootRun
   ```

2. 서버에 배포 후 실행:
   - Spring Boot JAR 파일을 빌드하여 서버에 업로드합니다:
     ```bash
     ./gradlew build
     scp build/libs/<your-application-name>.jar <server-username>@<server-ip>:/path/to/deploy
     ```
   - 서버에서 실행:
     ```bash
     java -jar /path/to/deploy/<your-application-name>.jar
     ```
