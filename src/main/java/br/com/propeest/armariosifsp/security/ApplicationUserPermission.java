package br.com.propeest.armariosifsp.security;

public enum ApplicationUserPermission {
    ALUNO_READ("aluno:read"),
    ALUNO_WRITE("aluno:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
