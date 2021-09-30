package br.com.propeest.armariosifsp.security;

public enum ApplicationUserPermission {
    ALUNO_READ("aluno:read"),
    ALUNO_WRITE("aluno:write"),
    ARMARIO_READ("armario:read"),
    ARMARIO_WRITE("armario:write"),
    CONTRATO_READ("contrato:read"),
    CONTRATO_WRITE("contrato:write"),
    BLOCO_READ("bloco:read"),
    BLOCO_WRITE("bloco:write"),
    LOCAL_READ("local:read"),
    LOCAL_WRITE("local:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
