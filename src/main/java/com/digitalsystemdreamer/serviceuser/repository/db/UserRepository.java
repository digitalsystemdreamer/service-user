package com.digitalsystemdreamer.serviceuser.repository.db;

import com.digitalsystemdreamer.serviceuser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
