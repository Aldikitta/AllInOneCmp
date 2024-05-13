package com.aldikitta.core.data.source.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import app.cash.paging.PagingSourceLoadResultError
import app.cash.paging.PagingSourceLoadResultPage
import com.aldikitta.core.data.utils.Url
import com.aldikitta.core.domain.source.remote.MovieApi
import com.aldikitta.core.dto.FollowItemResponse

class FollowsPagingSource(private val movieApi: MovieApi) :
    PagingSource<Int, FollowItemResponse>() {

    private var username: String = ""
    private var type: String = ""

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FollowItemResponse> {
        val currentPage = params.key ?: 1

        return try {
            val query = mapOf(
                "page" to currentPage,
                "per_page" to params.loadSize
            )

            val response = movieApi.getDataPagingFollows(
                Url.FOLLOW_USER.replace("username", username).replace("follow", type),
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

    override fun getRefreshKey(state: PagingState<Int, FollowItemResponse>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }

    fun setData(username: String, type: String) {
        this.username = username
        this.type = type
    }
}