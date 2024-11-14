# 🤖 KAKAO WEBTOON-Android 🤖
> AND SOPT 35th 합동 세미나 앱 9조 Android팀 <br>

![image](https://github.com/user-attachments/assets/bf1e8920-157e-4f04-a20e-6320b24df674)

## 🍨 *****Contributors*****
| 신민석 <br>[@t1nm1ksun](https://github.com/t1nm1ksun) |             김종명 <br>[@jm991014](https://github.com/jm991014)            |              송민서 <br>[@MinseoSONG](MinseoSONG)               |
|:---:|:-----------------------------------------------------------------------------:|:-----------------------------------------------------------------------------:|
| <img width="250" src="https://avatars.githubusercontent.com/u/122257945?v=4"/> |<img width="250" src="https://avatars.githubusercontent.com/u/122257945?v=4"/> | <img width="250" src="https://avatars.githubusercontent.com/u/122257945?v=4"/> |
| `View1 ()` | `View2 ()`| `View3 ()`|


## 📗 *****Convention*****
<aside>
1️⃣ Git Convention

- `feat` : 구현
- `refactor` : 리팩토링
- `init` : 초기세팅
- 예시) feat-home-ui (feat-어디서-무엇을)
feat-my-page-api
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
┣ 📂 domain
┃ ┣ 📂 model
┃ ┣ 📂 repository
┣ 📂 presentation
┃ ┣ 📂 common
┃ ┣ 📂 model
┃ ┣ 📂 type
┃ ┣ 📂 ui
┃ ┃ ┣ 📂 main
┃ ┃ ┣ 📂 productdetail
┃ ┃ ┣ 📂 search
┣ 📂 theme
┣ 📂 util
┃ ┣ 📂 base
┃ ┣ 📂 component
┃ ┣ 📂 context
┃ ┣ 📂 fragment
┃ ┣ 📂 int
┃ ┣ 📂 intent
┃ ┣ 📂 modifier
```
