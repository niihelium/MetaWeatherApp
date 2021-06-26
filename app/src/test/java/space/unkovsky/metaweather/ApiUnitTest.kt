package space.unkovsky.metaweather

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import space.unkovsky.metaweather.data.remote.MetaWeatherApiService
import space.unkovsky.metaweather.data.remote.LatLonDeserializer
import space.unkovsky.metaweather.data.remote.dto.LatLonDto


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ApiUnitTest {
    private lateinit var apiService: MetaWeatherApiService
    private fun createGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(
                LatLonDto::class.java,
                LatLonDeserializer()
            )
            .create()
    }

    private fun remoteApi(baseUrl: String, gson: Gson): MetaWeatherApiService {
        return Retrofit.Builder()
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(baseUrl)
            .build()
            .create(MetaWeatherApiService::class.java)
    }

    @Before
    fun before() {
        apiService = remoteApi("https://www.metaweather.com/", createGson())
    }


    @Test
    fun locationSearchTest() {
        runBlocking {
            val response = apiService.locationSearch("san")
            if (response.isSuccessful) {
                print(response.body())
            } else {
                print("Error : ${response.message()} ")
            }
        }
    }

    @Test
    fun locationTest() {
        runBlocking {
            val response = apiService.locationWeather(2123260)
            if (response.isSuccessful) {
                val res = response.body()
                print(res)
            } else {
                print("Error : ${response.message()} ")
            }
        }
    }
}