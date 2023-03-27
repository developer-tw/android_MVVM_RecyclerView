package com.sqtek.recyclerviewmvvm.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sqtek.recyclerviewmvvm.R
import com.sqtek.recyclerviewmvvm.model.Course
import com.sqtek.recyclerviewmvvm.ui.Event

class MainViewModel : ViewModel() {
    private val TAG = "MainFragment"
    //var title: MutableLiveData<String> = MutableLiveData()
    val courseList = MutableLiveData<List<Course>>()
    val openItemEvent: MutableLiveData<Event<Course>> = MutableLiveData()

    //fun updateTitle() {
    //    title.value = "SQTek for Ethan"
    //}

    fun getAllCourse() {
        val title = arrayOf<String>(
            "【Highlands, Islands, Cities: The Magic of Scotland】",
            "【Study Finds Why Gardening Is Good for You】",
            "【French Bulldog Becomes Most Popular US Dog Breed】",
            "【Three-Year Cruise Visits 135 Countries for \$85 a Day】",
            "【'I'm Terribly Sorry': How to Apologize in English】",
            "【Japanese Scientists Create Mice with Cells from Two Males】",
            "【Google's AI chatbot Bard takes on Microsoft's ChatGPT】",
            "【Archaeologists Find Earliest Evidence of Horse Riding】")
        val imageId = arrayOf<Int>(
            R.drawable.course1, R.drawable.course2, R.drawable.course3,
            R.drawable.course4, R.drawable.course5, R.drawable.course6,
            R.drawable.course7, R.drawable.course8
        )
        val articleUrl = arrayOf<String>(
            "https://engoo.com.tw/app/daily-news/article/highlands-islands-cities-the-magic-of-scotland/RuaCPMUKEe2Pj58I1puG_w",
            "https://engoo.com.tw/app/daily-news/article/study-finds-why-gardening-is-good-for-you/UhFf6LkLEe221f9tVn_GlQ",
            "https://engoo.com.tw/app/daily-news/article/french-bulldog-becomes-most-popular-us-dog-breed/GyuvJMc0Ee2GvBOw-NIEew",
            "https://engoo.com.tw/app/daily-news/article/three-year-cruise-visits-135-countries-for-85-a-day/1f2UHMK6Ee2lN59yxslasw",
            "https://engoo.com.tw/app/daily-news/article/im-terribly-sorry-how-to-apologize-in-english/QY1m7sc0Ee2GLHdMNyUqPg",
            "https://engoo.com.tw/app/daily-news/article/japanese-scientists-create-mice-with-cells-from-two-males/-FCkIsS5Ee279ouyuxjQkA",
            "https://engoo.com.tw/app/daily-news/article/googles-ai-chatbot-bard-takes-on-microsofts-chatgpt/zzeQ_MjMEe2Z5Qcx9XxsIw",
            "https://engoo.com.tw/app/daily-news/article/archaeologists-find-earliest-evidence-of-horse-riding/PLMOHLxdEe2OOytrSUBaAA")
        //val courseResponse = CourseResponse()

        val name = arrayOf<String>(
            "Highlands, Islands, Cities: The Magic of Scotland",
            "Study Finds Why Gardening Is Good for You",
            "French Bulldog Becomes Most Popular US Dog Breed",
            "Three-Year Cruise Visits 135 Countries for \$85 a Day",
            "'I'm Terribly Sorry': How to Apologize in English",
            "Japanese Scientists Create Mice with Cells from Two Males",
            "Google's AI chatbot Bard takes on Microsoft's ChatGPT",
            "Archaeologists Find Earliest Evidence of Horse Riding")

        val desc = arrayOf<String>(
            "Harry Potter author JK Rowling often wrote her books in Scotland — and if it's magic you're looking for, this might just be a good place to find it.",
            "Most gardeners will probably say gardening is good for you. It gets you out in the fresh air, getting lots of sunshine and exercise while watching things grow.",
            "For the first time in over 30 years, the US has a new favorite dog breed, according to the American Kennel Club.",
            "Would you like to take a cruise around the world with enough time on land to visit everything from the Great Wall of China to the pyramids of Egypt, the bars of Barcelona and the ice-covered rock of Antarctica?",
            "It's said that being polite costs nothing. But when we want to apologize — to say we're sorry — it can sometimes be hard to choose the best words.",
            "Japanese scientists have created baby mice with two males for the first time by turning their stem cells into female cells in a laboratory.",
            "Google has announced it will allow more people to interact with \"Bard,\" its artificial intelligence (AI) chatbot.",
            "Archaeologists believe they have found the earliest direct evidence of horseback riding in 5,000-year-old human skeletons in central Europe.")

        val list = mutableListOf<Course>()
        (0..7).forEach {
            list.add(Course(title[it], imageId[it], articleUrl[it], name[it], desc[it]))
        }
        Log.d(TAG, "getAllCourse: $list")
        courseList.postValue(list)
    }

    fun openItem(course: Course) {
        Log.d(TAG, "openItem: $course")
        openItemEvent.value = Event(course)

    }
}