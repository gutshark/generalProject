package com.pusong.datasource.repository.secondary;

import com.pusong.datasource.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
