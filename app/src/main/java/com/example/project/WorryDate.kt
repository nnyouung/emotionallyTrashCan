package com.example.project

import android.annotation.SuppressLint
import android.view.View
import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.ActivityWorrydateBinding

class WorryDate : AppCompatActivity() {
    lateinit var calendarView: CalendarView
    lateinit var diaryTextView: TextView
    lateinit var worryRecyclerView: RecyclerView

    private lateinit var binding: ActivityWorrydateBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 뷰바인딩 사용: 네이밍규칙 적용으로 img_navi -> imgNavi
        binding = ActivityWorrydateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // expandable recycler view을 위한 부분.
        binding.rvDateworries.apply {
            adapter = AdapterDate()
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }

//        // recycler view을 위한 부분.
//        val dateWorriesList = arrayListOf(   // 데이터 부분인데 아마 텍스트파일을 따로 만들어서 해야 할 듯
//            DateWorries("힘드러따", R.drawable.next)
//        )
//        binding.rvWorries.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)   // VERTICAL: 세로 형태
//        binding.rvWorries.setHasFixedSize(true)
//        binding.rvWorries.adapter = DateWorriesAdapter(dateWorriesList)

        // UI값 생성
        calendarView = findViewById(R.id.calendar)
        diaryTextView = findViewById(R.id.tv_diary)
        worryRecyclerView = findViewById(R.id.rv_dateworries)

        worryRecyclerView.visibility = View.INVISIBLE

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            diaryTextView.visibility = View.VISIBLE
            diaryTextView.text = String.format("%d / %d / %d", year, month + 1, dayOfMonth)
            worryRecyclerView.visibility = View.VISIBLE
        }
    }
}