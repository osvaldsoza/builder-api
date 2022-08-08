package br.com.osvaldsoza.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.osvaldsoza.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

     Page<Cliente> findClienteByNomeContaining(String nome, Pageable pageable);
}
