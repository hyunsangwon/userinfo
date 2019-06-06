package io.sangwon.board.form

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.Email
import javax.validation.constraints.Size

/**
 * Created by Sangwon Hyun on 2019-05-17
 * blizbloks.io
 */

class RegisterForm{

    @NotNull
    @Email(regexp = "^(.+)@(.+)$",message = "Invalid email pattern")
    var email:String =""

    @Size(min=6,max=10, message = "length should be in between 6 to 10!")
    var password: String =""

    @Size(min=6,max=10, message = "length should be in between 6 to 10!")
    var confirmPassword: String =""

    var name: String=""

    var userId: String=""
}
