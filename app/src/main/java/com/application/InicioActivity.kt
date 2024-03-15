package com.application

import adapter.AdapterData
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import model.Donut
import network.Api
import retrofit2.Response

class InicioActivity : AppCompatActivity() {
    lateinit var recyclerView : RecyclerView
    lateinit var donuts: List<Donut>
    lateinit var adapterData : AdapterData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)


        recyclerView = findViewById(R.id.rv_data)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        init()

    }

    private fun init() {

        val request = Api.build().getDonuts()
        request.enqueue(object : retrofit2.Callback<List<Donut>> {
            override fun onResponse(
                call: retrofit2.Call<List<Donut>>,
                response: Response<List<Donut>>
            ) {
                if (response.isSuccessful) {
                    val donutResponse = response.body()
                    donuts = donutResponse ?: emptyList()
                    adapterData = AdapterData(donuts)
                    recyclerView.adapter = adapterData
                } else {
                    println("Error en la respuesta: ${response.code()}")
                }
            }

            override fun onFailure(call: retrofit2.Call<List<Donut>>, t: Throwable) {
                println(t.message)
            }
        })
    }
}

/*
fun showMovies() {
    val call: Call<List<Movie>> = ApiClient.getClient().create(ApiMovie::class.java).getMovies()
    call.enqueue(object : Callback<List<Movie>> {
        override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
            if (response.isSuccessful) {
                movies = response.body()
                movieAdapter = MovieAdapter(movies, applicationContext)
                recyclerView.adapter = movieAdapter
            }
        }

        override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
            Toast.makeText(this@Inicio, "Error de conexión", Toast.LENGTH_SHORT).show()
        }
    })
}
 */

