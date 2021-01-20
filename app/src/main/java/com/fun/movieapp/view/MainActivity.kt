package com.`fun`.movieapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.`fun`.movieapp.R
import com.`fun`.movieapp.data.api.ApiHelper
import com.`fun`.movieapp.data.api.RetrofitBuilder
import com.`fun`.movieapp.databinding.ActivityMainBinding
import com.`fun`.movieapp.view.adapter.MainAdapter
import com.`fun`.movieapp.viewmodel.MainViewModel
import com.`fun`.movieapp.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }


    private fun initFragment(){
        supportFragmentManager.beginTransaction()
                .replace(R.id.container , MainFragment.newInstance()).commitNow()
    }
}


