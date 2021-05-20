package ng.com.ajsprojects.rickyandmorty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if(intent.hasExtra(MainAdapter.CHARACTER_ID)){
            name.text = intent.getStringExtra(MainAdapter.CHARACTER_NAME)
            status.text = intent.getStringExtra(MainAdapter.CHARACTER_STATUS)
            specie.text = intent.getStringExtra(MainAdapter.CHARACTER_SPECIE)
            gender.text = intent.getStringExtra(MainAdapter.CHARACTER_GENDER)
            origin_name.text = intent.getStringExtra(MainAdapter.CHARACTER_ORIGIN_NAME)
            origin_url.text = intent.getStringExtra(MainAdapter.CHARACTER_ORIGIN_URL)
            Glide.with(this).load(intent.getStringExtra(MainAdapter.CHARACTER_IMAGE))
                .centerCrop().transform(CircleCrop()).into(photo)
        }
    }
}