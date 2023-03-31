package com.example.javalabs.ParentClasses.Children;

import com.example.javalabs.ParentClasses.GameScore;
import com.example.javalabs.ParentClasses.User;

public class XBOXUser extends User {
    
    public XBOXUser() {
        super();
        this._platform = "XBOX";
        this._gameStore = "Microsoft Store";
    }

    public XBOXUser(String inAccountName, String inIngameName, int inAchievements, String inGameStore, GameScore<Integer> inGameScore)
    {
        super(inAccountName, inIngameName, inAchievements, "XBOX", "Microsoft Store", inGameScore);
    }

    @Override
    public void set_gameStore(String inGameStore) {
        System.out.println("\nCannot change game store\n");
    }
}
