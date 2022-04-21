package com.arnugroho.springboot.hello.repository;

import com.arnugroho.springboot.hello.model.entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {
}
