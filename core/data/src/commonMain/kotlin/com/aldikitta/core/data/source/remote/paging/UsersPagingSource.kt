package com.aldikitta.core.data.source.remote.paging

import app.cash.paging.PagingSource
import app.cash.paging.PagingSourceLoadResultError
import app.cash.paging.PagingSourceLoadResultPage
import app.cash.paging.PagingState
import com.aldikitta.core.data.utils.Url
import com.aldikitta.core.domain.source.remote.MovieApi
import com.aldikitta.core.dto.UserResponse

class UsersPagingSource(private val movieApi: MovieApi) : PagingSource<Int, UserResponse.UserItemResponse>() {
    private var search: String = ""

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserResponse.UserItemResponse> {
        val currentPage = params.key ?: 1

        return try {
            val query = mapOf(
                "q" to search,
                "page" to currentPage,
                "per_page" to params.loadSize
            )
            val response = movieApi.getDataPagingUsers(Url.SEARCH_USERS, query = query)

            PagingSourceLoadResultPage(
                data = response.items ?: listOf(),
                prevKey = (currentPage - 1).takeIf { currentPage != 1 },
                nextKey = (currentPage + 1).takeIf {
                    (currentPage * params.loadSize) < (response.totalCount ?: 0)
                }
            )
        } catch (e: Exception) {
            PagingSourceLoadResultError(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UserResponse.UserItemResponse>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }

    fun setSearchQuery(query: String) {
        search = query.ifBlank { "a" }
    }
}