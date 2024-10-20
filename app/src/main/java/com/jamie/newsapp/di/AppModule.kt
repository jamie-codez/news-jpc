package com.jamie.newsapp.di

import android.app.Application
import com.jamie.newsapp.data.manager.LocalUserMangerImpl
import com.jamie.newsapp.domain.manager.LocalUserManager
import com.jamie.newsapp.domain.usecases.AppEntryUseCases
import com.jamie.newsapp.domain.usecases.ReadAppEntry
import com.jamie.newsapp.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager = LocalUserMangerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManager: LocalUserManager) =
        AppEntryUseCases(saveAppEntry = SaveAppEntry(localUserManager), readAppEntry = ReadAppEntry(localUserManager))
}