package blog.services;

import blog.models.User;
import blog.models.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


public class CustomUserDetails extends blog.models.User implements UserDetails {

    private static final long serialVersionUID = 1L;
    private List<String> userRole;


    public CustomUserDetails(User user,List<String> userRole){
    super(user);
    this.userRole = userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    String role=StringUtils.collectionToCommaDelimitedString(userRole);
    return AuthorityUtils.commaSeparatedStringToAuthorityList(role);
    }

    @Override
    public boolean isAccountNonExpired() {
    return true;
    }

    @Override
    public boolean isAccountNonLocked() {
    return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
    return true;
    }
    @Override
    public boolean isEnabled() {
    return true;
    }

    @Override
        public String getUsername() {
        return super.getUsername();
    }
    @Override
    public String getPassword() {
        return super.getPassword();
    }

}