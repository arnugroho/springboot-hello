package com.arnugroho.springboot.hello.dao;

import com.arnugroho.springboot.hello.model.entity.Mahasiswa;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MahasiswaDaoImpl implements MahasiswaDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Mahasiswa findByNamaHql(String nama) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "from Mahasiswa where nama = :namaValue";
        Query query = session.createQuery(hql);
        query.setString("namaValue", nama);
        if (query.list().size() > 0) {
            return (Mahasiswa) query.list().get(0);
        } else {
            return null;
        }
    }
}
