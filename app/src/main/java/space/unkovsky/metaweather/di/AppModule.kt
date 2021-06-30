package space.unkovsky.metaweather.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import space.unkovsky.metaweather.BuildConfig
import space.unkovsky.metaweather.Constants
import space.unkovsky.metaweather.data.remote.LatLonDeserializer
import space.unkovsky.metaweather.data.remote.MetaWeatherApi
import space.unkovsky.metaweather.data.remote.MetaWeatherApiService
import space.unkovsky.metaweather.data.remote.MetaWeatherRetrofitApi
import space.unkovsky.metaweather.data.remote.dto.LatLonDto
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(LatLonDto::class.java, LatLonDeserializer())
            .create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
        } else {
            OkHttpClient
                .Builder()
                .build()
        }
    }

    @Provides
    @Singleton
    fun provideRetrofit(BASE_URL: String, okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): MetaWeatherApiService {
        return retrofit.create(MetaWeatherApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideMetaWeatherRetrofitApi(metaWeatherApi: MetaWeatherRetrofitApi): MetaWeatherApi {
        return metaWeatherApi
    }
}