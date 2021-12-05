package com.smallapp.io.demotest.repositories;

import java.util.List;

import com.smallapp.io.demotest.domain.TrxLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrxLogRepository extends MongoRepository<TrxLog, String> {
    List<TrxLog> findAll();

    List<TrxLog> findByAnggota(String anggota);
}