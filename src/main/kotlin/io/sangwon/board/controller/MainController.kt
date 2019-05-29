package io.sangwon.board.controller

import io.sangwon.board.model.UserInfo
import io.sangwon.board.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

/**
 * Created by Sangwon Hyun on 2019-05-27.
 * bizblocks.io
 */
@Controller
@RequestMapping("/user")
class MainController(val userService: UserService) {

    @GetMapping("/list")
    fun showLogin(): ModelAndView {

        val userInfo:List<UserInfo>? = userService.userFindAll()
        var userInfoLength = 0;
        if(userInfo !== null){
            userInfoLength = userInfo.size
        }

        return ModelAndView("main").apply {
            addObject("userInfoLength",userInfoLength)
            addObject("userInfo",userInfo)
        }
    }

    @GetMapping("/edit/{userNo}")
    fun showEdit(@PathVariable("userNo") userNo : Int): ModelAndView{
        /*
        * userNo
        * */


        return ModelAndView("edit").apply {
            addObject("userNo",userNo)
        }
    }

}