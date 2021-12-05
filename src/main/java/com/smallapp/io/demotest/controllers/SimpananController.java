package com.smallapp.io.demotest.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import com.smallapp.io.demotest.domain.Simpanan;
import com.smallapp.io.demotest.repositories.SimpananRepository;
import com.smallapp.io.demotest.request.CreateSimpananRequest;
import com.smallapp.io.demotest.request.UpdateSimpananRequest;
import com.smallapp.io.demotest.service.SimpananService;
import com.smallapp.io.demotest.service.TrxHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/api")
public class SimpananController {

    @Autowired
    public SimpananRepository simpananRepository;
    
    @Autowired
    public SimpananService simpananService;

    @Autowired
    public TrxHistoryService trxHistoryService;

    @RequestMapping(value="/simpanan", method=RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Simpanan> getAll() {
        return simpananRepository.findAll();
    }

    @RequestMapping(value="/simpanan", method=RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> createSimpanan(@Valid @RequestBody CreateSimpananRequest simpananRequest) {
        simpananService.createSimpanan(simpananRequest);
        trxHistoryService.createSimpanan(simpananRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value="/simpanan/{id}", method=RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Simpanan getSimpananById(@PathVariable Long id) {
        return simpananRepository.findOneById(id);
    }

    @RequestMapping(value="/simpanan/withdraw/{id}", method=RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> updateBalance(@PathVariable Long id, @Valid @RequestBody UpdateSimpananRequest simpananRequest) {
        Simpanan updateSimpanan = simpananRepository.findOneById(id);
        if (updateSimpanan == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        int status = simpananService.updateBalance(updateSimpanan, simpananRequest.getWithdraw());

        if (status == 5) {
            return new ResponseEntity<>("Insuffient Balance", HttpStatus.BAD_REQUEST);
        }
        trxHistoryService.withdraw(updateSimpanan, simpananRequest.getWithdraw());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/simpanan/{id}", method=RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> deleteSimpananById(@PathVariable Long id) {
        Simpanan deleteSimpanan = simpananRepository.findOneById(id);
        if (deleteSimpanan == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        simpananService.deleteSimpanan(deleteSimpanan);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
