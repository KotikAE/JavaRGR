package com.example.javalabs.Interfaces;

import com.example.javalabs.ParentClasses.GameScore;

public interface MyInterface {
    
    String get_accountName();    
    String get_ingameName();
    int get_achievements();
    String get_platform();
    String get_gameStore();
    GameScore<Integer> get_gameScore();
}
