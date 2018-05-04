package com.ssh.repository.impl;

import com.ssh.entity.LyResources;
import com.ssh.repository.ResourceRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XRog
 * On 2/2/2017.2:30 PM
 */
@Repository
public class ResourceRepositoryImpl implements ResourceRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public LyResources load(Long id) {
        return (LyResources)getCurrentSession().load(LyResources.class,id);
    }

    public LyResources get(Long id) {
        return (LyResources)getCurrentSession().get(LyResources.class,id);
    }

    public List<LyResources> findAll() {
        return Lists.newArrayList();
    }

    public void persist(LyResources entity) {
        getCurrentSession().persist(entity);
    }

    public Long save(LyResources entity) {
        return (Long)getCurrentSession().save(entity);
    }

    public void saveOrUpdate(LyResources entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Long id) {
        LyResources lyResources = load(id);
        getCurrentSession().delete(lyResources);
    }

    public void flush() {
        getCurrentSession().flush();
    }
}