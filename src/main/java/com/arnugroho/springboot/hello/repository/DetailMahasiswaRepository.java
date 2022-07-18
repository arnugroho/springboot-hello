package com.arnugroho.springboot.hello.repository;

import com.arnugroho.springboot.hello.model.entity.DetailMahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailMahasiswaRepository extends JpaRepository<DetailMahasiswa, Integer> {
}
