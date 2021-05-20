package ng.com.ajsprojects.rickyandmorty

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ng.com.ajsprojects.rickyandmorty.models.Result

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProviders.of(this)[ViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = MainAdapter(object : MainAdapter.OnItemClickedListener {
            override fun onItemClicked(result: Result) {
                val selectedItem = result.id
                val intent = Intent(applicationContext, DetailActivity::class.java)
                intent.putExtra(MainAdapter.CHARACTER_NAME, result.name)
                intent.putExtra(MainAdapter.CHARACTER_IMAGE, result.photoUrl)
                intent.putExtra(MainAdapter.CHARACTER_STATUS, result.status)
                intent.putExtra(MainAdapter.CHARACTER_SPECIE, result.species)
                intent.putExtra(MainAdapter.CHARACTER_GENDER, result.gender)
                intent.putExtra(MainAdapter.CHARACTER_ORIGIN_NAME,result.origin.name)
                intent.putExtra(MainAdapter.CHARACTER_ORIGIN_URL,result.origin.url)
                startActivity(intent)

            }
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        viewModel.getCharacters().observe(this, {
            adapter.setupData(it.results)
            adapter.notifyDataSetChanged()
        })

    }
}