package com.cdg.base.security;

import com.cdg.base.domain.Member;
import com.cdg.base.domain.MemberRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CustomSecurityUser extends User {

    private static final String ROLE_PREFIX = "ROLE_";

    private Member member;

    public CustomSecurityUser(Member member){
        super(member.getUid(), "{noop}" + member.getUpw(), makeGrantedAuthority(member.getRoles()));

        this.member = member;
    }

    private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles){

        List<GrantedAuthority> list = new ArrayList<>();

        roles.forEach(role -> list.add(
                new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName())
        ));

        return list;

    }
}
