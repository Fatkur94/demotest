package com.smallapp.io.demotest.repositories;

import java.util.List;

import com.smallapp.io.demotest.domain.Pinjaman;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PinjamanRepository extends JpaRepository<Pinjaman, Long> {
    List<Pinjaman> findAll();

    Pinjaman findOneById(Long id);    

    @Query(value = "SELECT * FROM pinjaman " +
    " where kode = ?1 and tgl_lunas is null ", nativeQuery = true)
    Pinjaman findOneByKode(String kode);
}