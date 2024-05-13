package com.aldikitta.core.data.repository

import androidx.compose.ui.graphics.Color
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import app.cash.paging.map
import com.aldikitta.core.data.source.remote.RemoteDataSource
import com.aldikitta.core.data.source.remote.paging.FollowsPagingSource
import com.aldikitta.core.data.source.remote.paging.RepositoriesPagingSource
import com.aldikitta.core.data.source.remote.paging.UsersPagingSource
import com.aldikitta.core.data.utils.Url
import com.aldikitta.core.domain.repository.MovieRepository
import com.aldikitta.core.dto.DetailResponse
import com.aldikitta.core.mapper.DataMapper.mapToDetailModel
import com.aldikitta.core.mapper.DataMapper.mapToFollowItemModel
import com.aldikitta.core.mapper.DataMapper.mapToRepositoryItemModel
import com.aldikitta.core.mapper.DataMapper.mapToUserItemModel
import com.aldikitta.core.model.DetailModel
import com.aldikitta.core.model.FollowItemModel
import com.aldikitta.core.model.RepositoryItemModel
import com.aldikitta.core.model.UserItemModel
import com.aldikitta.core.utils.UiState
import com.aldikitta.core.utils.mapState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.random.Random

class MovieRepositoryImpl(
    private val userPagingSource: UsersPagingSource,
    private val repositoryPagingSource: RepositoriesPagingSource,
    private val followPagingSource: FollowsPagingSource,
    private val remoteDataSource: RemoteDataSource,
) : MovieRepository {
    override fun getUsers(query: String): Flow<PagingData<UserItemModel>> = Pager(
        config = PagingConfig(
            pageSize = 10,
            initialLoadSize = 10,
        ),
        pagingSourceFactory = {
            userPagingSource.apply {
                setSearchQuery(query)
            }
        },
    ).flow.map { pagingData ->
        pagingData.map { data ->
            data.mapToUserItemModel()
        }
    }

    override fun getDetail(username: String): Flow<UiState<DetailModel>> =
        remoteDataSource
            .getData<DetailResponse>(Url.DETAIL_USER.replace("username", username))
            .mapState { detailResponse ->
                detailResponse.mapToDetailModel()
            }

    override fun getFollows(username: String, type: String): Flow<PagingData<FollowItemModel>> =
        Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10,
            ),
            pagingSourceFactory = {
                followPagingSource.apply {
                    setData(username = username, type = type)
                }
            },
        ).flow.map { pagingData ->
            pagingData.map { data ->
                data.mapToFollowItemModel()
            }
        }

    override fun getRepositories(username: String): Flow<PagingData<RepositoryItemModel>> =
        Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10,
            ),
            pagingSourceFactory = {
                repositoryPagingSource.apply {
                    setUsername(username = username)
                }
            },
        ).flow.map { pagingData ->
            pagingData.map { data ->
                val random = Random.Default
                val color = Color(
                    random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256),
                    255
                )
                data.mapToRepositoryItemModel(color)
            }
        }
}