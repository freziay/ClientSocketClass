import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketClass {

    public static void main(String[] arg)  {

        Scanner scanner = new Scanner(System.in);
        String localhost = "127.0.0.1";
        int port = 8089;
        String write = "Write your name";
        String yes = "yes";
        String child = "Are you child? (yes/no)";

        metod(write,localhost, port);

        String input = scanner.nextLine();
        String name = input;
        String d = "Welcome to the kids area, " + name + " Let's play!";
        String i = "Welcome to the adult zone, " + name + " Have a good rest, or a good working day!";
        metod(child, localhost, port);
        String input1 = scanner.nextLine();
        if (input1.equals(yes)) {
            metod(d, localhost, port);

        } else {
            metod(i, localhost, port);
        }
    }

    public static void metod(String text, String localhost, int port) {
        try (Socket clientSocket = new Socket(localhost, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {

            out.println(text);
            String resp = in.readLine();
            System.out.println(resp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




