package com.sp.utils;


import com.sp.constants.EnvType;

import java.util.Properties;

import static com.sp.constants.EnvType.STAGE;

// Singleton Class -> One instance of this class [no other class can create object of this class rather than itself]
public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        String env = System.getProperty("env", String.valueOf(STAGE));
        switch (EnvType.valueOf(env)){
            case PRE_PROD -> properties = PropertyUtils.propertyLoader("src/test/resources/config/preprod_config.properties");
            case PROD -> properties = PropertyUtils.propertyLoader("src/test/resources//config/prod_config.properties");
            case STAGE -> properties = PropertyUtils.propertyLoader("src/test/resources/config/stage_config.properties");
            default -> throw new IllegalStateException("INVALID ENV: " + env);
        }
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getSetuBaseUrl(){
        String prop = properties.getProperty("setuBaseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("Property baseUrl is not specified in the config.properties file");
    }
    public String getSpotifyBaseUrl(){
        String prop = properties.getProperty("spotifyBaseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("Property baseUrl is not specified in the config.properties file");
    }
    public String getSplashBaseUrl(){
        String prop = properties.getProperty("splashBaseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("Property baseUrl is not specified in the config.properties file");
    }
    public String getSchoolServiceBaseUrl(){
        String prop = properties.getProperty("schoolServiceBaseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("Property School Service is not specified in the config.properties file");
    }
}
