public abstract class Orang {
    enum JENIS_KELAMIN {
        LAKI_LAKI,
        PEREMPUAN
    }

    private String nama;
    private String tanggalLahir;
    private JENIS_KELAMIN jenisKelamin;

    public Orang(String nama, String tanggalLahir, JENIS_KELAMIN jenisKelamin) {
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
    }

    public String getNama() {
        return nama;
    }

    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Tanggal Lahir: " + tanggalLahir);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
    }
}
