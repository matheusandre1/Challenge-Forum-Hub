package com.Challenge_Forum_Hub.domain.models;

import com.Challenge_Forum_Hub.api.models.UserDto;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity(name = "users")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    @Id
    private UUID id;
    private String name;
    private String email;
    private String password;

    public User(@NotNull UUID uuid) {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
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

    public User(UserDto userDto) {
        this.id = UUID.randomUUID();
        this.name = userDto.name();
        this.email = userDto.email();
        this.password = userDto.password();
    }

    public void edit(UserDto userDto) {
        this.setName(userDto.name());
        this.setEmail(email = userDto.email());
        if (userDto.password() != null && !userDto.password().isBlank()) {
            this.password = userDto.password();
        }
    }


}
