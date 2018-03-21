package jaira.cabarrubias.com.finalproject.user.finalproject

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

/**
 * Created by user on 21/03/2018.
 */
class AlbumAdapter(private val album: ArrayList<Album>) : RecyclerView.Adapter<AlbumAdapter.CustomVIewHolder>() {

    override fun getItemCount(): Int {
        return album.size
    }

    override fun onBindViewHolder(holder: CustomVIewHolder?, position: Int) {
        val albumdetail : Album = album[position]
        holder?.AlbumName?.text = albumdetail.songName
        holder?.AlbumArtist?.text = albumdetail.songName
        val AlbumImg = holder?.ImgAlbum


        Picasso.with(holder?.view?.context).load(albumdetail.sprites.frontDefault).into(AlbumImg)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomVIewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.activity_main, parent, false)
        return CustomVIewHolder(itemView)
    }


    class CustomVIewHolder(var view: View) : RecyclerView.ViewHolder(view){
        val AlbumName = view.findViewById<TextView>(R.id.txtAlbumName)
        val AlbumArtist = view.findViewById<TextView>(R.id.txtAlbumArtist)
        val ImgAlbum = view.findViewById<ImageView>(R.id.imgAlbum)


    }
}