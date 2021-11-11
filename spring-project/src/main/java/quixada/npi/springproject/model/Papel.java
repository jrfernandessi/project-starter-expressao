package quixada.npi.springproject.model;

import org.springframework.security.core.GrantedAuthority;

public enum Papel implements GrantedAuthority {
    ESTUDANTE("Estudante"), COORDENADOR("Coordenador"), ADMIN("Administrador");

    private String nome;

    Papel(String nome){this.nome = nome;}

    public String getNome() {return this.nome;};

    @Override
    public String getAuthority() {
        return this.toString();
    }


}
