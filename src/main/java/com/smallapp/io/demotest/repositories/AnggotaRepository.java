package com.smallapp.io.demotest.repositories;

import java.util.List;

import com.smallapp.io.demotest.domain.Anggota;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnggotaRepository extends JpaRepository<Anggota, Long>{
    List<Anggota> findAll();
    
    Anggota findOneById(Long id);

    // @Modifying 
    // @Query(value = "UPDATE anggota " +
    //     "SET  "
    // , nativeQuery = true)
    // public void vaMatchBiller(String fileName);
}
