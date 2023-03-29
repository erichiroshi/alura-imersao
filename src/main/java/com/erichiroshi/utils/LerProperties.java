package com.erichiroshi.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class LerProperties {

    public static String lerPropriedade(String prop) {
        Properties props = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/application.properties")) {
            props.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props.getProperty(prop);

    }
}
