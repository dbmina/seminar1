# seminar1
1. 다른 화면으로 이동할 경우

first_button.setOnClickListener{
            val Intent= Intent(this,MainActivity2::class.java )
            startActivity(Intent)

}

Intent 객체를 만들어서 이동하고 싶은 Activity를 적어준다! 
이 경우 MainActivity2로 이동하는 것! 


2. 미리보기 글씨 만들기

android:hint="비밀번호 EditTextView"

EditText안에 hint 속성으로 글씨를 써준다!
이렇게 쓰면 미리보기 속성으로 글씨가 나오게 된다

3. 
