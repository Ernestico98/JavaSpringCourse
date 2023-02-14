package org.example;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        var formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        var time = java.time.LocalTime.now().format(formatter);

        System.out.println("Current time: " + time);
    }
}