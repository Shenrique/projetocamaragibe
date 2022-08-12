package projetocriadouro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projetocriadouro.model.Passaro;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface PassaroRepository extends JpaRepository<Passaro, Long> {

    @Query("from Passaro p where p.sexo = :sexo and status_reproducao = 'S' ORDER BY nome ASC")
    List<Passaro> findBySexo(@Param("sexo") String sexo);

    @Query("from Passaro p where p.nome = :nome")
    Passaro findByName(@Param("nome") String nome);

    @Query("from Passaro p where p.status_reproducao = 'N' ORDER BY nome ASC")
    List<Passaro> findByNameS();

    @Query("from Passaro p where p.status_reproducao = 'N' and p.sexo = 'Macho' ORDER BY macho1 ASC")
    List<Passaro> findByVendaMacho();

    @Query("from Passaro p where p.status_reproducao = 'N' and p.sexo = 'Fêmea' ORDER BY macho1 ASC")
    List<Passaro> findByVendaFemea();

    @Query("from Passaro p where p.anilha = :anilha")
    Passaro findByAnilhaFilhoteVenda(@Param("anilha") String anilha);

    @Query("from Passaro p where p.status_reproducao = 'S' ORDER BY nome ASC")
    List<Passaro> findByNamePlantel();

    @Query("from Passaro p where p.sexo = 'Macho' and status_reproducao = 'S' ORDER BY nome ASC")
    List<Passaro> findByGalador();

    @Query("from Passaro ORDER BY nome ASC")
    List<Passaro> findTodos();

}
