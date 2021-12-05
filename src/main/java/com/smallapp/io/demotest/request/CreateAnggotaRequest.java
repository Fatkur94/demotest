package com.smallapp.io.demotest.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CreateAnggotaRequest {
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    private String nama;
    private String alamat;
    private String group_name;
    private String keterangan;
    @JsonFormat(pattern = "ddMMyyyy")
    private Date tgl_lahir;
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getGroup_name() {
        return group_name;
    }
    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }
    public String getKeterangan() {
        return keterangan;
    }
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    public Date getTgl_lahir() {
        return tgl_lahir;
    }
    public void setTgl_lahir(Date tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

}
