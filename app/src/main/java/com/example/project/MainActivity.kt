package com.example.project

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)   // xml 파일과 연결.

        val adapter = PagerAdapter(supportFragmentManager)
        adapter.addFragment(WorryAdd(), "오늘의 걱정")
        adapter.addFragment(WorryList(), "걱정 리스트")
        viewpager.adapter = adapter
        after_login_tablayout.setupWithViewPager(viewpager)

        img_navi.setOnClickListener {   // 네비게이션 뷰 열기.
            layout_drawer.openDrawer(GravityCompat.START)
        }   // () 안은 어느 방향에서 시작할지, 없으면 에러남. (START = left, END = right)

        naviView.setNavigationItemSelectedListener(this)   // 네비게이션 메뉴 아이템에 클릭할 수 있는 속성 부여.
    }


    // 네비게이션뷰를 위한 함수.
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
        layout_drawer.closeDrawers()   // 버튼 클릭 시, 앞선 내용을 수행하면서 네비게이션 뷰를 닫아주는 명령어.
        return false
    }

    override fun onBackPressed() {   // 뒤로 가기 버튼을 눌렀을 때 수행하는 메소드.
        if (layout_drawer.isDrawerOpen(GravityCompat.START)) {   // 네비게이션 뷰가 켜져 있으면 네비게이션 뷰를 끄기.
            layout_drawer.closeDrawers()
        }
        super.onBackPressed()   // 뒤로 가기 버튼 기능 실행.
    }
}