
import java.util.ArrayList;
import java.util.List;

public class Dokter extends Orang {
    private String idDokter;
    private String nomorSTR;
    private String spesialisasi;
    private List<Pasien> listAntrian;

    public Dokter(String nama, String tanggalLahir, JENIS_KELAMIN jenisKelamin, String nomorSTR, String spesialisasi) {
        super(nama, tanggalLahir, jenisKelamin);
        this.nomorSTR = nomorSTR;
        this.spesialisasi = spesialisasi;
        this.listAntrian = new ArrayList<>();
    }

    public String getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public List<Pasien> getAntrianPasien() {
        return listAntrian;
    }

    public void tambahAntrian(Pasien pasien) {
        listAntrian.add(pasien);
    }

    public void daftar(RumahSakit rumahSakit) {
        rumahSakit.tambahDokter(this);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Nomor STR: " + nomorSTR);
        System.out.println("Spesialisasi: " + spesialisasi);
    }
    public String getSpesialisasi() {
        return spesialisasi;
    }
}
