package models

import com.google.gson.annotations.SerializedName

data class OrderStatusModel(

    @SerializedName("order")
    var order : Int,

    @SerializedName("status")
    var status : String,

    @SerializedName("charge")
    var charge : String,

    @SerializedName("start_count")
    var start_count : String,

    @SerializedName("remains")
    var remains : String

)
