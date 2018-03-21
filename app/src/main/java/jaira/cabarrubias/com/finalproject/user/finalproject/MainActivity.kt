package jaira.cabarrubias.com.finalproject.user.finalproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var searchAlbum = ArrayList<Album>()
    private val url = "http://ws.audioscrobbler.com/2.0/?method=album.search&album=believe&api_key=554b0d9dfe8d7959568d15556ecbd485&format=json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar.visibility = GONE

    }
    }
