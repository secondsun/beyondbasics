package dev.secondsun.beyondbasics.annotations.examples.lint;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AMVProvider {

    private static final String PROPERTIES_FILE = "amv.properties";

    @AnimalMineralVegetable(AMVProvider.PROPERTIES_FILE)
    public static String getAMV(String amv) {
        Properties props = new Properties();
        try (InputStream fis = (AMVProvider.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE))) {
            props.load(fis);
            return props.getProperty(amv);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
