package association;

import aggregation.Dokter;
import aggregation.Pasien;

public class RekamMedisAssociation {
    private String id;
    private Pasien pasien;
    private Dokter dokter;
    private String diagnosa;
    private double biaya;

    public RekamMedisAssociation(String id, Pasien pasien, Dokter dokter, String diagnosa, double biaya) {
        this.id = id;
        this.pasien = pasien;
        this.dokter = dokter;
        this.diagnosa = diagnosa;
        this.biaya = biaya;
    }

    public String getIdRekamMedis() { return id; }
    public Pasien getPasien() { return pasien; }
    public Dokter getDokter() { return dokter; }
    public String getDiagnosa() { return diagnosa; }
    public double getBiaya() { return biaya; }
    
    

    public void tampilkanData() {
        System.out.println("ID Rekam Medis : " + id);
        System.out.println("Pasien : " + pasien.getNama());
        System.out.println("Dokter : " + dokter.getNama());
        System.out.println("Diagnosa : " + diagnosa);
        System.out.println("Biaya : " + biaya);
    }
}
