package com.peguycode;

import com.peguycode.user.UserFakerDataAccessService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
        list.add(1);
        UserFakerDataAccessService fakerDataAccessService = new UserFakerDataAccessService();
        System.out.println(fakerDataAccessService.getUsers());

    }
}
