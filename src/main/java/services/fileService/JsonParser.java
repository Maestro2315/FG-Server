package services.fileService;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import modules.DevicesConfig;
import modules.FightersConfig;
import java.io.File;
import java.io.IOException;

public class JsonParser {
    /**
     * Метод читающий джсон обьект
     **/
    /**
     * @return Возвращяет лист всех бойцов
     **/
    public FightersConfig getFighterConfig() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        return objectMapper.readValue(new File("src\\main\\resources\\Fighter.json"), FightersConfig.class);
    }

    public DevicesConfig getDevicesConfig() throws IOException {
      ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
      return objectMapper.readValue(new File("src\\main\\resources\\items.json"), DevicesConfig.class);
    }
}
