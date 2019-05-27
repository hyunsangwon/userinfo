package io.sangwon.board.model

import javax.persistence.Entity

@Entity
class UserInfo : BaseEntity() {

    var email: String? = null
    var password: String? = null
    var name: String? = null
}