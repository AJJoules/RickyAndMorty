package ng.com.ajsprojects.rickyandmorty

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ng.com.ajsprojects.rickyandmorty.models.CharacterData

class CharacterAdapter(private val characterList: List<CharacterData>) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = characterList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${characterList.size} ")
        return holder.bind(characterList[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var imageView = view.findViewById<ImageView>(R.id.ivCharacter)
        var tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        var tvSpecies = view.findViewById<TextView>(R.id.tvSpecies)
        var tvStatus = view.findViewById<TextView>(R.id.tvStatus)
        fun bind(character: CharacterData) {

            tvTitle.text = character.name
            tvSpecies.text = character.species
            tvStatus.text = character.status
            Picasso.get().load(character.image).into(imageView)
        }
    }
}
