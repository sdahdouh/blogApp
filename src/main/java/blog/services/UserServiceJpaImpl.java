package blog.services;


import blog.models.User;
import blog.models.UserRole;
import blog.repositories.UserRepository;
import blog.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UserServiceJpaImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserRoleRepository userRoleRepo;

    @Override
    public List<User> findAll() {
        return this.userRepo.findAll();
    }

    @Override
    public List<User> findMostActive() {
        return null;
    }


    @Override
    public User findById(Long id) {
        return this.userRepo.findOne(id);
    }

    @Override
    public User create(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public User edit(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public void deleteById(Long id) {
        this.userRepo.delete(id);
    }

    @Override
    public Long increaseActivityPoints() {
        User user = findActiveUser();
        Long currentActivityPoints = user.getActivityPoints();
        user.setActivityPoints(50L + currentActivityPoints);
        return user.getActivityPoints();
    }

    @Override
    public User findActiveUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User activeUser = userRepo.findByUsername(name);
        return activeUser;
    }
}
