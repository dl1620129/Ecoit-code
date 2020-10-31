package com.ecodoc.backend.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ecodoc.backend.core.domain.RootModel;

public interface IService<T extends RootModel> {

	long count();

	void deleteAll(Iterable<T> entities);

	void delete(T entity);

	void deleteById(Long id);

	boolean existsById(Long id);

	T save(T entity);

	T saveAndFlush(T entity);

	List<T> saveAll(Iterable<T> entities);

	T getOne(Long id);

	Optional<T> findById(Long id);

	List<T> findAll();

	List<T> findAllById(Iterable<Long> ids);

	List<T> findAll(Sort sort);

	Page<T> findAll(Pageable pageable);

	Page<T> findAllByClientId(Long clientId, Pageable pageable);

	List<T> findByClientId(Long clientId, Pageable pageable);

	List<T> findByClientId(Long clientId);

	T findByClientIdAndId(Long clientId, Long id);

	List<T> findByClientIdAndActive(Long clientId, boolean active, Pageable pageable);

	List<T> findByClientIdAndActive(Long clientId, boolean active);

	public List<T> findByClientIdAndActive(Long clientId, boolean active, int page);

	public List<T> findByClientId(Long clientId, int page);

	public List<T> findByClientId(Long clientId, Sort sort);

	public List<T> findByClientIdAndActive(Long clientId, Boolean active, Sort sort);
}
