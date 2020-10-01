package com.fideltech.mvvmhiltpractive.room

import com.fideltech.mvvmhiltpractive.model.Blog
import com.fideltech.mvvmhiltpractive.retrofit.BlogNetworkEntity
import com.fideltech.mvvmhiltpractive.util.EntityMapper
import javax.inject.Inject

class CacheMapper @Inject constructor() : EntityMapper<BlogCacheEntity, Blog> {
    override fun mapToEntity(domainModel: Blog): BlogCacheEntity {
        return BlogCacheEntity(
            id = domainModel.id,
            title = domainModel.title,
            body = domainModel.body,
            image = domainModel.image,
            category = domainModel.category
        )
    }

    override fun mapFromEntity(entity: BlogCacheEntity): Blog {
        return Blog(
            id = entity.id,
            title = entity.title,
            body = entity.body,
            image = entity.image,
            category = entity.category
        )
    }

    fun mapFromEntityList(entity: List<BlogCacheEntity>): List<Blog> {
        return entity.map {
            mapFromEntity(it)
        }
    }
}