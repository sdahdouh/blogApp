package blog.services;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import blog.models.User;
import blog.models.UserRole;
import blog.repositories.UserRepository;
import blog.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository,UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository=userRoleRepository;
    }

    @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepository.findByUsername(username);

        if(null == user){
            throw new UsernameNotFoundException("No user present with username: "+username);
        }else{
            List<String> userRole =userRoleRepository.findRoleByUserName(username);
            return new CustomUserDetails(user,userRole);
        }
    }
}