package com.smallapp.io.demotest.domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "simpanan")
public class Simpanan implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="anggota", nullable = false)
    private String anggota;

    @Column(name="jenis", nullable = false)
    private String jenis;

    @Column(name="saldo", nullable = false)
    @Min(value = 0L, message = "saldo value must be positive")
    private Long saldo;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getAnggota() {
        return anggota;
    }
    public void setAnggota(String anggota) {
        this.anggota = anggota;
    }
    public String getJenis() {
        return jenis;
    }
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    public Long getSaldo() {
        return saldo;
    }
    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }   
}