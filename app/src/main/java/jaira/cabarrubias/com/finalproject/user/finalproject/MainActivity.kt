package jaira.cabarrubias.com.finalproject.user.finalproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.album_row.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {

    private var searchAlbum = ArrayList<Album>()
    private val url = "http://ws.audioscrobbler.com/2.0/?method=album.search&album=believe&api_key=554b0d9dfe8d7959568d15556ecbd485&format=json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar.visibility = GONE


        fetchAlbum()

    }

    private fun fetchAlbum() {
        doAsync {
            val tempName = etAlbum.text.toString()
            val resultJson = URL(url + tempName).readText()
            val jsonObject = JSONObject(resultJson)
            val alsongName = jsonObject.getString("songName")
            val alSinger = jsonObject.getString("singer")
            val alYear = jsonObject.getString("year")
            val alGenre = jsonObject.getString("genre")
            val bandname = jsonObject.getString("bandName")
            val albumSprites = jsonObject.getJSONObject("sprites").getString("front_default")

            uiThread {
                recyclerView.adapter = AlbumAdapter(searchAlbum)
                searchAlbum.add(Album(Sprites(albumSprites),
                        alsongName,
                        alSinger,
                        alYear,
                        alGenre,
                        bandname

                ))


                Picasso.with(this@MainActivity).load(albumSprites).into(imgAlbum)

                progressBar.visibility = View.GONE
                tvMessage.visibility = View.VISIBLE


            }
        }
    }
}

