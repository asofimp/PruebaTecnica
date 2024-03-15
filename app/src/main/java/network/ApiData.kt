package network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiData {
    private const val urlBase = "https://mocki.io/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(urlBase)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(ApiDataRoute::class.java)

}


