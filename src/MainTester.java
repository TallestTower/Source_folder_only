import characters.*;
import window.CombatWindow;

import javax.swing.*;
import java.util.ArrayList;

public class MainTester {

    public static void main(String[] args) {
        System.out.println("Program Start!");
        //TODO add two ArrayList params to combat window
        ArrayList<Role> players = new ArrayList<>();
        players.add(new Warrior());
        players.add(new Archer());
        players.add(new Mage());
        players.add(new Cleric());
        ArrayList<Role> enemies = new ArrayList<>();
        enemies.add(new Cleric());
        enemies.add(new Archer());
        enemies.add(new Archer());
        enemies.add(new Archer());
        CombatWindow attack = new CombatWindow(players, enemies);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                attack.createAndShowGUI();
            }
        });
    }
}