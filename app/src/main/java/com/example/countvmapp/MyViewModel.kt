package com.example.countvmapp

import androidx.lifecycle.*

class MyViewModel : ViewModel(), LifecycleObserver {

    private var count: Int = 0
    val changeNotifier = MutableLiveData<Int>()

    fun increment() { changeNotifier.value = ++count }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME) fun onResume() { increment() }

}

