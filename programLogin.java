import java.util.Scanner;

public class programLogin {

    public static void main(String[] args) {
        String username = "fajrinputra";
        String password = "jejeajabae18";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Masukkan password: ");
        String inputPassword = scanner.nextLine();

        if (login(username, password, inputUsername, inputPassword)) {
            String captcha = generateCaptcha();
            System.out.println("CAPTCHA: " + captcha);

            System.out.print("Masukkan CAPTCHA: ");
            String inputCaptcha = scanner.nextLine();

            if (checkCaptcha(captcha, inputCaptcha)) {
                System.out.println("Login berhasil!");
            } else {
                System.out.println("Login gagal. CAPTCHA salah.");
            }
        } else {
            System.out.println("Login gagal. Periksa kembali username dan password.");
        }
        scanner.close();
    }

    private static boolean login(String correctUsername, String correctPassword, String inputUsername,
            String inputPassword) {
        return correctUsername.equals(inputUsername) && correctPassword.equals(inputPassword);
    }

    private static String generateCaptcha() {
        return "JK12fg4";
    }

    private static boolean checkCaptcha(String correctCaptcha, String inputCaptcha) {
        return correctCaptcha.equalsIgnoreCase(inputCaptcha);
    }
}
