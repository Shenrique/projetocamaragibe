package projetocriadouro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetocriadouro.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//    @Query("from Usuario p where p.usuario = :nome and senha = :senha")
//    Usuario findNomeSenha(@Param("usuario") String usuario, @Param("senha") String senha);

}
