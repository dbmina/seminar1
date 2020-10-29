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


3. 회원가입시 정보가 다 채워졌는지 판별
editText1 = findViewById(R.id.Edittext)
 editText2 = findViewById(R.id.editText)
        editText3 = findViewById(R.id.editText2)
        
 button2.setOnClickListener {
            if (editText1?.length() != 0 && editText2?.length() != 0 && editText3?.length() != 0) {
                Toast.makeText(this, "회원가입성공", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "빈칸이 있습니다", Toast.LENGTH_SHORT).show()
            }
            
 각각의 editText를 findViewByID로 해서 받아온 이후 length()를 사용하여 사용자가 정보를 입력했는지 판별     
