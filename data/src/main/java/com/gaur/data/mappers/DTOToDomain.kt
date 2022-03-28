package com.gaur.data.mappers

import com.gaur.data.network.models.OwnerDTO
import com.gaur.data.network.models.PostDTO
import com.gaur.data.network.models.PostsDTO
import com.gaur.domain.model.Owner
import com.gaur.domain.model.Post


fun OwnerDTO.toDomainOwner():Owner{
    return Owner(
        firstName = firstName?:"",
        id=id?:"",
        lastName = lastName?:"",
        picture = picture?:"",
        title = title?:""
    )
}


fun List<PostDTO>.toDomainPost(): List<Post> {
   return map {
        Post(
            id = it.id?:"",
            image = it.image?:"",
            likes=it.likes?:0,
            owner=it.owner?.toDomainOwner()?:Owner(),
            publishDate = it.publishDate?:"",
            tags = it.tags?: emptyList(),
            text = it.text?:""
        )
    }
}

fun PostDTO.toDomain(): Post{
    return Post(
        id= this.id?:"",
        image = this.image?:"",
        likes = this.likes?:0,
        owner=this.owner?.toDomainOwner()?:Owner(),
        publishDate=this.publishDate?:"",
        tags= this.tags?: emptyList(),
        text= this.text?:""
    )
}


fun  PostsDTO.toDomainPosts():List<Post>{
    return this.data?.toDomainPost() ?: emptyList<Post>()
}