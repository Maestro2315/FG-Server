package menuService;

import modules.Devices;

import modules.Fighter;
import services.fileService.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StartGameMenu {

    private final Scanner sc = new Scanner(System.in);
    private final JsonParser jsonObj = new JsonParser();

    /**
     * Метод показывающий всех бойцов в консоли
     * с циклом для вывода имени бойца, его умения атаки и защиты
     */
    public void showFighter() throws IOException {
        List<Fighter> listFighters = jsonObj.getFighterConfig().getFighters();

        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (Fighter fighter : listFighters) {
            count += 1;
            stringBuilder.append(count).append(" Name: ").append(fighter.getName());
            stringBuilder.append("\n");
            stringBuilder.append("Attack skill: ").append(fighter.getAttackSkill());
            stringBuilder.append("\n");
            stringBuilder.append("Defence skill: ").append(fighter.getDefenceSkill());
            stringBuilder.append("\n");
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    /**
     * Метод выбора бойцов в консоли
     */
    public Fighter chooseFighter() throws IOException {
        showFighter();
        jsonObj.getFighterConfig();
        System.out.println("To choose fighter, enter him number");
        int numberFighter = sc.nextInt();
        List<Fighter> fighterList = new ArrayList<>(jsonObj.getFighterConfig().getFighters());
        System.out.println("U choose");
        return fighterList.get(numberFighter - 1);
    }

    public Fighter chooseBotFighter() throws IOException {
        Random random = new Random();
        System.out.println("Bot choose Fighter!");
        return jsonObj.getFighterConfig()
                .getFighters()
                .get(random.nextInt(jsonObj
                        .getFighterConfig()
                        .getFighters()
                        .size()));
    }

    public void showDevices() throws IOException {
        List<Devices> devicesList = jsonObj.getDevicesConfig().getDevices();

        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (Devices devices : devicesList) {
            count += 1;
            stringBuilder.append(count).append(" Name: ").append(devices.getName());
            stringBuilder.append("\n");
            stringBuilder.append("Attack skill: ").append(devices.getAttack());
            stringBuilder.append("\n");
            stringBuilder.append("Defence skill: ").append(devices.getDefence());
            stringBuilder.append("\n");
            stringBuilder.append("\n");

        }
        System.out.println(stringBuilder);
    }

    public void startGame(int command) throws IOException {
        if (command == 2){
            chooseFighter();
            chooseDevice();
            chooseBotFighter();
            chooseBotDevice();
        }
    }


    public List<Devices> chooseDevice() throws IOException {
        showDevices();
        jsonObj.getDevicesConfig();
        System.out.println("To choose a devices enter they numbers");
        List<Devices> devicesList = new ArrayList<>(jsonObj.getDevicesConfig().getDevices());
        List<Devices> chooseDevices = new ArrayList<>();

        int ourDevices = 3;
        while (ourDevices != 0) {
            ourDevices -= 1;
            int numberOfDevices = sc.nextInt();
            chooseDevices.add(devicesList.get(numberOfDevices - 1));
        }
        System.out.println("U choose devices");
        return chooseDevices;
    }

    public List<Devices> chooseBotDevice() throws IOException {
        Random random = new Random();
        jsonObj.getDevicesConfig();
        List<Devices> devicesList = new ArrayList<>(jsonObj.getDevicesConfig().getDevices());
        List<Devices> chooseBot = new ArrayList<>();

        int botDevices = 3;
        while (botDevices != 0){
            botDevices -= 1;

            Devices botDeivces = devicesList.get(random.nextInt(jsonObj.getDevicesConfig().getDevices().size()));

            while (chooseBot.contains(botDeivces)){
                botDeivces = devicesList.get(random.nextInt(jsonObj.getDevicesConfig().getDevices().size()));
            }
            chooseBot.add(botDeivces);
        }
        System.out.println("Bot choose devices!");
        return chooseBot;
    }


}
