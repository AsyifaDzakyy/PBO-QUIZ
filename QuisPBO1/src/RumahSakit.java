
import java.util.ArrayList;
import java.util.List;

public class RumahSakit {
    private String nama;
    private String alamat;
    private String noTelepon;
    private List<Dokter> listDokter;
    private List<Antrian> listAntrian;

    public RumahSakit(String nama, String alamat, String noTelepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.listDokter = new ArrayList<>();
        this.listAntrian = new ArrayList<>();
    }

    public void tambahDokter(Dokter dokter) {
        if (!listDokter.contains(dokter)) {
            dokter.setIdDokter("D-" + (listDokter.size() + 1) + "-" + dokter.getSpesialisasi());
            listDokter.add(dokter);
            System.out.println("Dokter " + dokter.getNama() + " berhasil ditambahkan dengan ID: " + dokter.getIdDokter());
        } else {
            System.out.println("Dokter " + dokter.getNama() + " sudah terdaftar.");
        }
    }

    public Dokter cariDokter(String namaDokter) {
        for (Dokter dokter : listDokter) {
            if (dokter.getNama().equals(namaDokter)) {
                return dokter;
            }
        }
        return null;
    }

    public void tambahAntrian(Antrian antrian) {
        listAntrian.add(antrian);

    }

    public void selesaikanAntrian(Antrian antrian) {
        listAntrian.remove(antrian);
        antrian.getDokter().getAntrianPasien().remove(antrian);

    }

    public Antrian cariAntrianPasien(Pasien pasien) {
        for (Antrian antrian : listAntrian) {
            if (antrian.getPasien().equals(pasien)) {
                return antrian;
            }
        }
        return null;
    }
    public Antrian getAntrianPertama() {
        if (!listAntrian.isEmpty()) {
            return listAntrian.get(0);
        }
        return null;
    }


    public void cekListDokter() {
        if (listDokter.isEmpty()) {
            System.out.println("BELUM ADA DOKTER YANG TERSEDIA SAAT INI");
        } else {
            System.out.println("BERIKUT LIST DOKTER YANG TERSEDIA SAAT INI");
            for (Dokter dokter : listDokter) {
                System.out.println("Nama Dokter " + dokter.getNama() + ", Dokter spesialis " + dokter.getSpesialisasi());
            }
        }
    }

    public void cekAntrianPasien() {
        System.out.println("Daftar Antrian di Rumah Sakit " + nama + ":");
        System.out.println("==========================================");
        for (Antrian antrian : listAntrian) {
            antrian.displayInfo();
            System.out.println();
        }
        for (Dokter dokter : listDokter) {
            if (dokter.getAntrianPasien().isEmpty()) {
                System.out.println("Dokter " + dokter.getNama() + " tidak memiliki pasien dalam antrian.");
            }
        }
    }
}
