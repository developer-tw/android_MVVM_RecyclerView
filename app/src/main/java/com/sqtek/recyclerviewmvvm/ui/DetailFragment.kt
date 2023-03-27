package com.sqtek.recyclerviewmvvm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import com.sqtek.recyclerviewmvvm.R
import com.sqtek.recyclerviewmvvm.databinding.FragmentCourseDetailBinding
import com.sqtek.recyclerviewmvvm.model.Course

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment(item: Course) : Fragment() {

    val item: Course = item

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewDataBinding: FragmentCourseDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_course_detail, container, false
        )
        val webView = viewDataBinding.root.findViewById(R.id.webView) as WebView
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl(item.courseUrl)
        webView.settings.setSupportZoom(true)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance(), null)
                    .commit()
            }
        })
    }
    companion object {
        @JvmStatic
        fun newInstance(item: Course) = DetailFragment(item)
    }
}