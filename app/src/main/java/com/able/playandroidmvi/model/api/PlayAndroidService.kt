package com.able.playandroidmvi.model.api

import com.able.playandroidmvi.model.BaseResponse
import com.able.mvp.model.response.LoginResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST


interface PlayAndroidService {
    companion object {
        fun create(): PlayAndroidService {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            val okHttpClient = OkHttpClient.Builder().addInterceptor(logger).build()
            return Retrofit.Builder()
//                .baseUrl(BuildConfig.BaseUrl)
                .client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
                .create(PlayAndroidService::class.java)
        }
    }

    /**
     * 登录
     */
    @POST("user/login")
    suspend fun updateUser(
        @Field("username") username: String,
        @Field("password") password: String
    ): BaseResponse<LoginResponse>

    /**
     * 注册
     */
    @POST("user/register")
    suspend fun updateUser(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassword: String
    ): String

    /**
     * 忘记密码
     */
    @GET("user/logout/json")
    suspend fun updateUser(): String
}
