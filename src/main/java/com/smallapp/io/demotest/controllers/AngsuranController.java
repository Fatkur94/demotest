package com.smallapp.io.demotest.controllers;

import java.util.List;

import javax.validation.Valid;

import com.smallapp.io.demotest.domain.Angsuran;
import com.smallapp.io.demotest.repositories.AngsuranRepository;
import com.smallapp.io.demotest.request.CreateAngsuranRequest;
import com.smallapp.io.demotest.service.AngsuranService;
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
public class AngsuranController {

    @Autowired
    public AngsuranRepository angsuranRepository;

    @Autowired
    public AngsuranService angsuranService;

    @Autowired
    public TrxHistoryService trxHistoryService;
    
    @RequestMapping(value="/angsuran", method=RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Angsuran> getAll() {
        return angsuranRepository.findAll();
    }
    @RequestMapping(value="/angsuran", method=RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> createAngsuran(@Valid @RequestBody CreateAngsuranRequest angsuranRequest) {
        int status = angsuranService.create(angsuranRequest);
        if (status == 3 || status == 4) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        trxHistoryService.createAngsuran(angsuranRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value="/angsuran/{id}", method=RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Angsuran getAngsuranById(@PathVariable Long id) {
        
        return angsuranRepository.findOneById(id);
    }
}
