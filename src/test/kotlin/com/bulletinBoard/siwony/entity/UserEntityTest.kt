package com.bulletinBoard.siwony.entity

import com.bulletinBoard.siwony.repository.UserRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
internal class UserEntityTest{

    @Autowired lateinit var userRepository: UserRepository

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
        assertTrue(accountNonExpired)
        assertTrue(accountNonLocked)
        assertTrue(credentialsNonExpired)
        assertTrue(enabled)
    }

    @Test @DisplayName("UserEntity 저장 테스트")
    fun UserEntity_save_테스트(){
        val email = "siwon103305@gmail.com"
        val password = "password"
        val nickname = "siwony_"

        val userEntity = UserEntity(email, password, nickname)
        val save = userRepository.save(userEntity);

        assertEquals(save.username, email);
        assertEquals(save.password, password)
        assertEquals(save.nickname, nickname)
    }

}