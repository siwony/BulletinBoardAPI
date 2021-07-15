package com.bulletinBoard.siwony.repository

import com.bulletinBoard.siwony.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long>{}