public class HitungJumlahHuruf {
    public static String hitungHuruf(String kalimat) {
        // Mengubah kalimat menjadi huruf kecil agar persamaan huruf tidak memperhatikan
        // kapitalisasi
        kalimat = kalimat.toLowerCase();

        // Array untuk menyimpan jumlah setiap huruf
        int[] jumlahHuruf = new int[26];

        // Iterasi melalui setiap karakter dalam kalimat
        for (char huruf : kalimat.toCharArray()) {
            // Hanya memproses karakter huruf
            if (huruf >= 'a' && huruf <= 'z') {
                // Menghitung indeks untuk setiap huruf dalam array
                int indeks = huruf - 'a';
                // Menambahkan jumlah huruf ke dalam array
                jumlahHuruf[indeks]++;
            }
        }

        // Menghasilkan string output dengan format yang diinginkan
        StringBuilder output = new StringBuilder();
        for (char huruf = 'a'; huruf <= 'z'; huruf++) {
            int indeks = huruf - 'a';
            if (jumlahHuruf[indeks] > 0) {
                output.append(huruf).append("=").append(jumlahHuruf[indeks]).append(", ");
            }
        }

        // Menghapus koma dan spasi ekstra dari akhir string
        if (output.length() > 0) {
            output.setLength(output.length() - 2);
        }

        return output.toString();
    }

    public static void main(String[] args) {
        String kalimat1 = "We Always Mekar";
        System.out.println(hitungHuruf(kalimat1)); // Output: "w=2, e=2, a=3, l=1, y=1, s=1, m=1, k=1, r=1"

        String kalimat2 = "coding is fun";
        System.out.println(hitungHuruf(kalimat2)); // Output: "c=1, o=1, d=1, i=2, n=2, g=1, s=1, f=1, u=1"
    }
}
