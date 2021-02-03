# Android Clean Architecture MVVM


## 아키텍쳐 구조

![architecture](readme_assets/architecture.jpg)

- `data model`은 속한 레이어에 따라 달라짐(Table Entity, DTO, UI Model, etc)
- `mapper`는 레이어간 `data model`을 변환하는 역할 
    (필요한 경우 반대 경우도 구현)
- 플랫폼 의존여부에 따라 `Android`, `Java`로 구분


### Domain Layer

1. interactor, entity, repository로 구성.
1. interactor는 비즈니스 로직이 구현되는 곳으로 repository를 생성시 전달 받음.
1. interactor는 단일 useCase가 아닌 useCase의 집합으로 구현.
1. entity는 단순히 비즈니스 로직에 사용되는 데이터를 정의한 data class.
1. repository는 인터페이스 현태로 존재, interactor 생성시 구현체를 전달 받음.

### Data Layer

1. Domain Layer의 repository를 구현.
1. 구현체에 따라 Android 또는 JVM 속함.
1. API서비스, DB, SharedPreference 등이 여기서 구현.

### ViewModel Layer

1. ViewModel, ViewState, ViewData, Mapper로 구성.
1. AAC의 ViewModel 사용.
1. RxJava로 된 Interactor의 처리 결과를  
   LiveData로 ViewState\<ViewData\>형태로 를 emit.
1. ViewData는 UI에 사용할 data class.
1. Mapper는 Entity<->ViewData로 변환을 담당.

### View Layer

1. Activity/Fragment, CustomView, layout.xml등으로 구성.
1. 일단은 Activity/Fragment가 View의 역할을 함.
1. ViewState는 View를 일종의 상태머신으로 보고 각 상태에 맞는 UI를 보여줌.(빈리스트, 로딩중, 에러, etc)
   1. 최대한 하나의 ViewState를 유지하되  
   푸시알림처리나 배찌숫자 변경같은 메인 기능에 영향이 적은건  
   추가로 ViewState가 존재 할 수 있음.

---

## 샘플앱 기획

1. 컬러셋에 속하는 컬러칩들의 리스트를 보여줌.  
1. 컬러셋 리스트 화면과 컬러셋의 컬러칩들의 정보를 보여주는 상세화면으로 구성됨.

---

## Todo?

1. 서비스, 브로드케스트 리시버, 푸시 노티피케이션 받을떄 처리는 어떻게?
1. RecyclerView ViewHolder는 어떻게 처리할까?
1. 좀 더 풀어 쓴 글은 작성예정