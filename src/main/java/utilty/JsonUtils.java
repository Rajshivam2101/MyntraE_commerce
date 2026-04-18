package utilty;

import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class JsonUtils {

    private static final String FILE_PATH =
            System.getProperty("user.dir")
                    + File.separator
                    + "src"
                    + File.separator
                    + "main"
                    + File.separator
                    + "resources"
                    + File.separator
                    + "userData.json";


    public static void updateMrNumber(String mrNumber) {

        try {
            // Read existing JSON
            FileReader reader = new FileReader(FILE_PATH);
            JSONObject root = new JSONObject(new JSONTokener(reader));
            reader.close();

            // Update MRNumber inside userData object
            root.getJSONObject("userData").put("MRNumber", mrNumber);

            // Write updated JSON back to file
            FileWriter writer = new FileWriter(FILE_PATH);
            writer.write(root.toString(4));
            writer.flush();
            writer.close();
            System.out.println("Updated MRNumber in JSON: " + mrNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
