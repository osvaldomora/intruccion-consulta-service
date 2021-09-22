package mx.santander.fiduciario.instruccionconsulta.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import mx.santander.fiduciario.instruccionconsulta.model.InstruccionConsulta;

/**
 * @author David Gonzalez - (Arquetipo creado por Santander Tecnologia Mexico)
 * Interface que extiende las operaciones CRUD del patron repository utilizado por Spring Data
 */
public interface IInstruccionConsultaRepository extends CrudRepository<InstruccionConsulta, Long> {
    
	@Cacheable("instruccionconsulta")
	Optional<InstruccionConsulta> findById(Long id);
	
    @Cacheable("instruccionconsulta")
    @CacheEvict(value = "instruccionconsulta", allEntries = true)
    Iterable<InstruccionConsulta> findAll();

    @CachePut("instruccionconsulta")
    <S extends InstruccionConsulta> S  save(S entity);

    @CacheEvict("instruccionconsulta")
    void deleteById(Long id);

}
