package modules;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.List;

public interface FightersConfigOption {
    void addFighter(Fighter fighter) throws JsonProcessingException;

}
