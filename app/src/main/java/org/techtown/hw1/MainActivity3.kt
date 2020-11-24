package org.techtown.hw1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    private lateinit var profileAdapter: ProfileAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val profileAdapter=ProfileAdapter(this )
        main_rcv.adapter=profileAdapter
        main_rcv.layoutManager= LinearLayoutManager(this)
        profileAdapter.data= mutableListOf(
            ProfileData("이름", "안녕안녕"),
            ProfileData("나이", "22"),
            ProfileData("파트", "Android"),
            ProfileData("Github","link in bio"),
            ProfileData("음식", "떡볶이")
        )
        profileAdapter.notifyDataSetChanged()
    }
}