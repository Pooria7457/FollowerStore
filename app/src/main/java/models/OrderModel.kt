package models

import com.google.gson.annotations.SerializedName

data class OrderModel(

    @SerializedName("status")
    var status :String,

    @SerializedName("order")
    var order :Int

)
