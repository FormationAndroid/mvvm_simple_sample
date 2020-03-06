package com.example.countvmapp

import android.os.Bundle
import androidx.lifecycle.*

class MyViewModel(private var count: Int = 0) : ViewModel(), LifecycleObserver {
    companion object { const val COUNT_KEY = "CountKey" }

    private val changeNotifier = MutableLiveData<Int>()
    val changeRegister: LiveData<Int>
        get() = changeNotifier

    fun increment() { changeNotifier.value = ++count }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME) fun onResume() { increment() }

    fun saveState(outState: Bundle) {
        outState.putInt(COUNT_KEY, count)
    }

    fun restoreState(inState: Bundle?) {
        inState?.let { count = inState.getInt(COUNT_KEY) }
    }
}

