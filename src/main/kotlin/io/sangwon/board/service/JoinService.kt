package io.sangwon.board.service


import io.sangwon.board.form.RegisterForm
import io.sangwon.board.model.UserInfo
import io.sangwon.board.repository.UserRespository
import org.springframework.stereotype.Service

/**
 * Created by Sangwon Hyun on 2019-05-17
 * blizbloks.io
 */

@Service
class UserService(val userRespository: UserRespository){


    fun signUp(form : RegisterForm):UserInfo{
        val user = UserInfo().apply{
            email = form.email
            name = form.name
            password = form.confirmPassword
        }
        return userRespository.save(user)
}

    fun getUserByEmail(email:String):UserInfo?{
        return userRespository.findByEmail(email)
    }


    fun userFindAll():List<UserInfo>?{
        return userRespository.findAll()
    }

}