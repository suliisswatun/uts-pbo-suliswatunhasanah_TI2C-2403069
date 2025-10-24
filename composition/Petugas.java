package composition;

public class Petugas {
    private String id;
    private String nama;
    private String username;
    private String password;

    public Petugas(String id, String nama, String username, String password) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    
    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getUsername() { return username; }
    public String getPassword() {
    return password;
}


    // Login method (public) — dipanggil dari AplikasiRumahSakit
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void lihatData() {
        System.out.println("Petugas: " + id + " | " + nama + " | username: " + username);
    }
}
