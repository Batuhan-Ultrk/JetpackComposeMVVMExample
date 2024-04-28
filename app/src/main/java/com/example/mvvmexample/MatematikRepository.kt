package com.example.mvvmexample

import androidx.lifecycle.MutableLiveData

class MatematikRepository {
    var repoResult = MutableLiveData<Int>()

    init {
        repoResult = MutableLiveData<Int>(0)
    }
    fun resultReturn():MutableLiveData<Int>{
        return  repoResult
    }
    fun topla(sayi1: String, sayi2: String) {
        repoResult.value = sayi1.toInt() + sayi2.toInt()
    }

    fun carp(sayi1: String, sayi2: String) {
        repoResult.value = sayi1.toInt() * sayi2.toInt()
    }
}