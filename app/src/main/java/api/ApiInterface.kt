package api

import models.ServicesModel
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @POST("/api/smart-panel")
    fun getServicesList(
        @Query("key") key: String,
        @Query("action") action: String
    ): Call<List<ServicesModel>>

}