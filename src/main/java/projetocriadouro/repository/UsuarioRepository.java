package projetocriadouro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projetocriadouro.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("from Usuario p where p.nome = :nome and senha = :senha")
    Usuario findNomeSenha(@Param("nome") String nome, @Param("senha") String senha);

}
