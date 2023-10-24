package com.ebrahimipooria.followerstore.models

import com.google.gson.annotations.SerializedName

data class OrderStatusBodyModel(

    @SerializedName("key")
    var key : String,

    @SerializedName("action")
    var action : String,

    @SerializedName("order")
    var order : Int

)
