package com.ssh.repository.impl;

import com.ssh.entity.LyUser;
import com.ssh.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XRog
 * On 2/2/2017.2:30 PM
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public LyUser load(Long id) {
        return (LyUser)getCurrentSession().load(LyUser.class,id);
    }

    public LyUser get(Long id) {
        return (LyUser)getCurrentSession().get(LyUser.class,id);
    }

    public List<LyUser> findAll() {
        return null;
    }

    public void persist(LyUser entity) {
        getCurrentSession().persist(entity);
    }

    public Long save(LyUser entity) {
        return (Long)getCurrentSession().save(entity);
    }

    public void saveOrUpdate(LyUser entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Long id) {
        LyUser user = load(id);
        getCurrentSession().delete(user);
    }

    public void flush() {
        getCurrentSession().flush();
    }
}