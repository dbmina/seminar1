package org.techtown.hw1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        first_button.setOnClickListener{
          val call:Call<SampleResponseData>
            val email=email.toString()
            val password=password.toString()
            call=SampleServiceImpl.service.postLogin(
            SampleRequestData(email = email, password = password)
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


