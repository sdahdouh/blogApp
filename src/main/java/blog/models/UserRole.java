package blog.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_role_id")
    private Long userRoleId;

    @Column(name="roleName")
    private String roleName;

//    @OneToMany(mappedBy = "role")
//    private Set<User> users;

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }


    public String getRole() {
        return roleName;
    }

    public void setRole(String roleName) {
        this.roleName = roleName;
    }

//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }

    public UserRole() { }
    public UserRole(String roleName, Long userRoleId) {
        this.roleName = roleName;
        this.userRoleId = userRoleId;
    }
}
