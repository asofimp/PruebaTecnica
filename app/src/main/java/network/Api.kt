package network

import model.Donut
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object Api {
    private val urlBase = "https://mocki.io/"
    private val builder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl(urlBase)
        .addConverterFactory(GsonConverterFactory.create())

    interface RemoteService{
        @GET("v1/eeced007-6b29-4c9d-ab63-c115a990d927")
        fun getDonuts(): Call<List<Donut>>

    }

    fun build(): RemoteService{
        return builder.build().create(RemoteService::class.java)
    }
}