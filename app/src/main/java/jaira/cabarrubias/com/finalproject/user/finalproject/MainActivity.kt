package jaira.cabarrubias.com.finalproject.user.finalproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
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
            val resultJson = URL(url +tempName).readText()
            val jsonObject = JSONObject(resultJson)
            val alsongName = jsonObject.getString("songName")
            val alSinger = jsonObject.getString("singer")
            val alYear = jsonObject.getString("year")
            val alGenre = jsonObject.getString("genre")
            val bandname = jsonObject.getString("bandName")
            val pokemonSprites = jsonObject.getJSONObject("sprites").getString("front_default")

        }
    }
}
