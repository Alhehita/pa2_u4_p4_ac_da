package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class PropietarioRepositoryImpl implements PropietarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)

	public void insertar(Propietario propietario) {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

		this.entityManager.persist(propietario);

	}

	@Override
	@Transactional(value = TxType.MANDATORY)

	public void actualizar(Propietario propietario) {
		this.entityManager.merge(propietario);

	}

	@Override
	@Transactional(value = TxType.MANDATORY)

	public void eliminar(Integer id) {
		Propietario propietario = this.seleccionarPorId(id);
		this.entityManager.remove(propietario);

	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)

	public List<Propietario> buscarTodos() {
		TypedQuery<Propietario> query = this.entityManager.createQuery("SELECT p FROM Propietario p",
				Propietario.class);
		return query.getResultList();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)

	public Propietario seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Propietario.class, id);
	}

}
