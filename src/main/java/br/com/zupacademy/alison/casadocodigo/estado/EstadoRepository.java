package br.com.zupacademy.alison.casadocodigo.estado;

import org.springframework.data.repository.CrudRepository;

public interface EstadoRepository extends CrudRepository<Estado, Long> {
    boolean existsByNomeAndPaisId(String nome, Long paisId);

    boolean existsByPaisId(Long pais);

    boolean existsByIdAndPaisId(Long estado, Long pais);

}
