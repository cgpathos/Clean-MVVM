package net.appthos.mvvm.core.alias

// 이름이 같아 혼돈을 피하기 위해 alias 설정
// 직접 쓰지 않도록 주의한다.(todo : 나중에 커스텀 lint를 정의하면 되겠지???)
typealias DaggerAssisted = com.squareup.inject.assisted.Assisted
typealias HiltAssisted = androidx.hilt.Assisted