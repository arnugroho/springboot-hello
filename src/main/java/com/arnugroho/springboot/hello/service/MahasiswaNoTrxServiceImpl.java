package com.arnugroho.springboot.hello.service;

import com.arnugroho.springboot.hello.model.entity.Mahasiswa;
import com.arnugroho.springboot.hello.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MahasiswaNoTrxServiceImpl implements MahasiswaNoTrxService {
    @Autowired
    private MahasiswaRepository mahasiswaRepository;
    @Override
    public Mahasiswa saveMahasiswaNoTrx(Mahasiswa mahasiswa) {
        Mahasiswa mahasiswaResult = mahasiswaRepository.save(mahasiswa);
        int a = Integer.valueOf("angka");
        return mahasiswaResult;
    }
}
