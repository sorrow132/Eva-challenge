package com.yuresko.evachallenge.di

import com.yuresko.evachallenge.data.remote.OMDbService
import com.yuresko.evachallenge.data.Repository
import com.yuresko.evachallenge.data.RepositoryImpl
import com.yuresko.evachallenge.utils.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideRepositoryRepo(
        service: OMDbService,
        dispatcherProvider: DispatcherProvider
    ): Repository {
        return RepositoryImpl(service, dispatcherProvider)
    }

    @Provides
    @ViewModelScoped
    fun provideDispatchers(): DispatcherProvider = object : DispatcherProvider {
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }
}