package com.smallapp.io.demotest.repositories;

import java.util.List;

import com.smallapp.io.demotest.domain.TrxHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrxHistoryRepository extends JpaRepository<TrxHistory, String> {
    List<TrxHistory> findAll();

    TrxHistory findOneById(Long id);    
    TrxHistory findOneByKode(String kode);
    
    @Query(value = "SELECT * FROM trx_history " +
        " where anggota = ?1 " ,nativeQuery = true)
    public List<TrxHistory> findByAnggota(String anggota); 

    @Query(value = "SELECT * FROM trx_history " +
        " where tgl_trx >= to_date(?1, 'yyyy-MM-dd') and tgl_trx <= to_date(?2, 'yyyy-MM-dd') "
        ,nativeQuery = true)
    public List<TrxHistory> findBetweenDates(String from, String to);
}
