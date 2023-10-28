package com.ebrahimipooria.followerstore.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebrahimipooria.followerstore.R
import com.ebrahimipooria.followerstore.adapters.ServicesAdapter
import com.ebrahimipooria.followerstore.api.ApiCallInterface
import com.ebrahimipooria.followerstore.api.ApiCallServices
import com.ebrahimipooria.followerstore.api.ApiCallServices.Companion.SERVICES
import com.ebrahimipooria.followerstore.models.ServicesBodyModel
import com.ebrahimipooria.followerstore.models.ServicesModel
import com.ebrahimipooria.followerstore.utils.Connectivity
import org.json.JSONObject

class MainActivity : AppCompatActivity(), ApiCallInterface {

    private lateinit var listServiceModel: ArrayList<ServicesModel>
    private lateinit var recyclerView: RecyclerView
    private lateinit var servicesAdapter: ServicesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.rv_Main)
        recyclerView.layoutManager = GridLayoutManager(this@MainActivity , 3)
        callApi()
    }

    private fun callApi() {
        val call =  ApiCallServices(this, this)
        val servicesBodyModel = ServicesBodyModel("9a5e1ddb-bb28-4ad3-a274-a3ffcb717391","services")
        val internetConnect = Connectivity()
        if(internetConnect.checkForInternet(this)){
            call.getServices(servicesBodyModel)
        }else{
            Toast.makeText(this, "اتصال به اینترنت رو بررسی کنید!!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResponse(jsonObject: JSONObject?) {
        when(jsonObject!!.get("request")){
            SERVICES -> {
                if(jsonObject.getBoolean("isSuccess")){
                    try {
                        listServiceModel= jsonObject.get("result") as ArrayList<ServicesModel>
                        servicesAdapter = ServicesAdapter(applicationContext,listServiceModel)
                        recyclerView.adapter = servicesAdapter
                    }catch (_:Exception){

                    }

                }

            }

        }

    }



}