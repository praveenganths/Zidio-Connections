package repository;

import entity.AdminUser;
import Enum.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
    AdminUser findByEmail(String email);
    List<AdminUser> findByRole(Role role);

}
