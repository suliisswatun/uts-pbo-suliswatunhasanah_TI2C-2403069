package dependency;

import aggregation.RekamMedis;
import java.util.ArrayList;
import java.util.Date;

/**
 * Relasi: Dependency (dipanggil oleh AplikasiRumahSakit)
 * AplikasiRumahSakit --> Laporan  (dependency)
 * Laporan dibuat dan digunakan oleh AplikasiRumahSakit untuk menampilkan ringkasan.
 */
public class Laporan {
    private String idLaporan;
    private Date tanggal;
    private ArrayList<RekamMedis> daftarRekamMedis;
    private double totalPendapatan;
    private int jumlahPasien;

    public Laporan(String idLaporan, Date tanggal, ArrayList<RekamMedis> daftarRekamMedis) {
        this.idLaporan = idLaporan;
        this.tanggal = tanggal;
        this.daftarRekamMedis = daftarRekamMedis;
        hitungTotalPendapatan();
    }

    private void hitungTotalPendapatan() {
        totalPendapatan = 0;
        jumlahPasien = daftarRekamMedis.size();
        for (RekamMedis rm : daftarRekamMedis) {
            totalPendapatan += rm.getBiaya();
        }
    }

    public void tampilkanLaporan() {
        System.out.println("\n=== LAPORAN HARIAN ===");
        System.out.println("ID Laporan: " + idLaporan);
        System.out.println("Tanggal: " + tanggal);
        System.out.println("Jumlah Pasien: " + jumlahPasien);
        System.out.println("Total Pendapatan: " + totalPendapatan);
        System.out.println("======================\n");
    }
}
