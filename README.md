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

button2.setOnClickListener { if (editText1?.length() != 0 && editText2?.length() != 0 && editText3?.length() != 0) {    
Toast.makeText(this, "회원가입성공", Toast.LENGTH_SHORT).show() val intent = Intent(this, MainActivity3:: class.java) startActivity(intent) }    

else { Toast.makeText(this, "빈칸이 있습니다", Toast.LENGTH_SHORT).show() }   


각각의 editText를 findViewByID로 해서 받아온 이후 length()를 사용하여 사용자가 정보를 입력했는지 판별    

또한 if 문안에 정보가 채워졌을 경우에만 intent 객체를 넘기면 사용자가 모든 정보를 입력했을때만 다른 화면으로 넘어가는 것을 구현할 수 있다     


**로그인 화면 구현**    

<img src="https://user-images.githubusercontent.com/71162530/97655053-8f3e0880-1aa7-11eb-9cec-b7d9e3c9441a.png"  width="600" height="800">


**디자인을 고려하여 로그인 화면 구현**
<img src="https://user-images.githubusercontent.com/71162530/99163889-72acfc00-2748-11eb-98c9-5f9fae43ee1d.png" width="600" height="800">


**회원가입 화면 구현**     
<img src="https://user-images.githubusercontent.com/71162530/97655056-9107cc00-1aa7-11eb-9bdc-7cb567a32ef4.png"  width="600" height="800">
    

**4. Recyclerview data 만들때 guideline 적용하기**


각각의 데이터를 라인에 맞추어 정리하고 싶으면 guideline을 사용하는 방법이 있다.   

<androidx.constraintlayout.widget.Guideline    
android:id="@+id/guideline"    
android:layout_width="wrap_content"    
android:layout_height="wrap_content"   
android:orientation="vertical"   
app:layout_constraintGuide_begin="167dp" />         

이런식으로 guideline 코드를 작성해준 뒤,     

텍스트뷰의 시작을 guideline으로 하고 싶으면 app:layout_constraintStart_toStartOf="@+id/guideline" 이런식으로 코드를 작성해주면 된다     


**5. Recyclerview의 component**


-반복적으로 보여질 아이템의 xml 작성 (activity_data.xml)    
-아이템에 대한 데이터 객체 만들기(ProfileData)    
-데이터 뷰에 쁘려주는 역할인 ViewHolder 만들기 (ProfileViewHolder)     
-데이터를 각 아이템들에게 전달하는 역할인 Adapter 만들기 (ProfileAdapter)      
-Recyclerview (activity_main3.xml)     
-Adapter 추가      


**RecyclerView 화면 구현**   

<img src="https://user-images.githubusercontent.com/71162530/97656273-65d2ac00-1aaa-11eb-81af-ced1481088d0.png"  width="600" height="800">   


**6. RecyclerView에서 각 item을 누르면 다른 화면으로 전환하는 것 구현**   

-ProfileAdapter에 val itemClick: (ProfileData)->Unit 추가   

class ProfileAdapter (private val context: Context, val itemClick: (ProfileData)->Unit): RecyclerView.Adapter<ProfileViewHolder>()   
     
  override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.onBind(data[position], itemClick)
    }
 
 onBindViewHolder에 itemCLick 추가
 
     
-ViewHolder의 class 수정 

class ProfileViewHolder (itemView: View, itemClick:(ProfileData)->Unit): RecyclerView.ViewHolder(itemView)-
   
 onBind 함수 수정    
 
fun onBind(data: ProfileData,itemClick:(ProfileData)->Unit){
        title.text=data.title
        subtitle.text=data.subtitle
        itemView.setOnClickListener { itemClick(data) }
    }
    
  -MainActivity3 class 수정   
  
  val profileAdapter=ProfileAdapter(this ){ProfileData->
            startActivity(Intent(this, ItemActivity::class.java))
        }


**Bottom navigation view, Tab layout 구현**
먼저 bottom navigation view를 위해서는 원하는 개수만큼의 fragment를 만든 후 이를 convert to linear layout 시킨다. 
다음 menu directory에 가서 원하는 아이템의 개수만큼 아이템의 태그를 넣어준다.
각 아이템은 drawable 파일에서 resource file을 추가시켜주면 된다. 
activity file에 가서 각 탭을 클릭했을 때 일어나는 이벤트 처리 listener를 설정해주는 것이 필요하다.
또한 sample_bottom_navi_setOnNavigationItemSelectedListener{} 안에 각 아이템 별 인덱스를 설정해줌으로써, 뷰페이저의 current Item의 값을 변화시켜주는 것이 필요하다
이렇게 하면 하단탭을 눌렀을때 작동은 잘 되지만 슬라이드 이후에 탭의 변경이 잘 되지 않기 때문에 ViewPager 페이지 변경에 대한 리스너가 필요하다
이는 BottomNav kotlin file에 addOnPageChangeListener라는 함수를 통해서 구현하였다 

**BottomNavigation 안에 recyclerview 구현하기 **
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val profileAdapter=ProfileAdapter(context!! )

        rcv.adapter=profileAdapter
        rcv.layoutManager= LinearLayoutManager(context!!)
        profileAdapter.data= mutableListOf(
            ProfileData("이름", "안녕안녕"),
            ProfileData("나이", "22"),
            ProfileData("파트", "Android"),
            ProfileData("Github","link in bio"),
            ProfileData("음식", "떡볶이")
        )

        profileAdapter.notifyDataSetChanged()

    }
    위의 코드처럼 recyclerview를 구현한 것에서 약간의 수정만 해주면 가능하다. 
    
**BottomNavigationView 구현예시**

<img src="https://user-images.githubusercontent.com/71162530/99178207-12bc5280-2754-11eb-87c0-b1d5e463553d.gif"  width="500" height="700">

두번째 화면의 경우 recycler view이기 때문에 아래로 스크롤 하면 더 많은 화면이 등장한다! 

**Tab Layout 구현방식**

하단탭을 만들고 싶을때 bottom navigation view를 사용했다면, 상단탭을 만들기 위해서는 Tab layout을 사용하는 것이 일반적이다.
이를 위해서는 xml 코드 안에
<com.google.android.material.tabs.TabLayout 
로 시작하는 tablayout을 적어주면 된다. 
아니면 버튼처럼 끌어와서 위치시켜도 무방하다. 
이후 각 탭을 작성했을 때 새로운 화면을 보여주고 싶다면 
sample_tab.setupWithViewPager( sample_tab_viewpager) 
sample_tab. apply{
getTabAt 0 text =info
getTabAt 1 text =others}
이런식으로 코드를 넣어주면 된다


**Tab Layout 구현**

<img src="https://user-images.githubusercontent.com/71162530/99171466-aa1da780-274c-11eb-8c7c-5175ef12b91f.gif" width="500" height="700">


**POSTMAN 테스트 :서버에 이상이 없는지 체크**  

<img src="https://user-images.githubusercontent.com/71162530/99907370-d1adda80-2d1f-11eb-82ce-bf1a59dc64f0.png" width="700" height="500">
<img src="https://user-images.githubusercontent.com/71162530/99907533-8f38cd80-2d20-11eb-9ab5-a778937ce2fa.png" width="700" height="500">


**Reftrofit Interface 구현 코드**

interface SampleService{  
    @Headers("Content-Type:application/jason")  
    @POST("/users/signin")  
    fun postLogin(  
        @Body body: SampleRequestData  
    ):Call<SampleResponseData>  
}
    
      
**싱글톤으로 만드는 구현체 코드**  
   

object SampleServiceImpl {  

    private const val BASE_URL="http://15.164.83.210:3000"  
    
    private val retrofit: Retrofit= Retrofit.Builder()  
    
        .baseUrl(BASE_URL)  
        .addConverterFactory(GsonConverterFactory.create())  
        .build()  

    val service: SampleService= retrofit.create(SampleService::class.java)  
}

**Request Data 코드**


data class SampleRequestData(  

    val email: String,  
    val password: String  
)  

**Response Data 코드**  
data class SampleResponseData(  

    val data: Data,  
    @SerializedName("message")  
    val message: String,  
    val status: Int,  
    val success: Boolean  
    
) {  

    data class Data(  
    
        val email: String,  
        val password: String,  
        val userName: String  
    )  
}

**Main Activity Kotlin 파일 구성코드**
   
 override fun onCreate(savedInstanceState: Bundle?) {
 
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        first_button.setOnClickListener{


            val email_=email.text.toString()
            val password_=password.text.toString()
            val call :Call<SampleResponseData>
            call=SampleServiceImpl.service.postLogin(
            SampleRequestData(email = email_, password = password_)
            )
          call.enqueue(object :Callback<SampleResponseData>{
             override fun onFailure(call: Call<SampleResponseData>, t:Throwable){

             }
              override fun onResponse(
                  call: Call<SampleResponseData>,
                  response:Response<SampleResponseData>
              ){
                 response.takeIf { it.isSuccessful }
                     ?.body()
                     ?.let{it->
                         Toast.makeText(this@MainActivity, "${it.data.userName}님, 안녕하세요", Toast.LENGTH_SHORT).show()
                         Log.d("success", "통신성공")
                         val intent=Intent(this@MainActivity, BottomNav::class.java)
                         startActivity(intent)
                     }?:showError(response.errorBody())
              }
          }
          )


        }



        }
        
       }
       
       
**서버통신의 결과**  

값이 들어오지 않을 경우
<img src="https://user-images.githubusercontent.com/71162530/100448359-7b60e300-30f5-11eb-9773-815bac6920ca.png" width="500" height="700">
로그인 성공
<img src="https://user-images.githubusercontent.com/71162530/100449619-96cced80-30f7-11eb-88d7-3d473872136e.png" width="500" height="700">
회원가입 성공
<img src="https://user-images.githubusercontent.com/71162530/100449917-0a6efa80-30f8-11eb-8d41-171f5a839c4b.png" width="500" height="700">





