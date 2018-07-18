package blog.repositories;


import blog.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    @Query("SELECT u.role from User u where u.username=?1")
    List<String> findRoleByUserName(String username);
}
