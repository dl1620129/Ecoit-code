package com.ecodoc.backend.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ecodoc.backend.core.config.Constant;
import com.ecodoc.backend.core.domain.RootModel;
import com.ecodoc.backend.core.repository.IRepository;

/**
 * @author EcoDOC
 * 
 */
public abstract class BaseService<T extends RootModel> implements IService<T> {

	public abstract IRepository<T> getRepository();

	@Override
	public long count() {
		return getRepository().count();
	}

	@Override
	public void deleteById(Long id) {
		getRepository().deleteById(id);
	}

	@Override
	public void delete(T entity) {
		getRepository().delete(entity);
	}

	@Override
	public void deleteAll(Iterable<T> entities) {
		getRepository().deleteAll(entities);
	}

	@Override
	public T save(T entity) {
		return getRepository().save(entity);
	}

	@Override
	public List<T> saveAll(Iterable<T> entities) {
		return getRepository().saveAll(entities);
	}

	@Override
	public T saveAndFlush(T entity) {
		return getRepository().saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return getRepository().existsById(id);
	}

	@Override
	public T getOne(Long id) {
		return getRepository().getOne(id);
	}

	@Override
	public Optional<T> findById(Long id) {
		return getRepository().findById(id);
	}

	@Override
	public List<T> findAll() {
		return getRepository().findAll();
	}

	@Override
	public List<T> findAllById(Iterable<Long> ids) {
		return getRepository().findAllById(ids);
	}

	@Override
	public List<T> findAll(Sort sort) {
		return getRepository().findAll(sort);
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return getRepository().findAll(pageable);
	}

	@Override
	public List<T> findByClientIdAndActive(Long clientId, boolean active) {
		return getRepository().findByClientIdAndActive(clientId, active);
	}

	@Override
	public List<T> findByClientIdAndActive(Long clientId, boolean active, Pageable pageable) {
		return getRepository().findByClientIdAndActive(clientId, active, pageable);
	}

	@Override
	public T findByClientIdAndId(Long clientId, Long id) {
		return getRepository().findByClientIdAndId(clientId, id);
	}

	@Override
	public List<T> findByClientId(Long clientId) {
		return getRepository().findByClientId(clientId);
	}

	@Override
	public List<T> findByClientId(Long clientId, Pageable pageable) {
		return getRepository().findByClientId(clientId, pageable);
	}

	@Override
	public Page<T> findAllByClientId(Long clientId, Pageable pageable) {
		return getRepository().findAllByClientId(clientId, pageable);
	}

	@Override
	public List<T> findByClientIdAndActive(Long clientId, boolean active, int page) {
		int numberPage = 1;
		if (page > 0) {
			numberPage = page - 1;
		}
		return getRepository().findByClientIdAndActive(clientId, active,
				PageRequest.of(numberPage, Constant.NUMBER_OF_PAGE));
	}

	@Override
	public List<T> findByClientId(Long clientId, int page) {
		int numberPage = 1;
		if (page > 0) {
			numberPage = page - 1;
		}
		return getRepository().findByClientId(clientId, PageRequest.of(numberPage, Constant.NUMBER_OF_PAGE));
	}

	@Override
	public List<T> findByClientId(Long clientId, Sort sort) {
		return getRepository().findByClientId(clientId, sort);
	}

	@Override
	public List<T> findByClientIdAndActive(Long clientId, Boolean active, Sort sort) {
		return getRepository().findByClientIdAndActive(clientId, active, sort);
	}
}
