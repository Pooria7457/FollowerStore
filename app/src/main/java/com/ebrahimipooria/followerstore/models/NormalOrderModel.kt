package com.ebrahimipooria.followerstore.models

import com.google.gson.annotations.SerializedName

data class NormalOrderModel(

    @SerializedName("key")
    var key : String,

    @SerializedName("action")
    var action : String,

    @SerializedName("service")
    var service : Int,

    @SerializedName("link")
    var link : String,

    @SerializedName("quantity")
    var quantity : Int

)
