package user;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class UserArrayDataAccessService implements UserDao {
    private static User[] users;

    public User[] getUsers() {
        String filePath = "src\\peguyscode\\users.csv";
        File file = new File(filePath);
        try{
            // count the number of lines in the csv
            int rowCounts = (int)Files.lines(Path.of(filePath)).count();
            // variables initialisation
            users = new User[rowCounts];
            String line;
            int counter = 0;

            // READ THE CSV and create/insert a neu user in the array
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                String[] lineSplitted = line.split(",");
               users[counter++] = new User(UUID.fromString(lineSplitted[0].trim()), lineSplitted[1].trim());
            }

        } catch (IOException  f){
            f.printStackTrace();
            f.getMessage();
        }

        return users;
    }

}
