package io.sangwon.board.controller

import io.sangwon.board.form.LoginForm
import io.sangwon.board.form.RegisterForm
import io.sangwon.board.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView
import javax.validation.Valid

/**
 * Created by Sangwon Hyun on 2019-05-17
 * blizbloks.io
 */

@Controller
class LoginController(val userService:UserService){

    @GetMapping("/")
    fun showLogin(@ModelAttribute("loginVO") loginVO :LoginForm): ModelAndView {
        return ModelAndView("login").apply {
            addObject("loginVO",loginVO)
        }
    }

    @PostMapping("/login")
    fun doLogin(@Valid @ModelAttribute("loginVO") loginVO : LoginForm, br: BindingResult): ModelAndView {

        if(br.hasErrors()){
            return ModelAndView("login")
        }

        val userInfo = userService.getUserByEmail(loginVO.email)

        if(userInfo === null){
            br.rejectValue("email","loginVO.email","Incorrect email address")
        }else{
            if(!userInfo!!.password.equals(loginVO.password)){
                br.rejectValue("password","loginVO.password","Incorrect password")
            }
        }

        if(br.hasErrors()){
            return ModelAndView("login")
        }

        return ModelAndView("redirect:/user/list")
    }

    @GetMapping("/join")
    fun showJoin(@ModelAttribute("formVO") formVO :RegisterForm): ModelAndView {
        return ModelAndView("join").apply {
            addObject("formVO",formVO)
        }
    }

    /*@Valid 태그로 검사후 BindingResult로 넘긴다.
    * errors(html 에서)는 BindingResult에 있는 에러값을 출력해준다.
    * BindingResult.hasErrors : 에러가 있는지 검사한다.
    * */
    @PostMapping("/join")
    fun doJoin(@Valid @ModelAttribute("formVO") formVO : RegisterForm,
               br: BindingResult): ModelAndView{
        /* 이메일하고 비밀번호를 넘겨받음
        * 1. 이미 가입된 이메일인 확인
        * 2. 비밀번호가 서로 맞는지 확인 (html안에서도 체킹)
        * 3. BindingResult로 @Valid 에러 확인
        * 4. 1~3번 이상없을시 회원가입 완료
        * */
        if(br.hasErrors()){ //기본 체킹은 앞에서 미리 걸러준다. DB I/O 접근 최소
            return ModelAndView("join")
        }

        val userInfo = userService.getUserByEmail(formVO.email)

        /*errorCode 매핑할 필드(html), defaultMessage @Vaild message 말고 다른값으로 변경시킬때*/
        if(userInfo !== null){
            br.rejectValue("email","formVO.email","This email is already signed up")
        }

        /*입력한 비밀번호가 같은지 체크는 서버단에서도 가능 하다~*/
        if(!formVO.password.equals(formVO.confirmPassword)){
            br.rejectValue("confirmPassword","formVO.confirmPassword'","password do not match")
        }

        if(br.hasErrors()){
            return ModelAndView("join")
        }

        userService.signUp(formVO)
        return ModelAndView("success")
    }
}