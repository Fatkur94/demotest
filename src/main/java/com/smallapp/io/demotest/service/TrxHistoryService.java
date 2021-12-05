package com.smallapp.io.demotest.service;

import java.util.Date;

import com.smallapp.io.demotest.config.Constants;
import com.smallapp.io.demotest.domain.Simpanan;
import com.smallapp.io.demotest.domain.TrxHistory;
import com.smallapp.io.demotest.repositories.TrxHistoryRepository;
import com.smallapp.io.demotest.request.CreateAngsuranRequest;
import com.smallapp.io.demotest.request.CreateSimpananRequest;
import com.smallapp.io.demotest.request.CreateTrxHistoryRequest;
import com.smallapp.io.demotest.request.PinjamanRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TrxHistoryService {

    @Autowired
    private KafkaTemplate <String, TrxHistory> kafkaTemplate;

    @Autowired
    public TrxHistoryRepository trxHistoryRepository;

    public void create(CreateTrxHistoryRequest trxHistoryRequest) {
        TrxHistory trxHistory = new TrxHistory();
        trxHistory.setAnggota(trxHistoryRequest.getAnggota());
        trxHistory.setJenis(trxHistoryRequest.getJenis());
        trxHistory.setKode(trxHistoryRequest.getKode());
        trxHistory.setSimpanPinjam(trxHistoryRequest.getSimpanpinjam());
        trxHistory.setNominal(trxHistoryRequest.getNominal());
        trxHistory.setTgl_trx(new Date());
        
        trxHistoryRepository.save(trxHistory);
    }

    public void createSimpanan(CreateSimpananRequest simpananRequest) {
        TrxHistory trxHistory = new TrxHistory();
        trxHistory.setAnggota(simpananRequest.getAnggota());
        trxHistory.setJenis(Constants.SAVING);
        trxHistory.setSimpanPinjam(Constants.SIMPAN);
        trxHistory.setNominal(simpananRequest.getSaldo());
        trxHistory.setTgl_trx(new Date());
        trxHistory.setKeterangan(Constants.SIMPAN + " " + simpananRequest.getSaldo());
        
        trxHistoryRepository.save(trxHistory);

        kafkaTemplate.send(Constants.TOPIC, trxHistory);
    }

    public void withdraw(Simpanan simpanan, Long withdraw) {
        TrxHistory trxHistory = new TrxHistory();
        trxHistory.setAnggota(simpanan.getAnggota());
        trxHistory.setJenis(Constants.WITHDRAW);
        trxHistory.setSimpanPinjam(Constants.SIMPAN);
        trxHistory.setNominal(withdraw);
        trxHistory.setTgl_trx(new Date());
        trxHistory.setKeterangan("withdraw " + withdraw);
        
        trxHistoryRepository.save(trxHistory);
        kafkaTemplate.send(Constants.TOPIC, trxHistory);
    }

    public void createPinjaman(PinjamanRequest pinjamanRequest) {
        TrxHistory trxHistory = new TrxHistory();
        trxHistory.setAnggota(pinjamanRequest.getAnggota());
        trxHistory.setJenis(Constants.LOAN);
        trxHistory.setSimpanPinjam(Constants.PINJAM);
        trxHistory.setNominal(pinjamanRequest.getTotal_pinjam());
        trxHistory.setTgl_trx(new Date());
        trxHistory.setKeterangan(Constants.PINJAM + " " + pinjamanRequest.getTotal_pinjam());
        
        trxHistoryRepository.save(trxHistory);
        kafkaTemplate.send(Constants.TOPIC, trxHistory);

    }

    public void createAngsuran(CreateAngsuranRequest angsuranRequest) {
        TrxHistory trxHistory = new TrxHistory();
        trxHistory.setAnggota(angsuranRequest.getAnggota());
        trxHistory.setJenis(Constants.INSTALLMENT);
        trxHistory.setKode(angsuranRequest.getKode());
        trxHistory.setSimpanPinjam(Constants.PINJAM);
        trxHistory.setNominal(angsuranRequest.getBayar());
        trxHistory.setTgl_trx(new Date());
        trxHistory.setKeterangan(angsuranRequest.getKeterangan());
        
        trxHistoryRepository.save(trxHistory);
        kafkaTemplate.send(Constants.TOPIC, trxHistory);
    }
}
