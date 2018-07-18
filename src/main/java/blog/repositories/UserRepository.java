package blog.repositories;

import blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//This repository does not need any manual implementation. Spring Data JPA implements it for me.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);


}
