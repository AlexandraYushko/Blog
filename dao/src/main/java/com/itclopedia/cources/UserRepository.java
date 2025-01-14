package com.itclopedia.cources;

import com.itclopedia.cources.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
