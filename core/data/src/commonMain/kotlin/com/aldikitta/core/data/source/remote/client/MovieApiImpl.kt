package com.aldikitta.core.data.source.remote.client

import com.aldikitta.core.domain.source.remote.MovieApi
import com.aldikitta.core.dto.FollowItemResponse
import com.aldikitta.core.dto.RepositoryResponse
import com.aldikitta.core.dto.UserResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse

class MovieApiImpl(private val client: MovieClient) : MovieApi {
    override suspend fun getData(url: String, query: Map<String, Any>?): HttpResponse {
        return client.createHttpClient().get(url) {
            query?.forEach {
                parameter(it.key, it.value)
            }
        }.body()
    }

    override suspend fun getDataPagingFollows(
        url: String,
        query: Map<String, Any>?
    ): List<FollowItemResponse> {
        return client.createHttpClient().get(url) {
            query?.forEach {
                parameter(it.key, it.value)
            }
        }.body()
    }

    override suspend fun getDataPagingRepositories(
        url: String,
        query: Map<String, Any>?
    ): List<RepositoryResponse.RepositoryItemResponse> {
        return client.createHttpClient().get(url) {
            query?.forEach {
                parameter(it.key, it.value)
            }
        }.body()
    }

    override suspend fun getDataPagingUsers(
        url: String,
        query: Map<String, Any>?
    ): UserResponse.UsersResponse {
        return client.createHttpClient().get(url) {
            query?.forEach {
                parameter(it.key, it.value)
            }
        }.body()
    }
}