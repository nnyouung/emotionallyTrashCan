package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Setting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
    }
}

// 설정창...
//class setting : PreferenceFragmentCompat() {
//
//    lateinit var prefs: SharedPreferences
//
//    var keywordPreference: Preference? = null
//    var keywordListPreference: Preference? = null
//
//    // onCreate() 중에 호출되어 Fragment에 preference를 제공하는 메서드
//    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
//        setPreferencesFromResource(R.xml.setting, rootKey)
//
//        // rootkey가 null이라면
//        if (rootKey == null) {
//            // Preference 객체들 초기화
//            keywordPreference = findPreference("keyword")
//            keywordListPreference = findPreference("keyword_sound_list")
//        }
//    }
//}