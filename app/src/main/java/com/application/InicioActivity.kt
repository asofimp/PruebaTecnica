package com.application

import AdapterData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import model.data
import network.ApiDataRoute
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class InicioActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterData: AdapterData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        recyclerView = findViewById(R.id.rV_Data)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)

        showData()
    }

    private fun showData() {
        val call: Call<List<data>> = ApiData.getData().create(ApiDataRoute::class.java).getData()

        call.enqueue(object : Callback<List<data>> {
            override fun onResponse(call: Call<List<data>>, response: Response<List<data>>) {
                if (response.isSuccessful) {
                    val datos: List<data>? = response.body()
                    datos?.let {
                        adapterData = AdapterData(it, applicationContext)
                        recyclerView.adapter = adapterData
                    }
                } else {
                    Toast.makeText(applicationContext, "arreglo malo", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<data>>, t: Throwable) {
                Toast.makeText(applicationContext, "Error en el servidor", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
