package jaira.cabarrubias.com.finalproject.user.finalproject

import com.google.gson.annotations.SerializedName

/**
 * Created by user on 21/03/2018.
 */
data class Album(
        val songName :String,
        val singer : String,
        val year: StringBuffer,
        val genre : String,
        val bandName : String,
        val sprites :Sprites
)

data class Sprites(@SerializedName("front_default")
                   val frontDefault: String
)
