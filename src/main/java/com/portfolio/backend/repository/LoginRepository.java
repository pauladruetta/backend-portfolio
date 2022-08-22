
package com.portfolio.backend.repository;

import com.portfolio.backend.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginRepository extends JpaRepository <Login,Long> {

}
