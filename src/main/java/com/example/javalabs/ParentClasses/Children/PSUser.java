package com.example.javalabs.ParentClasses.Children;

import com.example.javalabs.ParentClasses.GameScore;
import com.example.javalabs.ParentClasses.User;

public class PSUser extends User {
    
    public PSUser() {
        super();
        this._platform = "PS";
        this._gameStore = "PlayStation Store";
    }

    public PSUser(String inAccountName, String inIngameName,int inAchievements, String inGameStore, GameScore<Integer> inGameScore)
    {
        super(inAccountName, inIngameName, inAchievements, "PS", "PlayStation Store", inGameScore);
    }

    @Override
    public void set_gameStore(String inGameStore) {
        System.out.println("\nCannot change game store\n");
    }
}
