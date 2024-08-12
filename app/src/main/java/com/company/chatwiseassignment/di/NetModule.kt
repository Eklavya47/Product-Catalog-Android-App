package com.company.chatwiseassignment.di

import com.company.chatwiseassignment.Constants
import com.company.chatwiseassignment.data.api.ProductApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.URL).build()

    @Singleton
    @Provides
    fun provideProductApiClient(retrofit: Retrofit): ProductApiClient =
        retrofit.create(ProductApiClient::class.java)
}