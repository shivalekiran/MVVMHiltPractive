package com.fideltech.mvvmhiltpractive.repository

import android.service.autofill.Dataset
import com.fideltech.mvvmhiltpractive.model.Blog
import com.fideltech.mvvmhiltpractive.retrofit.BlogRetrofit
import com.fideltech.mvvmhiltpractive.retrofit.NetworkMapper
import com.fideltech.mvvmhiltpractive.room.BlogDao
import com.fideltech.mvvmhiltpractive.room.CacheMapper
import com.fideltech.mvvmhiltpractive.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class MainRepository
constructor(
    private val blogDao: BlogDao,
    private val blogRetrofit: BlogRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {

    suspend fun getBlog(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        delay(1000)//to see progress bar
        try {
            val networkBlogs = blogRetrofit.getBlog()
            val  blogs = networkMapper.mapFromEntityList(networkBlogs)
            blogs.forEach {
                blogDao.insert(cacheMapper.mapToEntity(it))
            }
            val cachedBlogs = blogDao.getBlogs()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogs)))
        } catch (r: Exception) {
            DataState.Error(exception = r)
        }

    }
}