package com.arnugroho.springboot.hello.repository;

import com.arnugroho.springboot.hello.model.entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {
    Optional<Mahasiswa> findByNama(String nama);
}
