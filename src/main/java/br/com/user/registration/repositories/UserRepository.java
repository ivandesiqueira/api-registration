package br.com.user.registration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.user.registration.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
