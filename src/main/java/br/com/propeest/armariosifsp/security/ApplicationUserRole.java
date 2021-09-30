package br.com.propeest.armariosifsp.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static br.com.propeest.armariosifsp.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    ALUNO(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(ARMARIO_READ, ARMARIO_WRITE,
                          BLOCO_READ, BLOCO_WRITE,
                          LOCAL_READ, LOCAL_WRITE,
                          CONTRATO_READ, CONTRATO_WRITE,
                          ALUNO_READ, ALUNO_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
