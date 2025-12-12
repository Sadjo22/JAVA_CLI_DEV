package com.peguycode.user;

import java.io.*;
import java.util.List;
import java.util.UUID;

public class UserArrayDataAccessService implements UserDao {
    private static List<User> users;

    public List<User> getUsers() {
        //String filePath = "AbstractKeyword/src/peguyscode/users.csv";
        //        File file = new File(filePath);
        File file = new File(getClass().getClassLoader().getResource("users.csv").getPath());
        try{
            String line;
            int counter = 0;

            // READ THE CSV and create/insert a neu java.car.user in the array
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                String[] lineSplitted = line.split(",");
               users.add(new User(UUID.fromString(lineSplitted[0].trim()), lineSplitted[1].trim()));
            }

        } catch (IOException  f){
            f.printStackTrace();
            f.getMessage();
        }

        return users;
    }

}
