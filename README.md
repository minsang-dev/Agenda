## Agenda 🌵
### dev 일정 관리 앱 서버 만들기
---
## 일정 API
| 기능         | Method | API PATH             | Response   | 상태코드 : 성공 | 상태코드 : 실패 |
| ------------- | ------ | ------------------- | --------- | --------------- | ------------ |
| 일정 등록      | POST   | /api/agendas       |  등록 정보 | 201 | 400 |
| 일정 조회      | GET    | /api/agendas       | 다건 정보 | 200 | 404  |
| 선택 일정 조회 | GET    | /api/agendas/{id}  | 단건 정보 | 200 | 404 |
| 선택 일정 수정 | PUT    | /api/agendas/ {id} | 수정 정보 | 200 | 400 |
| 선택 일정 삭제 | DELETE | /api/agendas/ {id} |  -        | 200 | 400 or 404 |

## 사용자 API
| 기능         | Method | API PATH             | Response   | 상태코드 : 성공 | 상태코드 : 실패 |
| ------------- | ------ | -------------------- | ------- | ---------------- | ------------ |
| 회원가입      | POST   | /api/authors          | 등록 정보   | 201 | 400 |
| 특정 회원 조회| GET    | /api/authors/{author_id} | 다건 정보 | 200| 404 |
| 회원 삭제     | DELETE | /api/authors/{author_id} | -       | 200 | 400 or 404 |

---

<details>
  <summary>일정 등록</summary>
  
### RequestBody
 ``` json
{
    "userName" : "작성자 명",
    "title": "제목",
    "content": "내용"
}
```
### ResponseBody
Success - 201 CREATED
 ``` json
{
    "id" : 1,
    "userName" : "작성자 명",
    "title" : "할 일 제목",
    "content" : "할 일 내용",
    "createdAt" : "작성일자",
}
```
</details>

<details>
  <summary>일정 조회</summary>
	
### ResponseBody
Success - 200 OK
``` json
{
 {
      "id" : 1,
      "user_name" : "작성자 명",
      "title" : "할 일 제목",
      "content" : "할 일 내용",
      "createdAt" : "작성일자",
      "modifiedAt" : "수정일자"
  }
   {
      "id" : 2,
      "user_name" : "작성자 명",
      "title" : "할 일 제목2",
      "content" : "할 일 내용2",
      "createdAt" : "작성일자",
      "modifiedAt" : "수정일자"
  }
   {
      "id" : 3,
      "user_name" : "작성자 명",
      "title" : "할 일 제목3",
      "content" : "할 일 내용3",
      "createdAt" : "작성일자",
      "modifiedAt" : "수정일자"
  }
}
```
Fail - 404 NOT FOUND

</details>

<details>
  <summary>선택 일정 조회</summary>
	
### ResponseBody
Success - 200 OK
``` json
{
    "id" : 1,
    "user_name" : "작성자 명",
    "title" : "할 일 제목",
    "content" : "할 일 내용",
    "createdAt" : "작성일자",
}
```
Fail - 404 NOT FOUND

</details>

<details>
  <summary>선택 일정 수정</summary>
	
### ResponseBody
Success - 200 OK
``` json
{
    "id" : 1,
    "user_name" : "작성자 명",
    "title" : "할 일 제목",
    "content" : "할 일 내용",
    "createdAt" : "작성일자",
    "modifiedAt" : "수정일자"
}
```	
Fail - 400 BAD REQUEST

</details>

<details>
  <summary>선택 일정 삭제</summary>
	
### ResponseBody
Success - 200 OK
``` json
{
    "msg" : "삭제 완료"
}
```
Fail - 400 BAD REQUEST / 404 NOT FOUND

</details>

<details>
  <summary>작성자 생성</summary>
  
### RequestBody
 ``` json
{
    "userName" : "작성자 명",
    "password" : "1234",
    "email" : "qwer@gmail.com"
}
```
### ResponseBody
Success - 201 CREATED
 ``` json
{
    "id" : 1,
    "userName" : "작성자 명",
    "title" : "할 일 제목",
    "content" : "할 일 내용",
    "createdAt" : "작성일자",
}
```
</details>

<details>
  <summary>작성자 조회</summary>
  
### ResponseBody
Success - 201 CREATED
 ``` json
{
    "id" : 1,
    "userName" : "작성자 명",
    "title" : "할 일 제목",
    "content" : "할 일 내용",
    "createdAt" : "작성일자",
    "modifiedAt" : "수정일자"
}
```
Fail - 404 NOT FOUND

</details>

<details>
  <summary>작성자 삭제</summary>
  
### ResponseBody
Success - 200 OK
``` json
{
    "msg" : "삭제 완료"
}
```
Fail
ex) Fail - 400 BAD REQUEST / 404 NOT FOUND

</details>

### ERD
<img width="277" alt="AgendaERD0" src="https://github.com/user-attachments/assets/04f32317-5f86-48c3-b6ad-313b8a839bd9">



