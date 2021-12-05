package com.smallapp.io.demotest.repositories;

import java.util.List;

import com.smallapp.io.demotest.domain.Simpanan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SimpananRepository extends JpaRepository<Simpanan, Long>{
    List<Simpanan> findAll();

    Simpanan findOneById(Long id);

    @Query(value = "SELECT COUNT(*) FROM simpanan " +
        " where anggota = ?1 ", nativeQuery = true)
    public Long isExist(String anggota);

    Simpanan findOneByAnggota(String anggota);
}
