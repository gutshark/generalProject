package com.pusong.study.securityProject.repository;

import com.pusong.study.securityProject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByLoginName(String loginName);
}
