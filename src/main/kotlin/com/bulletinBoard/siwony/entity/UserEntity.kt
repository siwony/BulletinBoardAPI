package com.bulletinBoard.siwony.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

@Entity @Table(name = "USER")
class UserEntity(email: String, password: String, nickname: String, role: Role = Role.ROLE_ADMIN) : UserDetails{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_IDX")
    val userIdx : Long? = null

    @Column(name = "email", nullable = false)
    var email : String = email

    @Column(name = "PASSWORD", nullable = false)
    private var password : String? = password

    @Column(name = "NICKNAME", nullable = false)
    var nickname : String? = nickname

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "ROLE") @CollectionTable(name = "ROLE")
    var roles : MutableList<Role> = mutableListOf(role)

    /**
     * Returns the authorities granted to the user. Cannot return `null`.
     * @return the authorities, sorted by natural key (never `null`)
     */
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        var rolesConvertString : MutableList<String> = this.roles.map { role -> role.name } as MutableList<String>
        return rolesConvertString.map { it } as MutableCollection<out GrantedAuthority>;
    }

    override fun getPassword(): String? = this.password;

    override fun getUsername(): String? = this.username

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}