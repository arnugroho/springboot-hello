package com.arnugroho.springboot.hello.service;

import com.arnugroho.springboot.hello.dao.MahasiswaDao;
import com.arnugroho.springboot.hello.model.entity.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MahasiswaDaoServiceImpl implements MahasiswaDaoService {
    @Autowired
    private MahasiswaDao mahasiswaDao;

    @Override
    public Mahasiswa findByNamaHql(String nama) {
       return mahasiswaDao.findByNamaHql(nama);
    }
}
