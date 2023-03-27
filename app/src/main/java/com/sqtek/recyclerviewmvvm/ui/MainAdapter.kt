package com.sqtek.recyclerviewmvvm.ui

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.sqtek.recyclerviewmvvm.databinding.CardViewLayoutBinding
import com.sqtek.recyclerviewmvvm.model.Course
import com.sqtek.recyclerviewmvvm.viewModel.MainViewModel

class MainAdapter(private val viewModel: MainViewModel): RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    var courses = mutableListOf<Course>()
    private val TAG = "MainAdapter"

    @SuppressLint("NotifyDataSetChanged")
    fun setCourseList(course: List<Course>) {
        this.courses = course.toMutableList()
        Log.d(TAG, "setCourseList: $courses")
        notifyDataSetChanged()
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            bind(viewModel, courses[position])
        }
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: ${courses.size}")
        return courses.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
/*
    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(thumbs: ImageView, url: String) {
            Glide.with(thumbs)
                .load(url)
                .circleCrop(
                .placehol)der(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(thumbs)
        }
    }
*/
    class ViewHolder(val binding: CardViewLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: MainViewModel,course: Course) {
            binding.pViewModel= course
            binding.viewModel =viewModel
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CardViewLayoutBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}
