package composition;

import association.RekamMedisAssociation;
import java.util.ArrayList;

public class Laporan {
    private String idLaporan;
    private ArrayList<RekamMedisAssociation> daftarRekamMedis;

    public Laporan(String idLaporan, ArrayList<RekamMedisAssociation> daftarRekamMedis) {
        this.idLaporan = idLaporan;
        this.daftarRekamMedis = daftarRekamMedis;
    }

    public void tampilkanLaporan() {
        System.out.println("\n=== LAPORAN RUMAH SAKIT ===");
        double total = 0;
        for (RekamMedisAssociation rm : daftarRekamMedis) {
            total += rm.getBiaya();
        }
        System.out.println("Total pendapatan: " + total);
        System.out.println("Jumlah pasien: " + daftarRekamMedis.size());
    }
}

