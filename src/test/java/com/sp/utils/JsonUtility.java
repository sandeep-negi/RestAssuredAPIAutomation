package com.sp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.constants.EnvType;
import com.sp.pojo.User;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUtility {
    public static User getUserData(String key) {
        /**
         *  ObjectMapper provides functionality for reading and writing JSON,
         *  either to and from basic POJOs (Plain Old Java Objects)
         */
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> userData = null;
        Map<String, User> mapUserData = new HashMap<>();
        File file;
        String env = System.getProperty("env", String.valueOf(EnvType.STAGE));
        switch (EnvType.valueOf(env)) {
            case PRE_PROD ->
                    file = new File(System.getProperty("user.dir") + "/src/test/resources/data/preprodUserData.json");
            case PROD -> file = new File(System.getProperty("user.dir") + "/src/test/resources/data/prodUserData.json");
            case STAGE -> file = new File(System.getProperty("user.dir") + "/src/test/resources/data/stageData.json");
            default -> throw new IllegalStateException("INVALID Env: " + env);
        }
        try {
            // Read JSON array from file
            userData = List.of(objectMapper.readValue(file, User[].class));
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }

        boolean flag = false;
        assert userData != null;
        for (User user : userData) {
            if (user.getTestId() != null && user.getTestId().equalsIgnoreCase(key)) {
                flag = true;
                mapUserData.put(user.getTestId(), user);
            }
        }
        if (flag) {
            return mapUserData.get(key);
        } else {
            return null;
        }
    }
}
