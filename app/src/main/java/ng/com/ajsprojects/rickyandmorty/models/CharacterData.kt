package ng.com.ajsprojects.rickyandmorty.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CharacterData(

    @SerializedName("results")
    val results: List<Result>
) : Serializable
