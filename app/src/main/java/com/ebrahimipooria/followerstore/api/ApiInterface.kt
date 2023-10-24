package com.ebrahimipooria.followerstore.api

import com.ebrahimipooria.followerstore.models.CommentOrderModel
import com.ebrahimipooria.followerstore.models.NormalOrderModel
import com.ebrahimipooria.followerstore.models.OrderModel
import com.ebrahimipooria.followerstore.models.OrderStatusBodyModel
import com.ebrahimipooria.followerstore.models.OrderStatusModel
import com.ebrahimipooria.followerstore.models.ServicesBodyModel
import com.ebrahimipooria.followerstore.models.ServicesModel
import com.ebrahimipooria.followerstore.models.WalletModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiInterface {

    @POST("/api/smart-panel")
    fun getServicesList(
        @Body servicesBodyModel: ServicesBodyModel
    ): Call<List<ServicesModel>>

    @POST("/api/smart-panel")
    fun saveNormalOrder(
        @Body normalOrderModel: NormalOrderModel
    ): Call<OrderModel>

    @POST("/api/smart-panel")
    fun saveCommentOrder(
        @Body commentOrderModel: CommentOrderModel
    ): Call<OrderModel>

    @POST("/api/smart-panel")
    fun getWalletInventory(
        @Body servicesBodyModel: ServicesBodyModel
    ): Call<WalletModel>

    @POST("/api/smart-panel")
    fun getOrderStatus(
        @Body orderStatusBodyModel: OrderStatusBodyModel
    ): Call<OrderStatusModel>

}