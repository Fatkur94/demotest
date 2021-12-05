package com.smallapp.io.demotest.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.smallapp.io.demotest.domain.Anggota;
import com.smallapp.io.demotest.repositories.AnggotaRepository;
import com.smallapp.io.demotest.request.AnggotaRequest;
import com.smallapp.io.demotest.request.CreateAnggotaRequest;
import com.smallapp.io.demotest.service.AnggotaService;

import org.json.JSONException;
import org.json.JSONObject;
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
public class AnggotaController {

    @Autowired
    public AnggotaRepository anggotaRepository;

    @Autowired
    public AnggotaService anggotaService;

    @RequestMapping(value="/anggota", method=RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Anggota> getAll() {
        return anggotaRepository.findAll();
    }

    @RequestMapping(value="/anggota", method=RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> createAnggota(@RequestBody CreateAnggotaRequest anggotaRequest) {
        anggotaService.createAnggota(anggotaRequest);        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value="/anggota/{id}", method=RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Anggota getAnggotaById(@PathVariable Long id) {
        
        return anggotaRepository.findOneById(id);
    }

    @RequestMapping(value="/anggota/{id}", method=RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> updateAnggotaById(@PathVariable Long id, @RequestBody AnggotaRequest anggotaRequest) {
        Anggota updateAnggota = anggotaRepository.findOneById(id);
        if (updateAnggota == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        anggotaService.updateAnggotaInfo(updateAnggota, anggotaRequest.getAlamat(), anggotaRequest.getKeterangan());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/anggota/{id}", method=RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> deleteAnggotaById(@PathVariable Long id) {
        Anggota deleteAnggota = anggotaRepository.findOneById(id);
        if (deleteAnggota == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        anggotaService.deleteAnggota(deleteAnggota);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
