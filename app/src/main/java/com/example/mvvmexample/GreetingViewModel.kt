package com.example.mvvmexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GreetingViewModel : ViewModel() {
    var result = MutableLiveData<Int>()
    val mRepo=MatematikRepository()

    init {
        result = mRepo.resultReturn()
    }

    fun topla(sayi1: String, sayi2: String) {
        mRepo.topla(sayi1,sayi2)
    }

    fun carp(sayi1: String, sayi2: String) {
        mRepo.carp(sayi1,sayi2)
    }
}