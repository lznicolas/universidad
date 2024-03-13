package com.universidad.universidadbackend.servicios.implementaciones;

import com.universidad.universidadbackend.servicios.contratos.GenericoDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class GenericoDAOImpl <E, R extends CrudRepository<E,Integer>> implements GenericoDAO<E> {

    //proct ya que puede ser utilizado a tra vez de herencias, usando los getter, final para que lo puedamos instaciar a travez del contructor
    //
    protected final R repository;
    //add constructor por parametros para el refactor de abajo
    public GenericoDAOImpl(R repository) {
        this.repository = repository;
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public E save(E entidad) {
        return repository.save(entidad);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
