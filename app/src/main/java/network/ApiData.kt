import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiData {
    private var retrofit: Retrofit? = null

    fun getData(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://mocki.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}