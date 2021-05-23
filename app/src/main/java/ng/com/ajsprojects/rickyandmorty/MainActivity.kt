package ng.com.ajsprojects.rickyandmorty

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ng.com.ajsprojects.rickyandmorty.models.CharacterData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadCharacters()

    }

    private fun loadCharacters() {
        //initiate the service
        val destinationService  = ServiceBuilder.buildService(CharacterService::class.java)
        val requestCall =destinationService.getCharacterList()
        //make network call asynchronously
        requestCall.enqueue(object : Callback<List<CharacterData>> {
            override fun onResponse(call: Call<List<CharacterData>>, response: Response<List<CharacterData>>) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val characterList  = response.body()!!
                    Log.d("Response", "characterlist size : ${characterList.size}")
                    recyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = GridLayoutManager(this@MainActivity,2)
                        adapter = CharacterAdapter(response.body()!!)
                    }
                }else{
                    Toast.makeText(this@MainActivity, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<CharacterData>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Something went wrong $t", Toast.LENGTH_SHORT).show()
            }
        })
    }


}