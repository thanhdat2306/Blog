package com.example.demo.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@NoArgsConstructor
@Getter
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname", unique = true)
    private String nickname;

    @Builder
    public User(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    public User update(String nickname) {
        this.nickname = nickname;
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    // Trả về tài khoản đã hết hạn
    @Override
    public boolean isAccountNonExpired() {
        // Logic để kiểm tra xem nó đã hết hạn chưa
        return true; //đúng -> không bao giờ hết hạn
    }

    // Trả về tài khoản có bị khóa hay không
    @Override
    public boolean isAccountNonLocked() {
        // Logic để kiểm tra xem nó có bị khóa không
        return true; // đúng -> không bị khóa
    }

    // Trả về xem mật khẩu đã hết hạn chưa
    @Override
    public boolean isCredentialsNonExpired() {
        // Logic để kiểm tra xem nó đã hết hạn chưa
        return true; // đúng -> không bao giờ hết hạn
    }

    // Trả về tính khả dụng của tài khoản
    @Override
    public boolean isEnabled() {
        // Logic để kiểm tra nếu có
        return true; // đúng -> có sẵn
    }
}
