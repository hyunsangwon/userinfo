package io.sangwon.board.repository

import io.sangwon.board.model.UserInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by Sangwon Hyun on 2019-05-20.
 * bizblocks.io
 */

@Repository
interface UserRespository : JpaRepository<UserInfo,Int>{

    /*row가 0일 수도 있으니 null허용인 ?도 해주자.*/
    fun findByEmail(email:String):UserInfo?

}