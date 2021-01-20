package com.`fun`.movieapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.`fun`.movieapp.R
import com.`fun`.movieapp.data.api.ApiHelper
import com.`fun`.movieapp.data.api.RetrofitBuilder
import com.`fun`.movieapp.data.model.Result
import com.`fun`.movieapp.databinding.MainFragmentBinding
import com.`fun`.movieapp.utils.Status
import com.`fun`.movieapp.view.adapter.MainAdapter
import com.`fun`.movieapp.viewmodel.MovieListViewModel
import com.`fun`.movieapp.viewmodel.MovieListViewModelFactory



class MainFragment : Fragment() {
    private lateinit var viewModel: MovieListViewModel
    private lateinit var adapter: MainAdapter
    lateinit  var movieList :List<Result>
    private lateinit var fragmentbinding: MainFragmentBinding

    companion object {
        fun newInstance() = MainFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViewModel()
        initObservers()
        fragmentbinding = DataBindingUtil.inflate(
            inflater,
            R.layout.main_fragment, container, false
        )
        return fragmentbinding.root
    }




   private fun initViewModel() {

        viewModel = ViewModelProviders.of(
            this, MovieListViewModelFactory(
                ApiHelper(
                    RetrofitBuilder.apiService,
                    "01c49e5a9d80cd8c6c5964b952ce3a55"
                )
            )
        )
            .get(MovieListViewModel::class.java)

    }



    private fun initObservers() {

        viewModel.getMovieList().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {

                        resource.data?.let { response ->

                            initadapter(response.results)

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

    private fun initadapter(response: List<Result>) {
        movieList=response
        adapter= MainAdapter()
        adapter.submitList(response as MutableList<*>)
        fragmentbinding.movieslist.layoutManager=LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        fragmentbinding.movieslist.adapter=adapter







    }




}