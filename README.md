# seminar1

**1. 다른 화면으로 이동할 경우**

first_button.setOnClickListener{ val Intent= Intent(this,MainActivity2::class.java ) startActivity(Intent)

}

Intent 객체를 만들어서 이동하고 싶은 Activity를 적어준다! 이 경우 MainActivity2로 이동하는 것!


**2. 미리보기 글씨 만들기**

android:hint="비밀번호 EditTextView"

EditText안에 hint 속성으로 글씨를 써준다! 이렇게 쓰면 미리보기 속성으로 글씨가 나오게 된다



**3. 회원가입시 정보가 다 채워졌는지 판별**


editText1 = findViewById(R.id.Edittext) editText2 = findViewById(R.id.editText) editText3 = findViewById(R.id.editText2)

button2.setOnClickListener { if (editText1?.length() != 0 && editText2?.length() != 0 && editText3?.length() != 0) { Toast.makeText(this, "회원가입성공", Toast.LENGTH_SHORT).show() val intent = Intent(this, MainActivity3:: class.java) startActivity(intent) } else { Toast.makeText(this, "빈칸이 있습니다", Toast.LENGTH_SHORT).show() }


각각의 editText를 findViewByID로 해서 받아온 이후 length()를 사용하여 사용자가 정보를 입력했는지 판별

또한 if 문안에 정보가 채워졌을 경우에만 intent 객체를 넘기면 사용자가 모든 정보를 입력했을때만 다른 화면으로 넘어가는 것을 구현할 수 있다


**로그인, 회원가입 화면 구현**

![Screenshot_20201030-110452](https://user-images.githubusercontent.com/71162530/97655053-8f3e0880-1aa7-11eb-9cec-b7d9e3c9441a.png, width="300", height="500")
![Screenshot_20201030-110516](https://user-images.githubusercontent.com/71162530/97655056-9107cc00-1aa7-11eb-9bdc-7cb567a32ef4.png)

**4. Recyclerview data 만들때 guideline 적용하기**


각각의 데이터를 라인에 맞추어 정리하고 싶으면 guideline을 사용하는 방법이 있다. <androidx.constraintlayout.widget.Guideline android:id="@+id/guideline" android:layout_width="wrap_content" android:layout_height="wrap_content" android:orientation="vertical" app:layout_constraintGuide_begin="167dp" />

이런식으로 guideline 코드를 작성해준 뒤,

텍스트뷰의 시작을 guideline으로 하고 싶으면 app:layout_constraintStart_toStartOf="@+id/guideline" 이런식으로 코드를 작성해주면 된다



**5. Recylcerview를 위해 필요한 것!! **
