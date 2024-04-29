package com.example.javajwtdemo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.javajwtdemo.enums.Permission.*;

@RequiredArgsConstructor
public enum Role {

    // You can change role to fit with your project
    GUEST(Collections.emptySet()),
    STAFF(
            Set.of(
                    STAFF_CREATE,
                    STAFF_READ,
                    STAFF_UPDATE,
                    STAFF_DELETE
            )),
    CUSTOMER(
            Set.of(
                    CUSTOMER_CREATE,
                    CUSTOMER_READ,
                    CUSTOMER_UPDATE,
                    CUSTOMER_DELETE
            )),
    ADMIN(
            Set.of(
                    ADMIN_CREATE,
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,

                    STAFF_CREATE,
                    STAFF_READ,
                    STAFF_UPDATE,
                    STAFF_DELETE
            ))


    ;
    @Getter
    private final Set<Permission> permissions;
    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities =
                getPermissions().stream()
                        .map(permission1 -> new SimpleGrantedAuthority(permission1.getPermission()))
                        .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return authorities;
    }

}
