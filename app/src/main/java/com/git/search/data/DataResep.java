package com.git.search.data;

/**
 * Created by zafar on 04/08/2017.
 */

public class DataResep {
    private String id_resep, nama_resep, bahan, cara_membuat, gambar;

    public DataResep(){

    }
    public DataResep(String id_resep, String nama_resep, String bahan, String cara_membuat, String gambar) {
        this.id_resep = id_resep;
        this.nama_resep = nama_resep;
        this.bahan = bahan;
        this.cara_membuat = cara_membuat;
        this.gambar = gambar;
    }

    public String getId_resep() {
        return id_resep;
    }

    public void setId_resep(String id_resep) {
        this.id_resep = id_resep;
    }

    public String getNama_resep() {
        return nama_resep;
    }

    public void setNama_resep(String nama_resep) {
        this.nama_resep = nama_resep;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    public String getCara_membuat() {
        return cara_membuat;
    }

    public void setCara_membuat(String cara_membuat) {
        this.cara_membuat = cara_membuat;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
