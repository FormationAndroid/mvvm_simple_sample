package com.example.countvmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.*

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MyViewModel by lazy {
        ViewModelProvider(this).get(MyViewModel::class.java)
    }

    private val changeObserver = Observer<Int> { value -> value?.let { incrementCount(value) } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.restoreState(savedInstanceState)
        viewModel.changeRegister.observe(this, changeObserver)
        lifecycle.addObserver(viewModel)
        my_container.setOnClickListener { viewModel.increment() }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.saveState(outState)
    }

    private fun incrementCount(value: Int) {
        my_text.text = (value).toString()
    }

}




