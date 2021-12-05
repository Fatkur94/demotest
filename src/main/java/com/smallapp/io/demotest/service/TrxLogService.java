package com.smallapp.io.demotest.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.smallapp.io.demotest.config.Constants;
import com.smallapp.io.demotest.domain.TrxHistory;
import com.smallapp.io.demotest.domain.TrxLog;
import com.smallapp.io.demotest.repositories.TrxLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TrxLogService {

	public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.format(date);
	}

    @Autowired
    private TrxLogRepository trxLogRepository;

    public void create(TrxHistory trxHistory) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        TrxLog log = new TrxLog();
        log.setAnggota(trxHistory.getAnggota());
        log.setJenis(trxHistory.getJenis());
        log.setKetarangan(trxHistory.getKeterangan());
        log.setKode(trxHistory.getKode());
        log.setNominal(trxHistory.getNominal());
        log.setSimpanpinjam(trxHistory.getSimpanPinjam());
        log.setTgl_trx( formatter.format( trxHistory.getTgl_trx() ) );

        trxLogRepository.save(log);
    }

    @KafkaListener(id = Constants.KAFKA_ID, topics = Constants.TOPIC)
    public void kafkaConsumer(TrxHistory trxHistory) {
        System.out.println("Data yang ditarik : " + trxHistory.getAnggota());
        create(trxHistory);
    }
}
