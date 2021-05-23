package ng.com.ajsprojects.rickyandmorty

import ng.com.ajsprojects.rickyandmorty.models.CharacterData
import retrofit2.Call
import retrofit2.http.GET

interface CharacterService {

    @GET("character")
    fun getCharacterList(): Call<List<CharacterData>>
}