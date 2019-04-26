package com.worldsnas.domain

import com.worldsnas.core.ErrorHolder
import com.worldsnas.domain.model.servermodels.error.ErrorServerModel
import io.reactivex.Single
import org.json.JSONObject
import retrofit2.Response

val Response<*>.isNotSuccessful
    get() = !isSuccessful

fun Response<*>.getErrorServerModel(): ErrorServerModel =
    errorBody()
        ?.use { it.string() }
        ?.let {
            try {
                JSONObject(it)
            } catch (e: Exception) {
                null
            }
        }
        .let {
            val code = it?.optInt("status_code", this.code()) ?: 0
            val message = it?.optString("status_message", this.message() ?: "") ?: ""

            ErrorServerModel(message, code)
        }

fun Response<*>.getErrorRepoModel(): ErrorHolder =
    errorBody()
        ?.use { it.string() }
        ?.let {
            try {
                JSONObject(it)
            } catch (e: Exception) {
                null
            }
        }
        .let {
            val code = it?.optInt("status_code", this.code()) ?: 0
            val message = it?.optString("status_message", this.message() ?: "") ?: ""

            ErrorHolder(message, code)
        }

fun Single<Response<*>>.defaultRetrofitRetry(times: Int = 3) =
    retry { retried, _ ->
        retried <= times
    }