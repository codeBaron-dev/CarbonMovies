package com.codebaron.domain

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.codebaron.core.API_KEY
import com.codebaron.core.LANGUAGE_TYPE
import com.codebaron.core.PAGE_PARAM
import com.codebaron.domain.allmoviesrepository.AllMoviesRepositoryImplementation
import com.codebaron.domain.repositories.BaseEndPoints
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(JUnit4::class)
class ExampleUnitTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    private val server = MockWebServer()
    private lateinit var repository: AllMoviesRepositoryImplementation
    private lateinit var mockedResponse: String
    private val context: Context? = null
    private val gson = GsonBuilder()
        .setLenient()
        .create()

    @Before
    fun init() {
        server.start(8000)
        val BASE_URL = server.url("/").toString()
        val okHttpClient = OkHttpClient
            .Builder()
            .build()
        val service = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build().create(BaseEndPoints::class.java)
        repository = AllMoviesRepositoryImplementation(service)
    }

    @Test
    fun testApiSuccess() {
        mockedResponse = MockResponseFileReader("com/codebaron/domain/Success.json").content
        server.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(mockedResponse)
        )
        val response = runBlocking {
            if (context != null) {
                repository.getAllMovies(API_KEY, LANGUAGE_TYPE, PAGE_PARAM, context)
            }
        }
        val json = gson.toJson(response)
        val resultResponse = JsonParser().parse(json)
        val expectedResponse = JsonParser().parse(mockedResponse)
        Assert.assertNotNull(response)
        Assert.assertTrue(resultResponse.equals(expectedResponse))
    }


    @After
    fun tearDown() {
        server.shutdown()
    }
}