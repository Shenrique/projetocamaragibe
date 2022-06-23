package projetocriadouro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long codigo;


    @Column(name = "nome", unique = true, nullable = false)
    private String nome;

    @JsonIgnore
    @Column(name = "senha", nullable = false)
    private String senha;

    @ManyToMany
    @JoinTable(
            name = "usuarios_tem_perfis",
            joinColumns = {@JoinColumn(name = "usuario_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "perfil_id", referencedColumnName = "id")}
    )

    private List<Perfil> perfis;

    @Column(name = "ativo", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean ativo;

    @Column(name = "codigo_verificador", length = 6)
    private String codigoVerificador;

    public Usuario() {
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    // adiciona perfis a lista
    public void addPerfil(PerfilTipo tipo) {
        if (this.perfis == null) {
            this.perfis = new ArrayList<>();
        }
        this.perfis.add(new Perfil(tipo.getCod()));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getCodigoVerificador() {
        return codigoVerificador;
    }

    public void setCodigoVerificador(String codigoVerificador) {
        this.codigoVerificador = codigoVerificador;
    }

}