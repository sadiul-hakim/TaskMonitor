package xyz.sadiulhakim.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xyz.sadiulhakim.role.Role;

import java.util.Optional;

interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    long countByRole(Role role);

    Page<User> findByNameContainingOrEmailContaining(String name, String email, Pageable page);

    @Query(value = "select count(*) from User")
    long numberOfUsers();
}
