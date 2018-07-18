package blog.services;


import blog.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> findAll();
    List<User> findMostActive();
    User findById(Long id);
    User create(User user);
    User edit(User user);
    void deleteById(Long id);
    Long increaseActivityPoints();
    User findActiveUser();

}
