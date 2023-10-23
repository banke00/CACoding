package interface_adapter.clear_users;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

// TODO Complete me
public class ClearController {
    public ArrayList<String> clearUsers() {
        String filePath = "users.csv";
        ArrayList<String> clearedUsernames = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] cols = line.split(",");
                String username = cols[0];
                clearedUsernames.add(username);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading users file: " + e.getMessage(), e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("username,password,creation_time");
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Error clearing users: " + e.getMessage(), e);
        }

        return clearedUsernames;
    }
}