package models

import com.google.gson.annotations.SerializedName

data class WalletModel(

    @SerializedName("status ")
    var status : String,

    @SerializedName("balance")
    var balance : String,

    @SerializedName("currency")
    var currency : String

)
