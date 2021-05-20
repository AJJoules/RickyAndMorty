package ng.com.ajsprojects.rickyandmorty.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Result(

    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("image")
    val photoUrl: String,

    val id: Int,
    val species: String,
    val gender: String,
    @SerializedName("origin")
    val origin: Origin
) : Serializable
