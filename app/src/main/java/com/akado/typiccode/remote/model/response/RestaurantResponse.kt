package com.akado.typiccode.remote.model.response

import com.akado.typiccode.remote.model.RestaurantRemoteModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RestaurantResponse(

    @SerializedName("list")
    @Expose
    val list: List<RestaurantRemoteModel>
)