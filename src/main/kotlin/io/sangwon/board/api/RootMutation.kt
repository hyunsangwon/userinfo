package io.sangwon.board.api

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import io.sangwon.board.model.UserInfo
import io.sangwon.board.repository.UserRespository
import org.springframework.stereotype.Component

/**
 * Created by Sangwon Hyun on 2019-05-29.
 * bizblocks.io
 */
@Component
class RootMutation(val userRespository: UserRespository) : GraphQLMutationResolver {
    /*schema 안에 정의된 메소드랑 이름이 같아야함 */
    fun createUser(email:String,name:String,password:String):UserInfo= UserInfo()

}