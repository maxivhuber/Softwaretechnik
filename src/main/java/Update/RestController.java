package Update;

import Update.JsonClasses.Update;
import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RestController {
    
    public static void httpRequest() {

        try {
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
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Aktualisieren der Daten! Es werden veraltete benutzt!");
        }

    }

    public static String readData() {

        try {
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

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void checkAge() { //Request new data if data is older then 2 hours
        String data = readData();
        Update update = new Gson().fromJson(data, Update.class);
        long daten = Long.parseLong(update.getTime_last_updated());
        long daten_millis = daten * 1000;
        long now = System.currentTimeMillis();

        if (now - daten_millis > 7200000) { //7200000 == 2 hours
            httpRequest();
            System.out.println("requested new data");
        } else {
            System.out.println("Daten aktuell");
        }
    }
}
