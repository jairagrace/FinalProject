package jaira.cabarrubias.com.finalproject.user.finalproject

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by user on 21/03/2018.
 */
class AlbumAdapter(private val album: ArrayList<Album>) : RecyclerView.Adapter<AlbumAdapter.CustomVIewHolder>() {

    override fun getItemCount(): Int {
        return album.size
    }

    override fun onBindViewHolder(holder: CustomVIewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomVIewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.activity_main, parent, false)
        return CustomVIewHolder(itemView)
    }


    class CustomVIewHolder(var view: View) : RecyclerView.ViewHolder(view){

    }
}