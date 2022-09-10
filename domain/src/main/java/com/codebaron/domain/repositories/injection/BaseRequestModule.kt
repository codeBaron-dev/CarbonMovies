package com.codebaron.domain.repositories.injection

import com.codebaron.core.BASE_URL
import com.codebaron.domain.repositories.BaseEndPoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since 10-09-2022
 */
@Module
@InstallIn(SingletonComponent::class)
object BaseRequestModule {

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().apply {
            readTimeout(120, TimeUnit.SECONDS)
            connectTimeout(120, TimeUnit.SECONDS)
            addInterceptor(httpLoggingInterceptor).addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer ")
                    .addHeader("deviceType", "Android")
                    .addHeader("deviceId", "")
                    .addHeader("Active-Nuban", "")
                    .addHeader("deviceName", "")
                    .addHeader("appVersion", "")
                    .build()
                chain.proceed(request)
            }
        }.build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideEndPoints(retrofit: Retrofit): BaseEndPoints = retrofit.create(BaseEndPoints::class.java)
}