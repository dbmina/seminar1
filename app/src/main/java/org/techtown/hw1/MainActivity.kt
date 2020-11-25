package org.techtown.hw1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
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


    private fun showError(error:ResponseBody?){
        val e=error?:return
        val ob=JSONObject(e.string())
        Toast.makeText(this, ob.getString("message"), Toast.LENGTH_SHORT).show()
    }

    }

