package com.smallapp.io.demotest.controllers;

import java.util.List;

import com.smallapp.io.demotest.domain.TrxLog;
import com.smallapp.io.demotest.repositories.TrxLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TrxLogController {
    @Autowired
    private TrxLogRepository trxLogRepository;

    @RequestMapping(value="/trx-log", method=RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<TrxLog> getAll(@RequestParam(required = false) String anggota) {
        if (anggota != null) return trxLogRepository.findByAnggota(anggota);
        return trxLogRepository.findAll();
    }
}
