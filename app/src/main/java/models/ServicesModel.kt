package models

import com.google.gson.annotations.SerializedName

data class ServicesModel(

    @SerializedName("ID")
    var ID : Int,

    @SerializedName("id")
    var id : Int,

    @SerializedName("service")
    var service : Int,

    @SerializedName("service_id")
    var service_id : Int,

    @SerializedName("name")
    var name : String,

    @SerializedName("category")
    var category : String,

    @SerializedName("rate")
    var rate : String,

    @SerializedName("cost")
    var cost : String,

    @SerializedName("price")
    var price : String,

    @SerializedName("currency")
    var currency : String,

    @SerializedName("min")
    var min : Int,

    @SerializedName("max")
    var max : Int,

    @SerializedName("type")
    var type : String,

    @SerializedName("desc")
    var desc : String,

    @SerializedName("description")
    var description : String,

    @SerializedName("dripfeed")
    var dripfeed : Int

)
