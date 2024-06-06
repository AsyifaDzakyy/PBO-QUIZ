
public class Antrian {
    public enum tipePasiens {
        BPJS, MANDIRI
    }
    private String nomorAntrian;
    private Pasien pasien;
    private String keluhan;
    private Dokter dokter;
    private tipePasiens tipePasien;

    public Antrian(String nomorAntrian, Pasien pasien, String keluhan, Dokter dokter, tipePasiens tipePasien) {
        this.nomorAntrian = nomorAntrian;
        this.pasien = pasien;
        this.keluhan = keluhan;
        this.dokter = dokter;
        this.tipePasien = tipePasien;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public String getNomorAntrian() {
        return nomorAntrian;
    }

    public void displayInfo() {
        System.out.println("Nomor Antrian: " + nomorAntrian);
        System.out.println("Nama Pasien: " + pasien.getNama());
        System.out.println("Keluhan: " + keluhan);
        System.out.println("Nama Dokter: " + dokter.getNama());
        System.out.println("Tipe Pasien: " + tipePasien);
    }
}
