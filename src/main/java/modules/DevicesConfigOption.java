package modules;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface DevicesConfigOption {

    void addItem(Devices devices) throws JsonProcessingException;
}
