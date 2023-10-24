package com.ebrahimipooria.followerstore.api

import android.content.Context
import com.ebrahimipooria.followerstore.models.NormalOrderModel
import com.ebrahimipooria.followerstore.models.OrderModel
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiCallOrder(var context: Context, var apiCallInterface: ApiCallInterface) {
    private var apiInterface: ApiInterface

    companion object {
        const val SERVICES : String = "Services"
    }

    init {
        val retrofit = RetrofitClient.getInstance()
        apiInterface = retrofit.create(ApiInterface::class.java)
    }

    fun apiResponseJsonCreator(
        requestUrl: String?,
        isSuccess: Boolean,
        response: OrderModel?
    ): JSONObject {
        val jsonObject = JSONObject()
        try {
            jsonObject.put("request", requestUrl)
            jsonObject.put("isSuccess", isSuccess)
            jsonObject.put("result", response)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return jsonObject
    }


    fun saveOrder(normalOrderModel: NormalOrderModel){
        apiInterface.saveNormalOrder(normalOrderModel).enqueue(object : Callback<OrderModel>{
            override fun onResponse(call: Call<OrderModel>, response: Response<OrderModel>) {
                if (response.isSuccessful) {
                    val post = response.body()
                    apiCallInterface.onResponse(
                        apiResponseJsonCreator(
                            SERVICES,
                            true,
                            post
                        )
                    )
                } else {
                    apiCallInterface.onResponse(
                        apiResponseJsonCreator(
                            SERVICES,
                            false,
                            null
                        ))
                }
            }

            override fun onFailure(call: Call<OrderModel>, t: Throwable) {
                apiCallInterface.onResponse(
                    apiResponseJsonCreator(
                        SERVICES,
                        false,
                        null
                    ))
            }

        })
    }



}