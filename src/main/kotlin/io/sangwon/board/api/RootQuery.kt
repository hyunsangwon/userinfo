package io.sangwon.board.api

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import io.sangwon.board.model.UserInfo
import io.sangwon.board.service.UserService
import org.springframework.stereotype.Component

/**
 * Created by Sangwon Hyun on 2019-05-29.
 * bizblocks.io
 */
@Component
class RootQuery(val userService: UserService) : GraphQLQueryResolver {
    /*schema 안에 정의된 메소드랑 이름이 같아야함 */
    fun getUser(email:String):UserInfo? = userService.getUserByEmail(email)
}