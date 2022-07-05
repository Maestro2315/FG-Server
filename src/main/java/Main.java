import menuService.StartGameMenu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        StartGameMenu startGameMenu = new StartGameMenu();
        startGameMenu.startGame(2);

//          StartGameMenu startGameMenu = new StartGameMenu();
//          startGameMenu.chooseDevice();


//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://random-word-form.herokuapp.com/random/adjective")).build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        String adj = response.body();
//        System.out.println(adj);
    }

}
