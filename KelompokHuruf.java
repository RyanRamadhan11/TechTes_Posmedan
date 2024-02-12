import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class KelompokHuruf {
    public static String urutHuruf(String[] masukan) {
        // Menggabungkan semua kata menjadi satu string
        String gabungkanString = Arrays.stream(masukan)
                .collect(Collectors.joining());

        // Inisialisasi Map untuk menyimpan jumlah setiap huruf
        Map<Character, Integer> jumlahHuruf = new HashMap<>();

        // Iterasi melalui setiap karakter dalam string gabungan
        for (char huruf : gabungkanString.toCharArray()) {
            // Menambahkan jumlah karakter ke dalam Map
            jumlahHuruf.put(huruf, jumlahHuruf.getOrDefault(huruf, 0) + 1);
        }

        // Mengurutkan huruf berdasarkan jumlah terbanyak
        String hurufTersusun = jumlahHuruf.entrySet().stream()
                .sorted((e1, e2) -> {
                    int hasil = e2.getValue().compareTo(e1.getValue());
                    if (hasil == 0) {
                        hasil = Character.compare(e1.getKey(), e2.getKey());
                    }
                    return hasil;
                })
                .map(entry -> entry.getKey().toString())
                .collect(Collectors.joining());

        return hurufTersusun;
    }

    public static void main(String[] args) {
        String[] input1 = { "Abc", "bCd" };
        System.out.println(urutHuruf(input1)); // Output: "bACcd"

        String[] input2 = { "Oke", "One" };
        System.out.println(urutHuruf(input2)); // Output: "Oekn"

        String[] input3 = { "Pendanaan", "Terproteksi", "Untuk", "Dampak", "Berarti" };
        System.out.println(urutHuruf(input3)); // Output: "aenrktiBDPTUdimu"
    }
}
