package tbpbotiket;

import java.util.Scanner;

public class SystemLogin {

    String correctUsername = "fajrinputra";
    String correctPassword = "jejeajabae18";

    public void login() {
        boolean isLoggedIn = false;
        boolean isCaptchaCorrect = false;
        Scanner scanner = new Scanner(System.in);

        while (!isLoggedIn) {
            System.out.print("Masukkan username: ");
            String inputUsername = scanner.nextLine();

            System.out.print("Masukkan password: ");
            String inputPassword = scanner.nextLine();

            if (loginSuccess(correctUsername, correctPassword, inputUsername, inputPassword)) {

                while (!isCaptchaCorrect) {
                    String captcha = generateCaptcha();
                    System.out.println("CAPTCHA: " + captcha);

                    System.out.print("Masukkan CAPTCHA: ");
                    String inputCaptcha = scanner.nextLine();

                    if (checkCaptcha(captcha, inputCaptcha)) {
                        System.out.println("Login berhasil!");
                        isLoggedIn = true;
                        isCaptchaCorrect = true;
                    } else {
                        System.out.println("Login gagal. (CAPTCHA salah) Silahkan Coba Lagi.");
                    }
                }

            } else {
                System.out.println("Login gagal. Periksa kembali username dan password.");
            }
        }
    }

    public boolean loginSuccess(String correctUsername, String correctPassword, String inputUsername,
            String inputPassword) {
        return correctUsername.equals(inputUsername) && correctPassword.equals(inputPassword);
    }

    public String generateCaptcha() {
        return "JK12fg4";
    }

    public boolean checkCaptcha(String correctCaptcha, String inputCaptcha) {
        return correctCaptcha.equalsIgnoreCase(inputCaptcha);
    }
}
