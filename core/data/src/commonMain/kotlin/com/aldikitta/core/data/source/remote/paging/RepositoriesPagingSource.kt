package com.aldikitta.core.data.source.remote.paging

import androidx.paging.PagingSource
import app.cash.paging.PagingSourceLoadResultError
import app.cash.paging.PagingSourceLoadResultPage
import app.cash.paging.PagingState
import com.aldikitta.core.data.utils.Url
import com.aldikitta.core.domain.source.remote.MovieApi
import com.aldikitta.core.dto.RepositoryResponse


class RepositoriesPagingSource(private val movieApi: MovieApi) :
    PagingSource<Int, RepositoryResponse.RepositoryItemResponse>() {

    private var username: String = ""

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RepositoryResponse.RepositoryItemResponse> {
        val currentPage = params.key ?: 1

        return try {
            val query = mapOf(
                "page" to currentPage,
                "per_page" to params.loadSize
            )

            val response = movieApi.getDataPagingRepositories(
                Url.REPOSITORY_USER.replace("username", username),
                query = query
            )

            PagingSourceLoadResultPage(
                data = response,
                prevKey = (currentPage - 1).takeIf { currentPage != 1 },
                nextKey = (currentPage + 1).takeIf {
                    response.isNotEmpty()
                }
            )
        } catch (e: Exception) {
            PagingSourceLoadResultError(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, RepositoryResponse.RepositoryItemResponse>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }

    fun setUsername(username: String) {
        this.username = username
    }
}