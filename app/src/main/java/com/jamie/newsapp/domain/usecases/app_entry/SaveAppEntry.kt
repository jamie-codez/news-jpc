package com.jamie.newsapp.domain.usecases.app_entry

import com.jamie.newsapp.domain.manager.LocalUserManager

class SaveAppEntry(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}