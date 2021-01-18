package com.`fun`.movieapp.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.`fun`.movieapp.R
import com.`fun`.movieapp.data.api.ApiHelper
import com.`fun`.movieapp.data.api.RetrofitBuilder
import com.`fun`.movieapp.utils.Status
import com.`fun`.movieapp.viewmodel.MovieListViewModel
import com.`fun`.movieapp.viewmodel.MovieListViewModelFactory


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MovieListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init(){
        initViewModel()
        initData()
        setupObservers()
        //initAdapter()
    }

   private fun initViewModel() {

        viewModel = ViewModelProviders.of(this , MovieListViewModelFactory(ApiHelper(RetrofitBuilder.apiService, "01c49e5a9d80cd8c6c5964b952ce3a55")))
            .get(MovieListViewModel::class.java)

    }

    private fun initData() {
        viewModel.getMovieList()
    }

    private fun setupObservers() {

        viewModel.getMovieList().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {

                        resource.data?.let { response ->

                            initRv(response.result)

                        }
                    }
                    Status.ERROR -> {
                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {

                    }
                }
            }
        })
    }




}