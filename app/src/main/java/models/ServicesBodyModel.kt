package models

import com.google.gson.annotations.SerializedName

data class ServicesBodyModel(

    @SerializedName("key")
    var key : String,

    @SerializedName("action")
    var action : String

)
