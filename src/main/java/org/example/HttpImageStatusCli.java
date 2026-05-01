package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public static void askStatus() throws IOException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter HTTP status code: ");
            int code = scanner.nextInt();
            HttpStatusImageDownloader.downloadStatusImage(code);
            System.out.println("Status image successfully downloaded for code " + code);
            System.out.println("Filename: status_" + code + ".jpg");
        } catch(InputMismatchException e) {
            System.out.println("Please enter valid number");
            askStatus();
        } catch (StatusImageNotFoudError e) {
            System.out.println("There is not image for HTTP status code " + e.statusCode);
        } catch (StatusImageDownloadError | URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
