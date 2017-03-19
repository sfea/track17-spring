package track.container;

import java.io.*;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import track.container.config.Bean;
import track.container.config.ConfigReader;
import track.container.config.InvalidConfigurationException;

public class JsonConfigReader implements ConfigReader {

    @Override
    public List<Bean> parseBeans(File configFile) throws InvalidConfigurationException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Beans beans = new Beans();
        beans = mapper.readValue(configFile, Beans.class);
        return beans.beans;
    }

    public static void main(String[] strings) throws InvalidConfigurationException, IOException {
        File file = new File("config.json");
        JsonConfigReader js = new JsonConfigReader();
        System.out.println(js.parseBeans(file));
    }
}