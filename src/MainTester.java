import window.CombatWindow;

import javax.swing.*;

public class MainTester {
    public static void main(String[] args){
        System.out.println("Program Start!");
        CombatWindow attack = new CombatWindow();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                attack.createAndShowGUI();
            }
        });
    }

}
