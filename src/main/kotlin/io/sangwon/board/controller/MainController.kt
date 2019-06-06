package io.sangwon.board.controller

import io.sangwon.board.form.RegisterForm
import io.sangwon.board.model.UserInfo
import io.sangwon.board.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import javax.validation.Valid

/**
 * Created by Sangwon Hyun on 2019-05-27.
 * bizblocks.io
 */
@Controller
@RequestMapping("/user")
class MainController(val userService: UserService){

    @GetMapping("/list")
    fun showLogin(): ModelAndView {

        val userInfo:List<UserInfo>? = userService.userFindAll()
        var userInfoLength = 0
        if(userInfo !== null){
            userInfoLength = userInfo.size
        }

        return ModelAndView("main").apply {
            addObject("userInfoLength",userInfoLength)
            addObject("userInfo",userInfo)
        }
    }

    @GetMapping("/edit/{userNo}")
    fun showEdit(@PathVariable("userNo") userNo : Int,
                 @ModelAttribute("formVO") formVO : RegisterForm): ModelAndView{
        val userInfo: UserInfo = userService.userFindOne(userNo)

        return ModelAndView("edit").apply {
            addObject("user",userInfo)
            addObject("formVO",formVO)
        }
    }

    @PostMapping("/edit")
    fun doEdit(@ModelAttribute("formVO") formVO : RegisterForm) : ModelAndView{

        userService.userUpdate(formVO.id.toInt(),formVO.name)

        return ModelAndView("redirect:/user/list")
    }

}