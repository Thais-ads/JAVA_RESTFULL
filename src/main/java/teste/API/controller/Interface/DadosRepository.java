package teste.API.controller.Interface;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import teste.API.controller.model.Dados;

import java.util.Optional;

public interface DadosRepository extends JpaRepository <Dados, Long> {


    Page<Dados> findAllByAtivoTrue(Pageable paginacao);
}
