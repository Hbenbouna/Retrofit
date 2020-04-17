package retrofitjson.Ben.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_movie_items.view.*
import retrofitjson.Ben.Model.Movies
import retrofitjson.Ben.R

class MyMovieAdapter(private val context: Context, private val movieList: MutableList<Movies>): RecyclerView.Adapter<MyMovieAdapter.MyViewHolder>()  {
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var image : ImageView
        var txt_name : TextView
        var txt_team : TextView
        var txt_createdby : TextView

        init {
            image = itemView.image_movie
            txt_name = itemView.txt_name
            txt_team = itemView.txt_team
            txt_createdby = itemView.txt_Createdby
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.layout_movie_items, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Picasso.get().load(movieList[position].imageurl).into(holder.image)
        holder.txt_name.text = movieList[position].name
        holder.txt_team.text = movieList[position].team
        holder.txt_createdby.text = movieList[position].createdby

    }
}