package io.sangwon.board

import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

/**
 * Created by Sangwon Hyun on 2019-05-17
 * blizbloks.io
 */

class ServletInitializer: SpringBootServletInitializer(){
    /*
    *
    * 톰캣을 배포하고 실행되어야 하므로 SpringBootServletInitializer class 상속*/

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(BoardApplication::class.java)
    }
}