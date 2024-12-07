package com.wang.domain.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import com.wang.domain.SysUser;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {

    //权限列表
    private List<String> list;
    private SysUser sysUser;
    private Long id;

    //自定义权限列表
    @JSONField(serialize = false)
    List<SimpleGrantedAuthority> authorities;

    public LoginUser(SysUser sysUser, List<String> perms) {
        this.list = perms;
        this.sysUser = sysUser;
    }

    public Long getId() {
        return sysUser.getId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (!CollectionUtils.isEmpty(authorities)) {
            return authorities;
        }
        authorities = new ArrayList<>();
        list.forEach(perms -> {
            authorities.add(new SimpleGrantedAuthority(perms));
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUserName();
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
}
