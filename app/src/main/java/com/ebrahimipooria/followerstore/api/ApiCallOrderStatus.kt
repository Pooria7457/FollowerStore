package com.ebrahimipooria.followerstore.api

import android.content.Context
import com.ebrahimipooria.followerstore.models.OrderStatusBodyModel
import com.ebrahimipooria.followerstore.models.OrderStatusModel
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiCallOrderStatus(var context: Context, var apiCallInterface: ApiCallInterface) {
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
        response: OrderStatusModel?
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


    fun orderStatus(orderStatusBodyModel: OrderStatusBodyModel){
        apiInterface.getOrderStatus(orderStatusBodyModel).enqueue(
            object : Callback<OrderStatusModel>{
            override fun onResponse(
                call: Call<OrderStatusModel>,
                response: Response<OrderStatusModel>
            ) {
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

            override fun onFailure(call: Call<OrderStatusModel>, t: Throwable) {
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