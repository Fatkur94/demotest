package com.smallapp.io.demotest.repositories;

import java.util.List;

import com.smallapp.io.demotest.domain.Angsuran;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AngsuranRepository extends JpaRepository<Angsuran, Long> {
    List<Angsuran> findAll();
    
    Angsuran findOneById(Long id);

    @Query(value = "SELECT * FROM angsuran " +
        " where kode = ?1 ORDER BY periode DESC LIMIT 1 ", nativeQuery = true)
    public Angsuran recentAngsuran(String kode);
}
