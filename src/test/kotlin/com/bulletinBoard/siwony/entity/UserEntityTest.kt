package com.bulletinBoard.siwony.entity

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

internal class UserEntityTest{

    @Test @DisplayName("Entity 테스트")
    fun UserEntit_테스트(){
        // Given
        val EMAIL = "siwon103305@gmail.com"; val PWD = "siwony1234"; val NICKNAME = "siwony"
        val userEntity : UserEntity = UserEntity(EMAIL, PWD, NICKNAME)

        // When
        val getAuthority: String = userEntity.authorities.toList()[0].authority
        val password: String = userEntity.password
        val accountNonExpired: Boolean = userEntity.isAccountNonExpired
        val accountNonLocked: Boolean = userEntity.isAccountNonLocked
        val credentialsNonExpired: Boolean = userEntity.isCredentialsNonExpired
        val enabled: Boolean = userEntity.isEnabled

        // Then
        assertEquals(Role.ROLE_CLIENT.name, getAuthority)
        assertEquals(PWD, password)
        assertEquals(true, accountNonExpired)
        assertEquals(true, accountNonLocked)
        assertEquals(true, credentialsNonExpired)
        assertEquals(true, enabled)
    }

}