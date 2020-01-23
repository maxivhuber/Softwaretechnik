package Update;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

public class RestController {

    public static void httpRequest() throws IOException {
        URL url = new URL("https://api.exchangerate-api.com/v4/latest/USD");
        String readLine = null;
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpsURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/Währungen.json", false));
            writer.append(response.toString());
            writer.close();
        } else {
            System.out.println("Fehler: " + responseCode);
        }
    }

    public static String readData() throws IOException {
        String file = "src/main/resources/Währungen.json";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder builder = new StringBuilder();
        String currentLine = reader.readLine();

        while (currentLine != null) {
            builder.append(currentLine);
            currentLine = reader.readLine();
        }
        reader.close();
        return builder.toString();
    }

    public static void checkAge(){

    }
}
