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
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupViewModel()
        setupUI()
        //setupObservers()
    }
   /* private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
                this,
                MainViewModelFactory(ApiHelper(RetrofitBuilder.apiService, "01c49e5a9d80cd8c6c5964b952ce3a55"))
        ).get(MainViewModel::class.java)
    }*/
    /*private fun setupUI()
    {   recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
                DividerItemDecoration(
                        recyclerView.context,
                        (recyclerView.layoutManager as LinearLayoutManager).orientation
                )
        )
        recyclerView.adapter = adapter

    }*/
}