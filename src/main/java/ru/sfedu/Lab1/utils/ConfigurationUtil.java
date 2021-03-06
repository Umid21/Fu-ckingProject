package ru.sfedu.Lab1.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static ru.sfedu.Lab1.Constants.DEFAULT_CONFIG_PATH;
import static ru.sfedu.Lab1.Constants.SYS_ENV_KEY;

/**
 * Configuration utility. Allows to get configuration properties from the
 * default configuration file
 *
 * @author Boris Jmailov
 */
public class ConfigurationUtil {


    private static final String CONFIG_PATH = System.getProperty(SYS_ENV_KEY, DEFAULT_CONFIG_PATH);

    private static final Properties configuration = new Properties();

    /**
     * Hides default constructor
     */
    public ConfigurationUtil() {
    }

    private static Properties getConfiguration() throws IOException {
        if (configuration.isEmpty()) {
            loadConfiguration();
        }
        return configuration;
    }


    /**
     * Loads configuration from <code>DEFAULT_CONFIG_PATH</code>
     *
     * @throws IOException In case of the configuration file read failure
     */
    private static void loadConfiguration() throws IOException {
        File nf = new File(CONFIG_PATH);
        System.out.println(nf);
        try (InputStream in = new FileInputStream(nf) // DEFAULT_CONFIG_PATH.getClass().getResourceAsStream(DEFAULT_CONFIG_PATH);
        ) {
            configuration.load(in);
        } catch (IOException ex) {
            throw new IOException(ex);
        }
    }

    /**
     * Gets configuration entry value
     *
     * @param key Entry key
     * @return Entry value by key
     * @throws IOException In case of the configuration file read failure
     */

    public static String getConfigurationEntry(String key) throws IOException {
        return getConfiguration().getProperty(key);
    }

}