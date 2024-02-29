package com.application

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import adapter.AdapterData
import model.Donut
import network.ApiData
import network.ApiDataRoute
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InicioActivity : AppCompatActivity() {

    private lateinit var adapterData: AdapterData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val recyclerView: RecyclerView = findViewById(R.id.rv_data)

        showData(recyclerView)
    }

    private fun showData(recyclerView: RecyclerView) {
        val apiService: ApiDataRoute = ApiData.getClient().create(ApiDataRoute::class.java)
        val call: Call<List<Donut>> = apiService.getDonuts()

        call.enqueue(object : Callback<List<Donut>> {
            override fun onResponse(call: Call<List<Donut>>, response: Response<List<Donut>>) {
                if (response.isSuccessful) {
                    val datos: List<Donut>? = response.body()
                    datos?.let {
                        adapterData = AdapterData(it, applicationContext)
                        recyclerView.adapter = adapterData
                    }
                } else {
                    Toast.makeText(applicationContext, "Error en la respuesta del servidor", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Donut>>, t: Throwable) {
                Toast.makeText(applicationContext, "Error en la conexión al servidor", Toast.LENGTH_SHORT).show()
            }
        })
    }
}



/*import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import adapter.AdapterData
import androidx.lifecycle.MutableLiveData
import model.Donut
import network.ApiData
import network.ApiDataRoute
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class InicioActivity : AppCompatActivity() {

    private lateinit var adapterData: AdapterData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_item_donuts)

        showData()
    }

    private fun showData() :MutableLiveData{
        val call: Call<List<Donut>> = ApiDataRoute.getClient

        call.enqueue(object : Callback<List<Donut>> {
            override fun onResponse(call: Call<List<Donut>>, response: Response<List<Donut>>) {
                if (response.isSuccessful) {
                    val datos: List<Donut>? = response.body()
                    datos?.let {
                        adapterData = AdapterData(it, applicationContext)

                    }
                } else {
                    Toast.makeText(applicationContext, "Error en la respuesta del servidor", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Donut>>, t: Throwable) {
                Toast.makeText(applicationContext, "Error en la conexión al servidor", Toast.LENGTH_SHORT).show()
            }
        })
    }
}*/
