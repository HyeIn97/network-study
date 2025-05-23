# 📚 Book Search App

## 📌 개요
네이버 검색 오픈 API를 활용하여 책을 검색하고, 검색 결과를 확인할 수 있는 안드로이드 애플리케이션입니다.  
즐겨찾기 기능을 제공하여 원하는 책을 저장하고 관리할 수 있습니다.

## 🛠 기술 스택
- **아키텍처**: 클린 아키텍처 + MVVM  
- **UI**: ViewBinding, RecyclerView  
- **DI**: Hilt  
- **비동기 처리**: Coroutine + Flow  
- **네트워크**: Retrofit  
- **데이터 저장**: DataStore Preferences  

## 📱 주요 기능
- **책 검색 기능**: 네이버 검색 API를 활용하여 책 검색  
- **검색 결과 표시**: RecyclerView를 사용하여 검색된 책 리스트 출력 (페이징 기능)
- **상세 페이지**: 리스트에서 아이템 클릭 시 상세 페이지로 이동  
- **즐겨찾기 관리**: 상세 페이지에서 즐겨찾기 추가 및 제거 가능  
- **즐겨찾기 목록 조회**: 즐겨찾기한 책 목록을 별도 화면에서 확인 가능

## 🔗 API 사용
- **네이버 검색 API**: https://developers.naver.com/docs/serviceapi/search/book/book.md

## 📷 스크린샷
추후 추가 예정
