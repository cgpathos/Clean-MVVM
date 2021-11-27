[![Android release](https://github.com/cgpathos/Clean-MVVM/actions/workflows/android.yml/badge.svg)](https://github.com/cgpathos/Clean-MVVM/actions/workflows/android.yml)

# Clean-MVVM

## todo : 기존에 잡았던 아키텍쳐 고도화



[comment]: <> (## 아키텍쳐 구조)

[comment]: <> (![architecture]&#40;readme_assets/architecture.jpg&#41;)

[comment]: <> (- `data model`은 속한 레이어에 따라 달라짐&#40;Table Entity, DTO, UI Model, etc&#41;)

[comment]: <> (- `mapper`는 레이어간 `data model`을 변환하는 역할 )

[comment]: <> (    &#40;필요한 경우 반대 경우도 구현&#41;)

[comment]: <> (- 플랫폼 의존여부에 따라 `Android`, `Java`로 구분)


[comment]: <> (### Domain Layer)

[comment]: <> (1. interactor, entity, repository로 구성.)

[comment]: <> (1. interactor는 비즈니스 로직이 구현되는 곳으로 repository를 생성시 전달 받음.)

[comment]: <> (1. interactor는 단일 useCase가 아닌 useCase의 집합으로 구현.)

[comment]: <> (1. entity는 단순히 비즈니스 로직에 사용되는 데이터를 정의한 data class.)

[comment]: <> (1. repository는 인터페이스 현태로 존재, interactor 생성시 구현체를 전달 받음.)

[comment]: <> (### Data Layer)

[comment]: <> (1. Domain Layer의 repository를 구현.)

[comment]: <> (1. 구현체에 따라 Android 또는 JVM 속함.)

[comment]: <> (1. API서비스, DB, SharedPreference 등이 여기서 구현.)

[comment]: <> (### ViewModel Layer)

[comment]: <> (1. ViewModel, ViewState, ViewData, Mapper로 구성.)

[comment]: <> (1. AAC의 ViewModel 사용.)

[comment]: <> (1. RxJava로 된 Interactor의 처리 결과를  )

[comment]: <> (   LiveData로 ViewState\<ViewData\>형태로 를 emit.)

[comment]: <> (1. ViewData는 UI에 사용할 data class.)

[comment]: <> (1. Mapper는 Entity<->ViewData로 변환을 담당.)

[comment]: <> (### View Layer)

[comment]: <> (1. Activity/Fragment, CustomView, layout.xml등으로 구성.)

[comment]: <> (1. 일단은 Activity/Fragment가 View의 역할을 함.)

[comment]: <> (1. ViewState는 View를 일종의 상태머신으로 보고 각 상태에 맞는 UI를 보여줌.&#40;빈리스트, 로딩중, 에러, etc&#41;)

[comment]: <> (   1. 최대한 하나의 ViewState를 유지하되  )

[comment]: <> (   푸시알림처리나 배찌숫자 변경같은 메인 기능에 영향이 적은건  )

[comment]: <> (   추가로 ViewState가 존재 할 수 있음.)

[comment]: <> (---)

[comment]: <> (## 샘플앱 기획)

[comment]: <> (1. 컬러셋에 속하는 컬러칩들의 리스트를 보여줌.  )

[comment]: <> (1. 컬러셋 리스트 화면과 컬러셋의 컬러칩들의 정보를 보여주는 상세화면으로 구성됨.)

[comment]: <> (---)

[comment]: <> (## Todo?)

[comment]: <> (1. 서비스, 브로드케스트 리시버, 푸시 노티피케이션 받을떄 처리는 어떻게?)

[comment]: <> (1. RecyclerView ViewHolder는 어떻게 처리할까?)

[comment]: <> (1. 좀 더 풀어 쓴 글은 작성예정)
