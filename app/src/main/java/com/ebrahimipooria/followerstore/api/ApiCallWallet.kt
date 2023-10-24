package com.ebrahimipooria.followerstore.api

import android.content.Context
import com.ebrahimipooria.followerstore.models.ServicesBodyModel
import com.ebrahimipooria.followerstore.models.WalletModel
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiCallWallet(var context: Context, var apiCallInterface: ApiCallInterface) {
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
        response: WalletModel?
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

    fun getWallet(servicesBodyModel: ServicesBodyModel){
        apiInterface.getWalletInventory(servicesBodyModel).enqueue(
            object : Callback<WalletModel>{
            override fun onResponse(call: Call<WalletModel>, response: Response<WalletModel>) {
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

            override fun onFailure(call: Call<WalletModel>, t: Throwable) {
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