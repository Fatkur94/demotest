package com.smallapp.io.demotest.service;


import com.smallapp.io.demotest.config.Constants;
import com.smallapp.io.demotest.domain.Simpanan;
import com.smallapp.io.demotest.repositories.SimpananRepository;
import com.smallapp.io.demotest.request.CreateSimpananRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SimpananService {

    @Autowired
    public SimpananRepository simpananRepository;

    public void createSimpanan(CreateSimpananRequest simpananRequest) {
        Simpanan updateSimpanan = simpananRepository.findOneByAnggota(simpananRequest.getAnggota());
        if (updateSimpanan == null) {
            Simpanan simpanan = new Simpanan();
            simpanan.setAnggota(simpananRequest.getAnggota());
            simpanan.setJenis(simpananRequest.getJenis());
            simpanan.setSaldo(simpananRequest.getSaldo());
            simpananRepository.save(simpanan);
        } else {
            updateSimpanan.setSaldo(updateSimpanan.getSaldo() + simpananRequest.getSaldo());
            simpananRepository.save(updateSimpanan);
        }
    }

    public int updateBalance(Simpanan simpanan, Long withdraw) {
        if ( simpanan.getSaldo() < withdraw ) {
            return Constants.INSUFFICIENT_BALANCE;
        }
        Long updatedBalance = simpanan.getSaldo() - withdraw;
        simpanan.setSaldo(updatedBalance);
        simpananRepository.save(simpanan);

        return Constants.SUCCESS;

    }

    public void deleteSimpanan(Simpanan deleteSimpanan) {
        simpananRepository.delete(deleteSimpanan);
    }
}