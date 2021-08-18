package com.yuresko.evachallenge.di

import android.app.Application
import androidx.room.Room

import com.yuresko.evachallenge.data.local.DaoRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object DataModule {
//
//    @Provides
//    @Singleton
//    fun provideAppDatabase(application: Application): AppDatabase {
//        return Room.databaseBuilder(
//            application,
//            AppDatabase::class.java,
//            "database"
//        )
//            .fallbackToDestructiveMigration()
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideDaoRepo(appDatabase: AppDatabase): DaoRepo {
//        return appDatabase.repo()
//    }
//}