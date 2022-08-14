package projetocriadouro.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "passaro")
public class Passaro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    private String nome;

    @NotNull
    private String sexo;

    @NotNull
    private String venda;

    @NotNull
    private String ocultar;

    @Column(name = "status_reproducao")
    @Enumerated(EnumType.STRING)
    private StatusReproducao status_reproducao;

    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_nascimento;

    private String anilha;

    private String macho1;
    private String femea1;

    private String macho21;
    private String femea21;

    private String macho22;
    private String femea22;

    private String macho31;
    private String femea31;
    private String macho32;
    private String femea32;
    private String macho33;
    private String femea33;
    private String macho34;
    private String femea34;

    private String macho41;
    private String femea41;
    private String macho42;
    private String femea42;
    private String macho43;
    private String femea43;
    private String macho44;
    private String femea44;
    private String macho45;
    private String femea45;
    private String macho46;
    private String femea46;
    private String macho47;
    private String femea47;
    private String macho48;
    private String femea48;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public StatusReproducao getStatus_reproducao() {
        return status_reproducao;
    }

    public void setStatus_reproducao(StatusReproducao status_reproducao) {
        this.status_reproducao = status_reproducao;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getMacho1() {
        return macho1;
    }

    public void setMacho1(String macho1) {
        this.macho1 = macho1;
    }

    public String getFemea1() {
        return femea1;
    }

    public void setFemea1(String femea1) {
        this.femea1 = femea1;
    }

    public String getMacho21() {
        return macho21;
    }

    public void setMacho21(String macho21) {
        this.macho21 = macho21;
    }

    public String getFemea21() {
        return femea21;
    }

    public void setFemea21(String femea21) {
        this.femea21 = femea21;
    }

    public String getMacho22() {
        return macho22;
    }

    public void setMacho22(String macho22) {
        this.macho22 = macho22;
    }

    public String getFemea22() {
        return femea22;
    }

    public void setFemea22(String femea22) {
        this.femea22 = femea22;
    }

    public String getMacho31() {
        return macho31;
    }

    public void setMacho31(String macho31) {
        this.macho31 = macho31;
    }

    public String getFemea31() {
        return femea31;
    }

    public void setFemea31(String femea31) {
        this.femea31 = femea31;
    }

    public String getMacho32() {
        return macho32;
    }

    public void setMacho32(String macho32) {
        this.macho32 = macho32;
    }

    public String getFemea32() {
        return femea32;
    }

    public void setFemea32(String femea32) {
        this.femea32 = femea32;
    }

    public String getMacho33() {
        return macho33;
    }

    public void setMacho33(String macho33) {
        this.macho33 = macho33;
    }

    public String getFemea33() {
        return femea33;
    }

    public void setFemea33(String femea33) {
        this.femea33 = femea33;
    }

    public String getMacho34() {
        return macho34;
    }

    public void setMacho34(String macho34) {
        this.macho34 = macho34;
    }

    public String getFemea34() {
        return femea34;
    }

    public void setFemea34(String femea34) {
        this.femea34 = femea34;
    }

    public String getMacho41() {
        return macho41;
    }

    public void setMacho41(String macho41) {
        this.macho41 = macho41;
    }

    public String getFemea41() {
        return femea41;
    }

    public void setFemea41(String femea41) {
        this.femea41 = femea41;
    }

    public String getMacho42() {
        return macho42;
    }

    public void setMacho42(String macho42) {
        this.macho42 = macho42;
    }

    public String getFemea42() {
        return femea42;
    }

    public void setFemea42(String femea42) {
        this.femea42 = femea42;
    }

    public String getMacho43() {
        return macho43;
    }

    public void setMacho43(String macho43) {
        this.macho43 = macho43;
    }

    public String getFemea43() {
        return femea43;
    }

    public void setFemea43(String femea43) {
        this.femea43 = femea43;
    }

    public String getMacho44() {
        return macho44;
    }

    public void setMacho44(String macho44) {
        this.macho44 = macho44;
    }

    public String getFemea44() {
        return femea44;
    }

    public void setFemea44(String femea44) {
        this.femea44 = femea44;
    }

    public String getMacho45() {
        return macho45;
    }

    public void setMacho45(String macho45) {
        this.macho45 = macho45;
    }

    public String getFemea45() {
        return femea45;
    }

    public void setFemea45(String femea45) {
        this.femea45 = femea45;
    }

    public String getMacho46() {
        return macho46;
    }

    public void setMacho46(String macho46) {
        this.macho46 = macho46;
    }

    public String getFemea46() {
        return femea46;
    }

    public void setFemea46(String femea46) {
        this.femea46 = femea46;
    }

    public String getMacho47() {
        return macho47;
    }

    public void setMacho47(String macho47) {
        this.macho47 = macho47;
    }

    public String getFemea47() {
        return femea47;
    }

    public void setFemea47(String femea47) {
        this.femea47 = femea47;
    }

    public String getMacho48() {
        return macho48;
    }

    public void setMacho48(String macho48) {
        this.macho48 = macho48;
    }

    public String getFemea48() {
        return femea48;
    }

    public void setFemea48(String femea48) {
        this.femea48 = femea48;
    }

    public String getAnilha() {
        return anilha;
    }

    public void setAnilha(String anilha) {
        this.anilha = anilha;
    }

    public String getVenda() {
        return venda;
    }

    public void setVenda(String venda) {
        this.venda = venda;
    }

    public String getOcultar() {
        return ocultar;
    }

    public void setOcultar(String ocultar) {
        this.ocultar = ocultar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passaro passaro = (Passaro) o;
        return codigo.equals(passaro.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
