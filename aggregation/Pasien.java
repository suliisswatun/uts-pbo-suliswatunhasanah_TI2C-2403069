package aggregation;
import java.util.Scanner;

public class Pasien {
    private String id;
    private String nama;
    private int umur;
    private String alamat;

    public Pasien(String id, String nama, int umur, String alamat) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
    }

    public void tambahData(Scanner scanner) {
        System.out.print("Masukkan ID Pasien: ");
        this.id = scanner.nextLine();
        System.out.print("Masukkan Nama Pasien: ");
        this.nama = scanner.nextLine();
        System.out.print("Masukkan Umur Pasien: ");
        this.umur = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan Alamat Pasien: ");
        this.alamat = scanner.nextLine();
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public int getUmur() { return umur; }
    public String getAlamat() { return alamat; }

    public void lihatData() {
        System.out.println("Pasien: " + id + " | " + nama + " | Umur: " + umur + " | Alamat: " + alamat);
    }
}
