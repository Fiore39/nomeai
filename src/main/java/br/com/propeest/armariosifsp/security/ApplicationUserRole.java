package br.com.propeest.armariosifsp.security;

import com.google.common.collect.Sets;

import java.util.Set;

public enum ApplicationUserRole {
    ALUNO(Sets.newHashSet()),
    ADMIN(Sets.newHashSet());

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }
}
