package com.smallapp.io.demotest.controllers;

import java.util.List;

import com.smallapp.io.demotest.domain.TrxHistory;
import com.smallapp.io.demotest.repositories.TrxHistoryRepository;
import com.smallapp.io.demotest.service.TrxHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TrxHistoryController {

    @Autowired
    public TrxHistoryService trxHistoryService;

    @Autowired
    public TrxHistoryRepository trxHistoryRepository;

    @RequestMapping(value="/trx-history", method=RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<TrxHistory> getAll(
        @RequestParam(required = false) String from, 
        @RequestParam(required = false) String to,
        @RequestParam(required = false) String anggota) {
        
        if (from != null && to != null) 
            return trxHistoryRepository.findBetweenDates(from, to);

        if (anggota != null) 
            return trxHistoryRepository.findByAnggota(anggota);
        
        return trxHistoryRepository.findAll();
    }

    // @RequestMapping(value="/trx-history", method=RequestMethod.POST,
    //     produces = MediaType.APPLICATION_JSON_VALUE
    // )
    // public ResponseEntity<String> createAngsuran(@RequestBody CreateTrxHistoryRequest trxHistoryRequest) {
    //     trxHistoryService.create(trxHistoryRequest);
    //     return new ResponseEntity<>(HttpStatus.CREATED);
    // }

    @RequestMapping(value="/trx-history/{id}", method=RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public TrxHistory getAnggotaById(@PathVariable Long id) {
        return trxHistoryRepository.findOneById(id);
    }
}