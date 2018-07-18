/*
package blog.services;

import blog.models.User;
import blog.models.UserRole;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceStubImpl implements UserService{

    private List<User> users = new ArrayList<User>(){{
        add(new User(1L,"sweetPumpkin123","Marina Turner",10L,new UserRole("USER")));
        add(new User(2L,"babylon5","Marco Martinez",10L,new UserRole("USER")));
        add(new User(3L,"sweetheart96","Tina Markow", 10L,new UserRole("USER")));
        add(new User(4L,"bunny96","Hannah Bellot",10L,new UserRole("USER")));
        add(new User(5L,"theProcoder","Mattis Lyod", 10L,new UserRole("USER")));
    }};

    @Override
    public List<User> findAll(){
        return this.users;
    }

    @Override
    public List<User> findMostActive(){
        return this.users.stream().sorted((a, b) -> b.getActivityPoints().compareTo(a.getActivityPoints())).limit(10).collect(Collectors.toList());
    }

    @Override
    public User findById(Long id){
        return this.users.stream().filter(p -> Objects.equals(p.getId(),id)).findFirst().orElse(null);
    }

    @Override
    public User create(User user){
        user.setId(this.users.stream().mapToLong(p -> p.getId()).max().getAsLong()+1);
        this.users.add(user);
        return user;
    }

    @Override
    public User edit(User user){
        for(int i = 0; i < this.users.size(); i++) {
            if(Objects.equals(this.users.get(i).getId(), user.getId())){
                this.users.set(i, user);
                return user;
            }
        }
        throw new RuntimeException("post not found: " + user.getId());
    }

    @Override
    public void deleteById(Long id){
        for(int i = 0; i < this.users.size(); i++) {
            if(Objects.equals(this.users.get(i).getId(), id)){
                this.users.remove(i);
                return;
            }
        }
        throw new RuntimeException("user not found: " + id);
    }

}
*/
