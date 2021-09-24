package mx.santander.fiduciario.instruccionconsulta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.santander.fiduciario.instruccionconsulta.model.TipoInstruccionAdcModel;

/**
 * Esta interface es el repositorio que permite realizar consultar a la BD, de acuerdo al
 * modelo establecido: TipoInstruccionAdcModel
 *
 */
@Repository
public interface ITypeInstructionAdcRepository extends JpaRepository<TipoInstruccionAdcModel, Long>{
	
	List<TipoInstruccionAdcModel> findByFkIdList(Long fkIdList);

}
