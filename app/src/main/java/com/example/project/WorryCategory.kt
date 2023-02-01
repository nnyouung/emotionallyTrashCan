package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.databinding.ActivityWorrycategoryBinding

private lateinit var binding: ActivityWorrycategoryBinding

class WorryCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorrycategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val categoryList = arrayListOf(
            CategoryWorries(R.drawable.people, "가족", R.drawable.next),
            CategoryWorries(R.drawable.user, "진로", R.drawable.next),
            CategoryWorries(R.drawable.user, "일", R.drawable.next),
            CategoryWorries(R.drawable.mac_add, "예시로 맥 넣기", R.drawable.next),
        )

        binding.rvCategoryworries.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)   // VERTICAL: 세로 형태
        binding.rvCategoryworries.setHasFixedSize(true)

        binding.rvCategoryworries.adapter = AdapterCategory(categoryList)
    }
}