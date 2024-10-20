package com.jamie.newsapp.domain.usecases

import com.jamie.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val localUserManager: LocalUserManager) {
    operator fun invoke(): Flow<Boolean>{
        return localUserManager.readAppEntry()
    }
}