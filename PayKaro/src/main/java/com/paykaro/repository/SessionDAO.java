package com.paykaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paykaro.model.CurrentUserSession;

public interface SessionDAO extends JpaRepository<CurrentUserSession, Integer> {
	public CurrentUserSession findByUuid(String uuid);

}
