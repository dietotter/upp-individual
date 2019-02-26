package com.company;

import model.Doctor;

public class DemoLogic {

    public static Doctor[] prepareDoctors() {
        Doctor[] arr = {
                new Doctor(0, "Вася", "Онколог", 2),
                new Doctor(1, "Петя", "Дерматолог", 3)
        };
        return arr;
    }
}
