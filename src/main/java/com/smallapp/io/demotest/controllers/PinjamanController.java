package com.smallapp.io.demotest.controllers;

import java.util.List;

import javax.validation.Valid;

import com.smallapp.io.demotest.domain.Pinjaman;
import com.smallapp.io.demotest.repositories.PinjamanRepository;
import com.smallapp.io.demotest.request.PinjamanRequest;
import com.smallapp.io.demotest.service.PinjamanService;
import com.smallapp.io.demotest.service.TrxHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PinjamanController {

    @Autowired
    public PinjamanRepository pinjamanRepository;

    @Autowired
    public PinjamanService pinjamanService;

    @Autowired
    public TrxHistoryService trxHistoryService;
    
    @RequestMapping(value="/pinjaman", method=RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Pinjaman> getAll() {
        return pinjamanRepository.findAll();
    }
    
    @RequestMapping(value="/pinjaman", method=RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> createPinjaman(@Valid @RequestBody PinjamanRequest pinjamanRequest) {
        pinjamanService.createPinjaman(pinjamanRequest);
        trxHistoryService.createPinjaman(pinjamanRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value="/pinjaman/{id}", method=RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Pinjaman getPinjamanById(@PathVariable Long id) {        
        return pinjamanRepository.findOneById(id);
    }
}