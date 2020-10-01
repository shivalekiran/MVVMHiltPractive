package com.fideltech.mvvmhiltpractive.di

import com.fideltech.mvvmhiltpractive.model.Blog
import com.fideltech.mvvmhiltpractive.retrofit.BlogNetworkEntity
import com.fideltech.mvvmhiltpractive.retrofit.BlogRetrofit
import com.fideltech.mvvmhiltpractive.retrofit.NetworkMapper
import com.fideltech.mvvmhiltpractive.util.EntityMapper
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
    fun providGson(): Gson {
        return GsonBuilder()
            .create()
    }
    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson):Retrofit.Builder{
        return Retrofit.Builder().
                baseUrl("https://open-api.xyz/placeholder/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }
    @Singleton
    @Provides
    fun providesBlogService(retrofit: Retrofit.Builder):BlogRetrofit{
        return retrofit
            .build()
            .create(BlogRetrofit::class.java)
    }
}