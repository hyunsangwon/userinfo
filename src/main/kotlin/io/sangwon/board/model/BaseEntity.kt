package io.sangwon.board.model

import java.time.ZonedDateTime
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

/*자주 사용되는 컬럼은 부모클래스로 모듈화 하자*/
@MappedSuperclass
open class BaseEntity{

    /*GenerationType.IDENTITY 은 기본키 생성을 데이터베이스에 위임하는 방법(MySQL 에서 많이 쓰인다)*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?=null

    var createdAt: ZonedDateTime = ZonedDateTime.now()

}