package pl.code.accademy;

import pl.code.accademy.database.UserRepository;
import pl.code.accademy.gui.GUI;

public class Main {

    public static void main(String[] args) {

        UserRepository.connect();
        GUI.appController();
    }
}
