package io.sangwon.board.model

import javax.persistence.*

@Entity
class UserInfo : BaseEntity() {

    var email: String? = null
    var password: String? = null
    var name: String? = null

    /*
    * @OneToMany는 이 클래스를 기준으로 1:N 관계를 의미.
    * FetchType.LAZY는 UserInfo 조회시 관계 매핑된 AccessInfo를 같이 조회 안하고
    * 필요할때만 그때 호출하겠다 라는 의미 반대로 UserInfo 조회시 AccessInfo에 참조된 데이터까지 한번에 로딩하고 싶다면,
    * FetchType.EAGER를 사용하면 된다.
    *
    * @JoinColumn은 FK가 될 컬럼을 지정 accessInfo 테이블에서
    * */
    @OneToMany(fetch = FetchType.LAZY,cascade = [CascadeType.ALL])
    @JoinColumn(name="userId")
    var accessInfo:List<AccessInfo>? = null
}