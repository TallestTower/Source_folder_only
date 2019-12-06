package window;

import characters.Role;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class CombatWindow {
    private JPanel PanelCombatMain;
    private JPanel PanelCombatants;
    private JPanel PanelStats;
    private JButton AbilityBtn1;
    private JPanel PanelPlayer;
    private JPanel PanelButtons;
    private JLabel PlayerStats;
    private JLabel PlayerCharacter1Label;
    private JLabel PlayerCharacter2Label;
    private JTextArea EnemyStatsTextArea;
    private JTextArea PlayerStatsTextArea;
    private JButton AbilityBtn2;
    private JButton AbilityBtn3;
    private JButton AbilityBtn4;
    private JTextArea AbilityTextArea;
    private JLabel InitiativePlayerLabel;
    private JLabel TargetedEnemyLabel;
    private JLabel PlayerCharacter4Label;
    private JLabel PlayerCharacter3Label;
    private JPanel EnemyPanel;
    private JLabel EnemyCharacter1Label;
    private JLabel EnemyCharacter2Label;
    private JLabel EnemyCharacter3Label;
    private JLabel EnemyCharacter4Label;
    private JButton playerBtn1;
    private JButton playerBtn2;
    private JButton playerBtn3;
    private JButton playerBtn4;
    private JButton enemyBtn5;
    private JButton enemyBtn6;
    private JButton enemyBtn7;
    private JButton enemyBtn8;
    private BufferedImage img = null;

    public CombatWindow(ArrayList<Role> playersIn, ArrayList<Role> enemiesIn) {
        ArrayList<Role> players = playersIn;
        ArrayList<Role> enemies = enemiesIn;
        AbilityBtn1.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
//                PlayerStatsTextArea.setText("\n\n\n");
//                EnemyStatsTextArea.setText("\n\n\n");
//                for(String line: testCharacter.getStatsList()) {
//                    EnemyStatsTextArea.append("\t" + line + "\n");
//                    PlayerStatsTextArea.append("\t" + line + "\n");
//                    showImage(3);
//                }
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/ability_icons/AttackIcon.png"));
                Image image = icon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
                AbilityBtn1.setIcon(new ImageIcon(image));
            }
        });
        AbilityBtn2.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/ability_icons/MultiAttackIcon.png"));
                Image image = icon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
                AbilityBtn2.setIcon(new ImageIcon(image));
            }
        });
        AbilityBtn3.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/ability_icons/BuffAttackIcon.png"));
                Image image = icon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
                AbilityBtn3.setIcon(new ImageIcon(image));
            }
        });
        AbilityBtn4.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/ability_icons/HealIcon.png"));
                Image image = icon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
                AbilityBtn4.setIcon(new ImageIcon(image));
            }
        });
        playerBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/role_icons/archer.png"));
                Image image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                playerBtn1.setIcon(new ImageIcon(image));
                InitiativePlayerLabel.setIcon(new ImageIcon(image));

                PlayerStatsTextArea.setText("\n\n");
                for(String line: playersIn.get(0).getStatsList()) {
                    PlayerStatsTextArea.append(" " + line + "\n");
                }
            }
        });
        playerBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/role_icons/cleric.png"));
                Image image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                playerBtn2.setIcon(new ImageIcon(image));
                InitiativePlayerLabel.setIcon(new ImageIcon(image));

                PlayerStatsTextArea.setText("\n\n");
                for(String line: playersIn.get(1).getStatsList()) {
                    PlayerStatsTextArea.append(" " + line + "\n");
                }
            }
        });
        playerBtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/role_icons/mage.png"));
                Image image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                playerBtn3.setIcon(new ImageIcon(image));
                InitiativePlayerLabel.setIcon(new ImageIcon(image));

                PlayerStatsTextArea.setText("\n\n");
                for(String line: playersIn.get(2).getStatsList()) {
                    PlayerStatsTextArea.append(" " + line + "\n");
                }
            }
        });
        playerBtn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/role_icons/warrior.png"));
                Image image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                playerBtn4.setIcon(new ImageIcon(image));
                InitiativePlayerLabel.setIcon(new ImageIcon(image));

                PlayerStatsTextArea.setText("\n\n");
                for(String line: playersIn.get(3).getStatsList()) {
                    PlayerStatsTextArea.append(" " + line + "\n");
                }
            }
        });
        enemyBtn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        enemyBtn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        enemyBtn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        enemyBtn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
    /**
     * https://www.youtube.com/watch?v=OTTIsOSzSts used to inspire image methods
     * @return
     */
    public String[] getImages(){
        File file = new File(String.valueOf(getClass().getResource("/images").getFile()));
        return file.list();
    }
    public void showImage(int indexIn){
        String[] imagesList = getImages();
        String imageName = imagesList[indexIn];
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/" + imageName));
        Image image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        PlayerCharacter1Label.setIcon(new ImageIcon(image));
        PlayerCharacter2Label.setIcon(new ImageIcon(image));
        PlayerCharacter3Label.setIcon(new ImageIcon(image));
        PlayerCharacter4Label.setIcon(new ImageIcon(image));
        EnemyCharacter1Label.setIcon(new ImageIcon(image));
        EnemyCharacter2Label.setIcon(new ImageIcon(image));
        EnemyCharacter3Label.setIcon(new ImageIcon(image));
        EnemyCharacter4Label.setIcon(new ImageIcon(image));
    }
    public void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
                SwingUtilities.isEventDispatchThread());
        URL iconURL = getClass().getResource("/favicon/TTfavicon.png");
        ImageIcon icon = new ImageIcon(iconURL);
        JFrame frame = new JFrame("Tallest Tower Build 2.0");
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(PanelCombatMain);

        frame.pack();
        frame.setVisible(true);
    }
}