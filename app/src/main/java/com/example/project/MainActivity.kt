package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.core.view.GravityCompat
import com.example.project.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private val TAG = this.javaClass.simpleName // 콜백 인스턴스 생성
    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            Log.e(TAG, "뒤로가기 클릭")   // 뒤로 버튼 이벤트 처리
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 뷰바인딩 사용: 네이밍규칙 적용으로 img_navi -> imgNavi
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // 메인창의 navigation view을 위한 부분
        val adapter = AdapterPager(supportFragmentManager)
        adapter.addFragment(WorryAdd(), "오늘의 걱정")
        adapter.addFragment(WorryList(), "걱정 리스트")
        binding.viewpager.adapter = adapter
        binding.afterLoginTablayout.setupWithViewPager(binding.viewpager)

        binding.imgNavi.setOnClickListener {   // 네비게이션 뷰 열기.
            binding.layoutDrawer.openDrawer(GravityCompat.START)
        }   // () 안은 어느 방향에서 시작할지, 없으면 에러남. (START = left, END = right)

        binding.naviView.setNavigationItemSelectedListener(this)   // 네비게이션 메뉴 아이템에 클릭할 수 있는 속성 부여.
    }


    // navigation view을 위한 함수.
    override fun onNavigationItemSelected(item: MenuItem): Boolean {   // 네비게이션 메뉴 아이템 클릭 시 수행.
        when (item.itemId) {   // 네비게이션 메뉴 아이템 클릭할 때마다 item에 그 메뉴 아이템이 배정됨.
            R.id.date_worry -> {
                val intent = Intent(this, WorryDate::class.java)  // 다음 화면으로 이동하기 위한 인텐트 객채. Intent(현재화면, 이동할 화면).
                startActivity(intent) }   // intent에 저장되어 있는 액티비티 쪽으로 이동.
            R.id.category_worry -> {
                val intent = Intent(this, WorryCategory::class.java)
                startActivity(intent) }
            R.id.setting -> {
                val intent = Intent(this, Setting::class.java)
                startActivity(intent) }
        }
        binding.layoutDrawer.closeDrawers()   // 버튼 클릭 시, 앞선 내용을 수행하면서 네비게이션 뷰를 닫아주는 명령어.
        return false
    }

    override fun onBackPressed() {   // 뒤로 가기 버튼을 눌렀을 때 수행하는 메소드.
        if (binding.layoutDrawer.isDrawerOpen(GravityCompat.START)) {   // 네비게이션 뷰가 켜져 있으면 네비게이션 뷰를 끄기.
            binding.layoutDrawer.closeDrawers()
        }
        this.onBackPressedDispatcher.addCallback(this, callback)
    }
}