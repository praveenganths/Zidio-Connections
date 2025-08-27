package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.User;

public interface UserRepository extends JpaRepository {
    Optional<User>findByEmail(String email);

}
