package com.akado.typiccode.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class RemoteInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }
}