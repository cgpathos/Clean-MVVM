package net.appthos.mvvm.core.extensions

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

fun Disposable.addTo(disposableBag: CompositeDisposable) {
    disposableBag.add(this)
}