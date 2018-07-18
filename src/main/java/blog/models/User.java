package blog.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 30, unique = true)
    private String username;

    @Column(length= 60)
    private String password;

    @Column(length = 100)
    private String fullName;

    @Column(length = 100)
    private Long activityPoints;

    @ManyToOne(targetEntity = UserRole.class)
    @JoinColumn(name = "user_role_id")
    private UserRole role;

    /*@ManyToOne(optional = false, fetch = FetchType.LAZY)

    */

    @OneToMany(mappedBy = "author")
    private Set<Post> posts = new HashSet<>();


    public User() {}
    public User(User user) {
        this.userId = user.userId;
        this.username = user.username;
        this.password = user.password;
        this.fullName = user.fullName;
        this.activityPoints= user.activityPoints;
        this.role= user.role;

    }

    public User(String username, String password, String fullName, Long activityPoints, UserRole role) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.activityPoints = activityPoints;
        this.role = role;
    }


    public Long getId() {

        return userId;
    }

    public void setId(Long userId) {

        this.userId = userId;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {

        this.fullName = fullName;
    }

    public Long getActivityPoints() {
        return activityPoints;
    }

    public void setActivityPoints(Long activityPoints) {
        this.activityPoints = activityPoints;
    }

    public Set<Post> getPosts() {

        return posts;
    }

    public void setPosts(Set<Post> posts) {

        this.posts = posts;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", activityPoints=" + activityPoints +
                '}';
    }


}
