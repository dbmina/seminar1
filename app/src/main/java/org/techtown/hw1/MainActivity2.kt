package org.techtown.hw1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    private var editText1: EditText? = null
    private var editText2: EditText? = null
    private var editText3: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        editText1 = findViewById(R.id.Edittext)
        editText2 = findViewById(R.id.editText)
        editText3 = findViewById(R.id.editText2)
        button2.setOnClickListener {
            if (editText1?.length() != 0 && editText2?.length() != 0 && editText3?.length() != 0) {
                Toast.makeText(this, "회원가입성공", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "빈칸이 있습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }
}