package com.worldsnas.core.di.modules.network

import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.internal.Util
import java.io.IOException
import java.net.ProtocolException
import javax.inject.Inject

class NoContentProtocolExceptionInterceptor @Inject constructor(
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response =
            try {
                chain.proceed(chain.request())
            } catch (e: ProtocolException) {
                Response.Builder()
                        .request(chain.request())
                        .code(204)
                        .protocol(Protocol.HTTP_1_1)
                        .message("")
                        .body(Util.EMPTY_RESPONSE)
                        .build()
            }

}
