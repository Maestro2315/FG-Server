package modules;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;

public class DevicesConfig implements DevicesConfigOption {

    private String name;
    private List<Devices> devicesList;

    public DevicesConfig(String name) {
        this.name = name;
        this.devicesList = new ArrayList<>();
    }

    public DevicesConfig() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDevicesList(List<Devices> devicesList) {
        this.devicesList = devicesList;
    }

    public List<Devices> getDevices() {
        return devicesList;
    }

    @Override
    public void addItem(Devices devices) throws JsonProcessingException {
        devicesList.add(devices);
    }



}
