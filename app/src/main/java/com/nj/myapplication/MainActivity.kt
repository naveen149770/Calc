package com.nj.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    var result: StringBuffer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.
        of(this).
        get(MainViewModel::class.java)

        first.setOnClickListener {
            mainViewModel.chooseFVal()
        }
        second.setOnClickListener {
            mainViewModel.chooseSVal()
        }
        operator.setOnClickListener {
            mainViewModel.chooseOperator()
        }
        equal.setOnClickListener {
            mainViewModel.startCalculateProcess()
        }

        mainViewModel.getFVal()?.observe(this, Observer {
            result?.append(it.toString())
            resultView.text = result
        })

        mainViewModel.getSVal()?.observe(this, Observer {
            result?.append(" $it")
            resultView.text = result
        })

        mainViewModel.getOperator()?.observe(this, Observer {
            result?.append(" $it")
            resultView.text = result
        })

        mainViewModel.getResult()?.observe(this, Observer {
           result?.setLength(0)
            resultView.text = it.toString()
        })

        mainViewModel.getFVal()?.observe(this, Observer {
            result?.append(it.toString())
        })
    }
}