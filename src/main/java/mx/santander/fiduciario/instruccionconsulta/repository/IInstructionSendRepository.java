package mx.santander.fiduciario.instruccionconsulta.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.santander.fiduciario.instruccionconsulta.model.InstruccionEnviada;

/**
 * Esta interface es el repositorio que permite realizar consultar a la BD, de acuerdo al
 * modelo establecido: InstruccionEnviada
 */
@Repository
public interface IInstructionSendRepository extends JpaRepository<InstruccionEnviada, Long>{


	List<InstruccionEnviada> findByIdFkBucAndIdNoContrAndIdNoSubContrAndFchRegisInsctAfter(String idBuc, Long idNoContr, Long idNoSubContr, Date dateAfter);
}
