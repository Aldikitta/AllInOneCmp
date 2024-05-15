package com.aldikitta.core.data.di

import com.aldikitta.core.data.source.remote.paging.FollowsPagingSource
import com.aldikitta.core.data.source.remote.paging.RepositoriesPagingSource
import com.aldikitta.core.data.source.remote.paging.UsersPagingSource
import org.koin.dsl.module

val pagingModule = module {
    factory { UsersPagingSource(get()) }
    factory { RepositoriesPagingSource(get()) }
    factory { FollowsPagingSource(get()) }
}