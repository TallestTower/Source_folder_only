import characters.*;
import window.CombatWindow;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class MainTester {

    public static void main(String[] args) {
        Random numforRandomEnemies = new Random();
        System.out.println("Program Start!");
        ArrayList<Role> players = new ArrayList<>();
        int temp;

        //We do not have a character selector menu (yet). Instead, swap out one of the following for these classes: Warrior, Mage, Cleric, or Archer.
        players.add(new Warrior());
        players.add(new Mage());
        players.add(new Cleric());
        players.add(new Archer());
        System.out.println("Generating starter characters.");
        ArrayList<Role> enemies = new ArrayList<>();
        for(int i = 0; i < 4; i++)
        {
            temp = numforRandomEnemies.nextInt(4);
            if(temp == 0)
            {
                enemies.add(new Warrior());
            }
            else if(temp == 1)
            {
                enemies.add(new Cleric());
            }
            else if (temp == 2)
            {
                enemies.add(new Mage());
            }
            else
            {
                enemies.add(new Archer());
            }
        }
        System.out.println("Populating starter enemies.");
        CombatWindow attack = new CombatWindow(players, enemies);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                attack.createAndShowGUI();
            }
        });
    }
}