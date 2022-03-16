package com.able.common.net.okhttp

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * 常用的拦截器
 */
class CommonInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val builder = addHeaders(request.newBuilder())
        val response = chain.proceed(builder)
        return response
    }

    private fun addHeaders(builder: Request.Builder): Request {
        return builder.addHeader("Content_Type", "application/json").addHeader("charset", "UTF-8")
            .build()
    }
}
