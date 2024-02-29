package network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiData {
    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://mocki.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}

/*
fun provideOKHttpClient(): OkHttpClient{
        return OkHttpClient.Builder().build()
    }

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun provideCardlessWithdrawalsService(retrofit: Retrofit) : ProfileInfoApi {
        return retrofit.create(ProfileInfoApi::class.java)
    }

* */