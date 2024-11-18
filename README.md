# 🤖 KAKAO WEBTOON-Android 🤖
> AND SOPT 35th 합동 세미나 앱 9조 Android팀 <br>

![image](https://github.com/user-attachments/assets/bf1e8920-157e-4f04-a20e-6320b24df674)

## 🍨 *****Contributors*****
| 신민석 <br>[@t1nm1ksun](https://github.com/t1nm1ksun) |             김종명 <br>[@jm991014](https://github.com/jm991014)            |              송민서 <br>[@MinseoSONG](MinseoSONG)               |
|:---:|:-----------------------------------------------------------------------------:|:-----------------------------------------------------------------------------:|
| <img width="250" src="https://avatars.githubusercontent.com/u/122257945?v=4"/> | <img width="250" src="https://github.com/user-attachments/assets/73035da5-3642-402a-abe0-2af88ead5bb7"/> | <img width="250" src="https://github.com/user-attachments/assets/550a52f7-097a-4e3a-a954-2714500aaf12"/> |
| `SearchView,StorageView` | `HomeView`| `EpisodeView`|


## 📗 *****Convention*****
<aside>
1️⃣ Git Convention
    
[branch]
- `feat` : 구현
- `refactor` : 리팩토링
- `init` : 초기세팅
- 예시) feat-home-ui (feat-어디서-무엇을)
feat-my-page-api

[commit]
- [feat] #이슈번호: 뭐했지롱(ex: 공통 텍스트필드 컴포넌트 구현)
</aside>

<aside>
2️⃣ Android Coding Convention

- 컴포즈 함수: 파스칼 케이스
    - 컴포넌트 이름 (어디에 쓰이는 뭔지)
    ex) HomeViewMovieList
    공통으로 쓰이면→ BaseTextField
- 변수,일반 함수: 카멜 케이스
    - 함수 - 동사
    - 변수 - 명사
- Drawable 리소스 파일: 스네이크 케이스
    - 이미지 → 종류-어디서-무엇을-색상 or 크기
    ex) img_home_right_arrow_white_12
- 아이콘→ 피그마에서 SVG(벡터)로 추출
이미지 → SVG로 추출(피그마에서 x3 PNG로 추출)
</aside>

<aside>
3️⃣ Issue 및 PR Convention

- 과제 템플릿이랑 똑같이
- 머지는 두명이상 어푸
</aside>





## 📁 *****Foldering*****

```
📂 org.sopt.kakaowebtoon
┣ 📂 data
┃ ┣ 📂 datasource
┃ ┣ 📂 datasourceimpl
┃ ┣ 📂 mapper
┃ ┣ 📂 model
┃ ┃ ┣ 📂 request
┃ ┃ ┣ 📂 response
┃ ┣ 📂 repository
┃ ┣ 📂 service

┣ 📂 di
┣ 📂 domain
┃ ┣ 📂 model
┃ ┣ 📂 repository
┃ ┣ 📂 usecase
┣ 📂 presentation
┃ ┣ 📂 model
┃ ┣ 📂 ui

┃ ┃ ┣ 📂 component
┃ ┃ ┣ 📂 main
┣ 📂 theme
┣ 📂 util
```
