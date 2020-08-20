package com.nj.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random
import kotlin.random.nextInt

class MainViewModel: ViewModel() {
    private var count = MutableLiveData<Int>();
    var f1, s1
    var f_value: MutableLiveData<Int>? = null
    fun getFVal(): LiveData<Int>? = f_value
    var s_value: MutableLiveData<Int>? = null
    fun getSVal(): LiveData<Int>? = s_value
    var operator: MutableLiveData<String>? = null
    fun getOperator(): LiveData<String>? = operator
    var result: MutableLiveData<Int>? = null
    fun getResult(): LiveData<Int>? = result

    fun startCalculateProcess() {
        operator?.value?.let {
             result?.postValue(calculate())
        }
    }

    fun chooseFVal() {
        f_value?.postValue(Random.nextInt(10))
    }
    fun chooseSVal() {
        s_value?.postValue(Random.nextInt(10))
    }
    fun chooseOperator() {
        operator?.postValue("+")
    }

    fun calculate(): Int =
        when(operator?.value) {
            "+" -> {
                f_value?.value?.let { f_val->
                    s_value?.value?.let {
                      f_val + it
                    }
                } ?: 0
            }
            "-" -> {
                f_value?.value?.let { f_val->
                    s_value?.value?.let {
                        f_val - it
                    }
                } ?: 0
            }
            "*" -> {
                f_value?.value?.let { f_val->
                    s_value?.value?.let {
                        f_val * it
                    }
                } ?: 0
            }
            "/" -> {
                    f_value?.value?.let { f_val->
                        s_value?.value?.let {
                            if(it > 0)
                                f_val / it
                            else 0
                        }
                    } ?: 0
            }
            else -> {
                0
            }
    }
}