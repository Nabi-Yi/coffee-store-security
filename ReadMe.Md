---
Section3에서 실습했던 커피주문 앱을 최대한 활용해봤습니다(해당 부분 MemberDTO말고는 수정사항이 없습니다).  
회원가입, 로그인은 Section4에서 실습한 내용을 토대로 구현했고  
회원 가입 및 로그인 직후 order에 접근 가능합니다. 기본 커피 정보 2개 넣어놨습니다.   
profile은 local로 실행시켜주세요.  
http://127.0.0.1:8080 으로 접속해주세요. (localhost:8080)  
members, coffees 등은 Admin 계정으로 로그인해야만 접근 가능합니다.  
(/v11/members, /v11/coffees)   
HTML 건드리기 너무 번거로워서.... 커피 주문은 한번에 한 종류만 가능합니다..
---

H2에서 
```
UPDATE MEMBER SET ROLE = 'ROLE_ADMIN' WHERE MEMBER_ID = 1;
```
를 입력하여 관리자 권한을 부여하고 ***다시 로그인*** 하시면 커피정보추가 등이 가능해 집니다.  

---

test쪽 RestDocs쪽은 아직 수정 안해서 에러 발생 할 수 있습니다.

---

@Controller와 @RestController의 차이로 인해(@Responsebody) @RestController에선 mustache가 작동을 안합니다.  
또한 HTML에서 Form에서 넘겨받는 형식은 json이 아니라서 @RequestBody, @Valid등을 적용하면 서버에서 제대로 받지 못해  
HTML쪽에서 script로 form data를 json으로 변환해줘야했습니다. 관심있으신분들은 해당부분 확인해보시면 좋을 것 같습니다.  

---
추가해보면 좋을 기능
- 나 말고 다른 사람의 주문정보는 못보게 하기
- ?