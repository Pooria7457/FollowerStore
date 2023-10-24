package com.ebrahimipooria.followerstore.api

import org.json.JSONObject




interface ApiCallInterface {
    fun onResponse(jsonObject: JSONObject?)
}