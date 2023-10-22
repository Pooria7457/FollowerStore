package models

import com.google.gson.annotations.SerializedName

data class CommentOrderModel(

    @SerializedName("key")
    var key : String,

    @SerializedName("action")
    var action : String,

    @SerializedName("service")
    var service : Int,

    @SerializedName("link ")
    var link : String,

    @SerializedName("comments")
    var comments : String

)
