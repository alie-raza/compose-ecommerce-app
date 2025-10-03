package com.alidev.ecommerceapplication.di

import com.alidev.ecommerceapplication.data.Repository
import com.alidev.ecommerceapplication.domain.UseCases
import com.alidev.ecommerceapplication.domain.saveUserUseCase.SaveUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {



    @Provides
    @Singleton
    fun provideUseCase(repository: Repository): UseCases {
        return UseCases(
            saveUser = SaveUserUseCase(repository)

        )
    }

}