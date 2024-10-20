package com.jamie.newsapp.di

import android.app.Application
import com.jamie.newsapp.data.manager.LocalUserMangerImpl
import com.jamie.newsapp.data.remote.NewsApi
import com.jamie.newsapp.data.repository.NewsRepositoryImpl
import com.jamie.newsapp.domain.manager.LocalUserManager
import com.jamie.newsapp.domain.repository.NewsRepository
import com.jamie.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.jamie.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.jamie.newsapp.domain.usecases.app_entry.SaveAppEntry
import com.jamie.newsapp.domain.usecases.news.GetNews
import com.jamie.newsapp.domain.usecases.news.NewsUseCases
import com.jamie.newsapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create<NewsApi>(NewsApi::class.java)

    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: NewsApi): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(newsRepository: NewsRepository) = NewsUseCases(getNews= GetNews(newsRepository))
}