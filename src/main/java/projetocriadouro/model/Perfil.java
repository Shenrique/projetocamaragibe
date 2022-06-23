package projetocriadouro.model;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "perfis")
public class Perfil{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "descricao", nullable = false, unique = true)
	private String desc;

	public Perfil() {
	}

	public Perfil(long cod) {
		this.id = cod;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
