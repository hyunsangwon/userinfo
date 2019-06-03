package io.sangwon.board.model

import javax.persistence.Entity

/**
 * Created by Sangwon Hyun on 2019-06-03.
 * bizblocks.io
 */
@Entity
class AccessInfo : BaseEntity(){

    var userId: Int? = null
}