package org.example.project;

import org.example.project.controller.AppController;
import org.example.project.presentation.AppMenu;
import org.example.project.service.AppService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AppRunner {
    public static void main(String[] args) {
        AppMenu appMenu = new AppMenu();
        AppService appService = new AppService(appMenu);
        AppController appController = new AppController(appMenu, appService);
        appController.run();
        List<Integer> i = new ArrayList<>();
        List<Integer> i2 = new LinkedList<>();
    }
}

