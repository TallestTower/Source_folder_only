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
import java.util.Comparator;

public class CombatWindow {
    private JPanel PanelCombatMain;
    private JPanel PanelCombatants;
    private JPanel PanelStats;
    private JButton AbilityBtn1;
    private JPanel PanelPlayer;
    private JPanel PanelButtons;
    private JLabel PlayerStats;
    private JTextArea EnemyStatsTextArea;
    private JTextArea PlayerStatsTextArea;
    private JButton AbilityBtn2;
    private JButton AbilityBtn3;
    private JButton AbilityBtn4;
    private JTextArea AbilityTextArea;
    private JLabel InitiativePlayerLabel;
    private JLabel TargetedEnemyLabel;
    private JPanel EnemyPanel;
    private JButton playerBtn1;
    private JButton playerBtn2;
    private JButton playerBtn3;
    private JButton playerBtn4;
    private JButton enemyBtn5;
    private JButton enemyBtn6;
    private JButton enemyBtn7;
    private JButton enemyBtn8;
    private JButton EnterBtn1;
    private JPanel PanelAbilityTextEnter;
    private BufferedImage img = null;
    private int activePlayer, activeEnemy, targetPlayer, targetEnemy;
    private ArrayList<Role> players;
    private ArrayList<Role> enemies;
    private ArrayList<JButton> abilityButtons;
    private boolean toggleAbility1, toggleAbility2, toggleAbility3, toggleAbility4;

    public CombatWindow(ArrayList<Role> playersIn, ArrayList<Role> enemiesIn) {
        players = playersIn;
        enemies = enemiesIn;
        ArrayList<JButton> playerBtns = new ArrayList<>();
        playerBtns.add(playerBtn1);
        playerBtns.add(playerBtn2);
        playerBtns.add(playerBtn3);
        playerBtns.add(playerBtn4);
        players.sort(Comparator.comparingInt(Role::getCurrentInitiative));
        ArrayList<JButton> enemyBtns = new ArrayList<>();
        enemyBtns.add(enemyBtn5);
        enemyBtns.add(enemyBtn6);
        enemyBtns.add(enemyBtn7);
        enemyBtns.add(enemyBtn8);
        enemies.sort(Comparator.comparingInt(Role::getCurrentInitiative));
        setActivePlayer(0);
        setActiveEnemy(0);
        abilityButtons = new ArrayList<>();
        abilityButtons.add(AbilityBtn1);
        abilityButtons.add(AbilityBtn2);
        abilityButtons.add(AbilityBtn3);
        abilityButtons.add(AbilityBtn4);
        setAbility1(false);
        setAbility2(false);
        setAbility3(false);
        setAbility4(false);

        ImageIcon icon = null;
        Image image;
        for (int i = 0; i < 4; i++) {
            icon = new ImageIcon(getClass().getResource(players.get(i).getIcon()));
            image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
            playerBtns.get(i).setIcon(new ImageIcon(image));
        }
        for (int j = 0; j < 4; j++) {
            icon = new ImageIcon(getClass().getResource(enemies.get(j).getIcon()));
            image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
            enemyBtns.get(j).setIcon(new ImageIcon(image));
        }
        icon = new ImageIcon(getClass().getResource(players.get(getActivePlayer()).getIcon()));
        image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        InitiativePlayerLabel.setIcon(new ImageIcon(image));
        PlayerStatsTextArea.setText("\n\n");
        for (String line : players.get(getActivePlayer()).getStatsList()) {
            PlayerStatsTextArea.append(" " + line + "\n");
        }
        for(int i = 0; i < 4; i++)
        {
            icon = new ImageIcon(getClass().getResource(players.get(getTargetPlayer()).getAbilities().get(i).getIconLocation()));
            image = icon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
            abilityButtons.get(i).setIcon(new ImageIcon(image));
        }

        AbilityBtn1.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                setAbility1(true);
                setAbility2(false);
                setAbility3(false);
                setAbility4(false);
                AbilityTextArea.setText(players.get(getActivePlayer()).getAbilities().get(0).toString());
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
                setAbility1(false);
                setAbility2(true);
                setAbility3(false);
                setAbility4(false);
                AbilityTextArea.setText(players.get(getActivePlayer()).getAbilities().get(1).toString());
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
                setAbility1(false);
                setAbility2(false);
                setAbility3(true);
                setAbility4(false);
                AbilityTextArea.setText(players.get(getActivePlayer()).getAbilities().get(2).toString());
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
                setAbility1(false);
                setAbility2(false);
                setAbility3(false);
                setAbility4(true);
                AbilityTextArea.setText(players.get(getActivePlayer()).getAbilities().get(3).toString());
            }
        });
        playerBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setTargetPlayer(0);
            }
        });
        playerBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setTargetPlayer(1);
            }
        });
        playerBtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setTargetPlayer(2);
            }
        });
        playerBtn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setTargetPlayer(3);
            }
        });
        enemyBtn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setTargetEnemy(0);
                ImageIcon icon = new ImageIcon(getClass().getResource(enemies.get(getTargetEnemy()).getIcon()));
                Image image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                TargetedEnemyLabel.setIcon(new ImageIcon(image));
                EnemyStatsTextArea.setText("\n\n");
                for (String line : enemies.get(getTargetEnemy()).getStatsList()) {
                    EnemyStatsTextArea.append(" " + line + "\n");
                }
            }
        });
        enemyBtn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setTargetEnemy(1);
                ImageIcon icon = new ImageIcon(getClass().getResource(enemies.get(getTargetEnemy()).getIcon()));
                Image image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                TargetedEnemyLabel.setIcon(new ImageIcon(image));
                EnemyStatsTextArea.setText("\n\n");
                for (String line : enemies.get(getTargetEnemy()).getStatsList()) {
                    EnemyStatsTextArea.append(" " + line + "\n");
                }
            }
        });
        enemyBtn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setTargetEnemy(2);
                ImageIcon icon = new ImageIcon(getClass().getResource(enemies.get(getTargetEnemy()).getIcon()));
                Image image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                TargetedEnemyLabel.setIcon(new ImageIcon(image));
                EnemyStatsTextArea.setText("\n\n");
                for (String line : enemies.get(getTargetEnemy()).getStatsList()) {
                    EnemyStatsTextArea.append(" " + line + "\n");
                }
            }
        });
        enemyBtn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setTargetEnemy(3);
                ImageIcon icon = new ImageIcon(getClass().getResource(enemies.get(getTargetEnemy()).getIcon()));
                Image image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                TargetedEnemyLabel.setIcon(new ImageIcon(image));
                EnemyStatsTextArea.setText("\n\n");
                for (String line : enemies.get(getTargetEnemy()).getStatsList()) {
                    EnemyStatsTextArea.append(" " + line + "\n");
                }
            }
        });
        EnterBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int j = 0; j < 4; j++) {
                    enemies.get(j).setCurrentHealth(0);
                }
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
    }
    public void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
                SwingUtilities.isEventDispatchThread());
        URL iconURL = getClass().getResource("/favicon/TTfavicon.png");
        ImageIcon icon = new ImageIcon(iconURL);
        JFrame frame = new JFrame("Tallest Tower Build 2.1");
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(PanelCombatMain);

        frame.pack();
        frame.setVisible(true);
    }
    public void setTargetPlayer(int indexIn){
        this.targetPlayer = indexIn;
    }
    public int getTargetPlayer(){ return this.targetPlayer;}
    public void setTargetEnemy(int indexIn){
        this.targetEnemy = indexIn;
    }
    public int getTargetEnemy(){ return this.targetEnemy;}
    public void setActivePlayer(int indexIn) {
        this.activePlayer = indexIn;
    }
    public int getActivePlayer(){
        return this.activePlayer;
    }
    public void setActiveEnemy(int indexIn) {
        this.activeEnemy = indexIn;
    }
    public int getActiveEnemy(){
        return this.activeEnemy;
    }
    public void setAbility1(boolean boolIn)
    {
        toggleAbility1 = boolIn;
    }
    public void setAbility2(boolean boolIn)
    {
        toggleAbility2 = boolIn;
    }
    public void setAbility3(boolean boolIn)
    {
        toggleAbility3 = boolIn;
    }
    public void setAbility4(boolean boolIn)
    {
        toggleAbility4 = boolIn;
    }
    public boolean playerAlive()
    {
        int healthPlayer = 0;
        for (int i = 0; i < 4; i++) {
            healthPlayer += players.get(i).getCurrentHealth();
        }
         return healthPlayer > 0;
    }
    public boolean enemyAlive()
    {
        int healthEnemy = 0;
        for (int i = 0; i < 4; i++) {
            healthEnemy += enemies.get(i).getCurrentHealth();
        }
        return healthEnemy > 0;
    }
}