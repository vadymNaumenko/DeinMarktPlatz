package de.deinmarktplatz.repository;

import de.deinmarktplatz.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
  User findByEmail(String email);
}
