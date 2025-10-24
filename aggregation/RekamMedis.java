package aggregation;

import java.util.Date;

/**
 * Relasi: Association (Unidirectional)
 * RekamMedis --> Dokter (association)
 * RekamMedis --> Pasien (association)
 *
 * RekamMedis menyimpan referensi ke Dokter dan Pasien yang terkait.
 */
public class RekamMedis {
    private String id;
    private Pasien pasien;   // association (unidirectional)
    private Dokter dokter;   // association (unidirectional)
    private String diagnosa;
    private double biaya;
    private Date tanggalPeriksa;

    public RekamMedis(String id, Pasien pasien, Dokter dokter, String diagnosa, double biaya, Date tanggalPeriksa) {
        this.id = id;
        this.pasien = pasien;
        this.dokter = dokter;
        this.diagnosa = diagnosa;
        this.biaya = biaya;
        this.tanggalPeriksa = tanggalPeriksa;
    }

    public String getId() { return id; }
    public Pasien getPasien() { return pasien; }
    public Dokter getDokter() { return dokter; }
    public double getBiaya() { return biaya; }
    public Date getTanggalPeriksa() { return tanggalPeriksa; }

    public void lihatData() {
        System.out.println("=== Rekam Medis ===");
        System.out.println("ID: " + id);
        System.out.println("Pasien: " + pasien.getNama());
        System.out.println("Dokter: " + dokter.getNama());
        System.out.println("Diagnosa: " + diagnosa);
        System.out.println("Biaya: " + biaya);
        System.out.println("Tanggal: " + tanggalPeriksa);
    }
}
