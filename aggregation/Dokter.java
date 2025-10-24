package aggregation;
import java.util.Scanner;

public class Dokter {
    private String id;
    private String nama;
    private String spesialis;

    public Dokter(String id, String nama, String spesialis) {
        this.id = id;
        this.nama = nama;
        this.spesialis = spesialis;
    }
public void tambahData(Scanner scanner) {
    System.out.print("Masukkan ID Dokter: ");
    this.id = scanner.nextLine();
    System.out.print("Masukkan Nama Dokter: ");
    this.nama = scanner.nextLine();
    System.out.print("Masukkan Spesialis Dokter: ");
    this.spesialis = scanner.nextLine();
}

    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getSpesialis() { return spesialis; }

    public void lihatData() {
        System.out.println("Dokter: " + id + " | " + nama + " | Spesialis: " + spesialis);
    }
}
