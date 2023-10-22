package api

import models.CommentOrderModel
import models.NormalOrderModel
import models.OrderModel
import models.OrderStatusBodyModel
import models.OrderStatusModel
import models.ServicesBodyModel
import models.ServicesModel
import models.WalletModel
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