public class Pasien extends Orang {
    private String pekerjaan;
    private String domisili;
    private Antrian antrian;

    public Pasien(String nama, String tanggalLahir, JENIS_KELAMIN jenisKelamin, String pekerjaan, String domisili) {
        super(nama, tanggalLahir, jenisKelamin);
        this.pekerjaan = pekerjaan;
        this.domisili = domisili;
    }

    public void daftar(RumahSakit rumahSakit, String keluhan, String namaDokter, Antrian.tipePasiens tipePasien) {
        Dokter dokter = rumahSakit.cariDokter(namaDokter);
        if (dokter != null) {
            if (rumahSakit.cariAntrianPasien(this) == null) {
                Antrian antrianBaru = new Antrian(dokter.getIdDokter() + "-" + (dokter.getAntrianPasien().size() + 1), this, keluhan, dokter, tipePasien);
                rumahSakit.tambahAntrian(antrianBaru);
                dokter.tambahAntrian(this);
                System.out.println("Pasien " + this.getNama() + " telah terdaftar ke dokter " + namaDokter + " dengan keluhan: " + keluhan);
            } else {
                System.out.println("Pasien " + this.getNama() + " sudah terdaftar.");
            }
        } else {
            System.out.println("Dokter " + namaDokter + " tidak ditemukan.");
        }
    }

    public void periksa(RumahSakit rumahSakit) {
        Antrian antrianPertama = rumahSakit.getAntrianPertama();
        if (antrianPertama != null && antrianPertama.getPasien().equals(this)) {
            rumahSakit.selesaikanAntrian(antrianPertama);
            System.out.println("Pasien " + this.getNama() + " telah selesai diperiksa oleh dokter " + antrianPertama.getDokter().getNama());
        } else {
            System.out.println("Pasien " + this.getNama() + " belum terdaftar untuk diperiksa atau bukan giliran Anda.");
        }
    }



    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Pekerjaan: " + pekerjaan);
        System.out.println("Domisili: " + domisili);
    }
}
