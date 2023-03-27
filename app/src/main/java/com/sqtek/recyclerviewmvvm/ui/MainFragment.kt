package com.sqtek.recyclerviewmvvm.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.sqtek.recyclerviewmvvm.R
import com.sqtek.recyclerviewmvvm.databinding.FragmentMainBinding
import com.sqtek.recyclerviewmvvm.model.Course
import com.sqtek.recyclerviewmvvm.viewModel.MainViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }
    private val TAG = "MainFragment"
    private lateinit var viewModel: MainViewModel
    private lateinit var viewDataBinding: FragmentMainBinding
    private lateinit var mainAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main ,container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewDataBinding.lifecycleOwner = requireActivity()
        mainAdapter = MainAdapter(viewModel)
        //mainAdapter.setHasStableIds(true)
        //viewDataBinding.viewModel = viewModel
        viewDataBinding.recyclerview.adapter = mainAdapter

        viewModel.getAllCourse()
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated()")
        //viewModel.updateTitle()
        viewModel.courseList.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onActivityCreated()::observe $it")
            mainAdapter.setCourseList(it)
        })

        viewModel.openItemEvent.observe(viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let {
                val course: Course = it
                Log.d(TAG, "openItemEvent()")
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, DetailFragment.newInstance(course))
                    .commit()
            }
        })
    }
}