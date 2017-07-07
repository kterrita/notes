package ru.beleychev.notes.service;

import ru.beleychev.notes.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author beleychev.ilya 06.07.2017   14:20
 */
public class UserRepositoryImpl implements UserRepositoryCustom {

	@PersistenceContext
	private EntityManager manager;

	public User findUserByName(String username) {
		try {
			return (User) manager.createQuery(
					"select u from User u where u.username = \'" + username + "\'")
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}
