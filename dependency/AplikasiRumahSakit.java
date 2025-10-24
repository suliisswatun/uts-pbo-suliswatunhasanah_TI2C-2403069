package dependency;

import java.util.ArrayList;
import java.util.Scanner;

import aggregation.*;
import composition.Petugas;
import association.RekamMedisAssociation;
import composition.Laporan;

/**
 * Class ini merepresentasikan AplikasiRumahSakit.
 * - Aggregation: Dokter, Pasien
 * - Composition: Petugas, Laporan
 * - Association: RekamMedisAssociation
 * - Dependency: dari Main
 */
public class AplikasiRumahSakit {
    private ArrayList<Petugas> daftarPetugas = new ArrayList<>();
    private ArrayList<Dokter> daftarDokter = new ArrayList<>();
    private ArrayList<Pasien> daftarPasien = new ArrayList<>();
    private ArrayList<RekamMedisAssociation> daftarRekamMedis = new ArrayList<>();
    private ArrayList<Laporan> daftarLaporan = new ArrayList<>();
    private Petugas petugasAktif;

    // === Konstruktor ===
    public AplikasiRumahSakit() {
        inisialisasiData();
        login(); // login dijalankan dulu sebelum masuk menu
    }

    // === Inisialisasi data awal (Dependency dari Main) ===
    public void inisialisasiData() {
        daftarPetugas.add(new Petugas("P001", "Admin", "admin", "123"));
        daftarDokter.add(new Dokter("D01", "dr. Sulis", "Anak"));
        daftarDokter.add(new Dokter("D02", "dr. Rafa", "Umum"));
        daftarPasien.add(new Pasien("PS01", "Andi", 23, "Jl. Margalaksana, Indramayu"));
        daftarPasien.add(new Pasien("PS02", "Rindi", 5, "Jl. Margadadi, Indramayu"));
    }

    // === Login Petugas (Dependency) ===
    private void login() {
        Scanner input = new Scanner(System.in);
        System.out.println("=== LOGIN PETUGAS ===");

        boolean sukses = false;
        for (int i = 0; i < 3 && !sukses; i++) {
            System.out.print("Username: ");
            String user = input.nextLine();
            System.out.print("Password: ");
            String pass = input.nextLine();

            for (Petugas p : daftarPetugas) {
                if (p.getUsername().equals(user) && p.getPassword().equals(pass)) {
                    System.out.println("Login berhasil. Selamat datang, " + p.getNama() + "!");
                    petugasAktif = p;
                    sukses = true;
                    break;
                }
            }

            if (!sukses) System.out.println("Username atau password salah.\n");
        }

        if (!sukses) {
            System.out.println("Gagal login. Program berhenti.");
            System.exit(0);
        }
    }

    // === Menu utama ===
    public void tampilkanMenuUtama() {
        Scanner input = new Scanner(System.in);
        int pilih;
        do {
            System.out.println("\n=== MENU UTAMA RUMAH SAKIT ===");
            System.out.println("1. Dokter");
            System.out.println("2. Pasien");
            System.out.println("3. Catat Rekam Medis");
            System.out.println("4. Laporan Harian");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1 -> kelolaDokter();
                case 2 -> kelolaPasien();
                case 3 -> catatRekamMedis(input);
                case 4 -> laporanHarian();
                case 0 -> System.out.println("Keluar dari sistem...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 0);
    }

    // === Aggregation: AplikasiRumahSakit -> Dokter ===
    private void kelolaDokter() {
        Scanner input = new Scanner(System.in);
        int pilih;
        do {
            System.out.println("\n=== KELOLA DATA DOKTER ===");
            System.out.println("1. Lihat Daftar Dokter");
            System.out.println("2. Tambah Dokter");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.print("Pilih: ");
            pilih = input.nextInt();
            input.nextLine(); // buang newline

            switch (pilih) {
                case 1 -> {
                    System.out.println("\nDaftar Dokter:");
                    if (daftarDokter.isEmpty()) {
                        System.out.println("(Belum ada data dokter)");
                    } else {
                        for (Dokter d : daftarDokter) {
                            d.lihatData();
                        }
                    }
                }
                case 2 -> {
                    Dokter dokterBaru = new Dokter("", "", "");
                    dokterBaru.tambahData(input);
                    daftarDokter.add(dokterBaru);
                    System.out.println("✅ Data dokter berhasil ditambahkan!");
                }
                case 0 -> System.out.println("Kembali ke menu utama...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 0);
    }

    // === Aggregation: AplikasiRumahSakit -> Pasien ===
    private void kelolaPasien() {
        Scanner input = new Scanner(System.in);
        int pilih;
        do {
            System.out.println("\n=== KELOLA DATA PASIEN ===");
            System.out.println("1. Lihat Daftar Pasien");
            System.out.println("2. Tambah Pasien");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.print("Pilih: ");
            pilih = input.nextInt();
            input.nextLine(); // buang newline

            switch (pilih) {
                case 1 -> {
                    System.out.println("\nDaftar Pasien:");
                    if (daftarPasien.isEmpty()) {
                        System.out.println("(Belum ada data pasien)");
                    } else {
                        for (Pasien p : daftarPasien) {
                            p.lihatData();
                        }
                    }
                }
                case 2 -> {
                    System.out.println("\n=== Tambah Pasien Baru ===");
                    Pasien pasienBaru = new Pasien("", "", 0, "");
                    pasienBaru.tambahData(input);
                    daftarPasien.add(pasienBaru);
                    System.out.println("✅ Data pasien berhasil ditambahkan!");
                }
                case 0 -> System.out.println("Kembali ke menu utama...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 0);
    }

    // === Association: RekamMedis -> Dokter & Pasien ===
    private void catatRekamMedis(Scanner sc) {
        if (daftarDokter.isEmpty() || daftarPasien.isEmpty()) {
            System.out.println("Data dokter/pasien kosong!");
            return;
        }

        Dokter d = daftarDokter.get(0);
        Pasien p = daftarPasien.get(0);

        System.out.print("Masukkan diagnosa: ");
        sc.nextLine(); // flush
        String diagnosa = sc.nextLine();
        System.out.print("Masukkan biaya: ");
        double biaya = sc.nextDouble();

        RekamMedisAssociation rm = new RekamMedisAssociation("RM001", p, d, diagnosa, biaya);
        daftarRekamMedis.add(rm);
        System.out.println("Rekam medis tersimpan.");
    }

    // === Composition: AplikasiRumahSakit -> Laporan ===
    public void laporanHarian() {
        Laporan laporan = new Laporan("L001", daftarRekamMedis);
        laporan.tampilkanLaporan();
        daftarLaporan.add(laporan);
    }
}
