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
import java.util.Random;

public class CombatWindow {
    private JPanel PanelCombatMain;
    private JPanel PanelCombatants;
    private JPanel PanelStats;
    private JButton AbilityBtn1;
    private JPanel PanelPlayer;
    private JPanel PanelButtons;
    private JLabel PlayerStats;
    private JTextArea TargetStatsTextArea;
    private JTextArea PlayerStatsTextArea;
    private JButton AbilityBtn2;
    private JButton AbilityBtn3;
    private JButton AbilityBtn4;
    private JTextArea AbilityTextArea;
    private JLabel InitiativePlayerLabel;
    private JLabel TargetLabel;
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
    private int activePlayer, activeEnemy, target, characterTurnCounter = 0;
    private ArrayList<Role> players;
    private ArrayList<Role> enemies;
    private ArrayList<Role> initiativeList;
    private ArrayList<JButton> abilityButtons;
    private boolean toggleAbility1, toggleAbility2, toggleAbility3, toggleAbility4;
    ArrayList<JButton> playerBtns;
    ArrayList<JButton> enemyBtns;
    ImageIcon icon = null;
    Image image;

    public CombatWindow(ArrayList<Role> playersIn, ArrayList<Role> enemiesIn){
        players = playersIn;
        enemies = enemiesIn;
        initiativeList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            initiativeList.add(players.get(i));
            initiativeList.add(enemies.get(i));
        }
        initiativeList.sort(Comparator.comparingInt(Role::getCurrentInitiative));
        playerBtns = new ArrayList<>();
        playerBtns.add(playerBtn1);
        playerBtns.add(playerBtn2);
        playerBtns.add(playerBtn3);
        playerBtns.add(playerBtn4);
        players.sort(Comparator.comparingInt(Role::getCurrentInitiative));
        enemyBtns = new ArrayList<>();
        enemyBtns.add(enemyBtn5);
        enemyBtns.add(enemyBtn6);
        enemyBtns.add(enemyBtn7);
        enemyBtns.add(enemyBtn8);
        enemies.sort(Comparator.comparingInt(Role::getCurrentInitiative));
        abilityButtons = new ArrayList<>();
        abilityButtons.add(AbilityBtn1);
        abilityButtons.add(AbilityBtn2);
        abilityButtons.add(AbilityBtn3);
        abilityButtons.add(AbilityBtn4);
        setAbility1(false);
        setAbility2(false);
        setAbility3(false);
        setAbility4(false);

        setActivePlayer(0);
        setActiveEnemy(0);


        for (int i = 0; i < 4; i++) {
            icon = new ImageIcon(getClass().getResource(players.get(i).getIcon()));
            image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
            playerBtns.get(i).setIcon(new ImageIcon(image));
            players.get(i).setPlayerOwned(true);
        }
        for (int j = 0; j < 4; j++) {
            icon = new ImageIcon(getClass().getResource(enemies.get(j).getIcon()));
            image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
            enemyBtns.get(j).setIcon(new ImageIcon(image));
            enemies.get(j).setPlayerOwned(false);
        }
        icon = new ImageIcon(getClass().getResource(players.get(getActivePlayer()).getIcon()));
        image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        InitiativePlayerLabel.setIcon(new ImageIcon(image));
        PlayerStatsTextArea.setText("\n\n");
        for (String line : players.get(getActivePlayer()).getStatsList()) {
            PlayerStatsTextArea.append(" " + line + "\n");
        }
/*        for(int i = 0; i < 4; i++)
        {
            icon = new ImageIcon(getClass().getResource(players.get(getTarget()).getAbilities().get(i).getIconLocation()));
            image = icon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
            abilityButtons.get(i).setIcon(new ImageIcon(image));
        }*/
        setAbilityIcons();
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
                setTarget(0);
                displayTarget(0, players);
            }
        });
        playerBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setTarget(1);
                displayTarget(1, players);
            }
        });
        playerBtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setTarget(2);
                displayTarget(2, players);
            }
        });
        playerBtn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setTarget(3);
                displayTarget(3, players);
            }
        });
        enemyBtn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setTarget(0);
                displayTarget(0, enemies);
            }
        });
        enemyBtn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setTarget(1);
                displayTarget(1, enemies);
            }
        });
        enemyBtn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setTarget(2);
                displayTarget(2, enemies);
            }
        });
        enemyBtn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setTarget(3);
                displayTarget(3, enemies);
            }
        });
        EnterBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getAbility1()){
                    players.get(activePlayer).getAbilities().get(0).applyAbility(players.get(activePlayer), enemies.get(target));
                    AbilityTextArea.setText(players.get(activePlayer).getAbilities().get(0).whatHappened(players.get(activePlayer), enemies.get(target)));
                }
                else if(getAbility2()){
                    if(players.get(activePlayer).getClassType().equals("Cleric")){
                        players.get(activePlayer).getAbilities().get(1).applyAbility(players.get(activePlayer), players.get(target));
                        AbilityTextArea.setText(players.get(activePlayer).getAbilities().get(1).whatHappened(players.get(activePlayer), players.get(target)));
                    }
                    else if(players.get(activePlayer).getClassType().equals("Warrior")){
                        players.get(activePlayer).getAbilities().get(1).applyAbility(players.get(activePlayer), players);
                        AbilityTextArea.setText(players.get(activePlayer).getAbilities().get(1).whatHappened(players.get(activePlayer)));
                    }
                    else{
                        players.get(activePlayer).getAbilities().get(1).applyAbility(players.get(activePlayer), enemies);
                        AbilityTextArea.setText(players.get(activePlayer).getAbilities().get(1).whatHappened(players.get(activePlayer), enemies.get(target)));
                    }
                }
                else if(getAbility3()){
                    if(players.get(activePlayer).getClassType().equals("Mage")){
                        players.get(activePlayer).getAbilities().get(2).applyAbility(players.get(activePlayer), enemies.get(target));
                        AbilityTextArea.setText(players.get(activePlayer).getAbilities().get(2).whatHappened(players.get(activePlayer), enemies.get(target)));
                    }
                    else{
                        players.get(activePlayer).getAbilities().get(2).applyAbility(players.get(activePlayer), players.get(target));
                        AbilityTextArea.setText(players.get(activePlayer).getAbilities().get(2).whatHappened(players.get(activePlayer), players.get(target)));
                    }
                }
                else if(getAbility4()){
                    if(players.get(activePlayer).getClassType().equals("Cleric")){
                        players.get(activePlayer).getAbilities().get(3).applyAbility(players.get(activePlayer), players.get(target));
                        AbilityTextArea.setText(players.get(activePlayer).getAbilities().get(3).whatHappened(players.get(activePlayer), players.get(target)));
                    }
                    else{
                        players.get(activePlayer).getAbilities().get(3).applyAbility(players.get(activePlayer), enemies.get(target));
                        AbilityTextArea.setText(players.get(activePlayer).getAbilities().get(3).whatHappened(players.get(activePlayer), enemies.get(target)));
                    }
                }
                if(getAbility1() || getAbility2() || getAbility3() || getAbility4())
                {
                    characterTurnCounterIncrease();
                    setActivePlayer(getActivePlayer()+1);
                    displayInitiative(getActivePlayer());
                    if(!initiativeList.get(characterTurnCounter).getPlayerOwned())
                    {
                        aiTurn();
                    }
                }
                setAbility1(false);
                setAbility2(false);
                setAbility3(false);
                setAbility4(false);

            }

        });
    }
    /**
     * https://www.youtube.com/watch?v=OTTIsOSzSts used to inspire image methods
     * @return
     */
/*    public String[] getImages(){
        File file = new File(String.valueOf(getClass().getResource("/images").getFile()));
        return file.list();
    }
    public void showImage(int indexIn){
        String[] imagesList = getImages();
        String imageName = imagesList[indexIn];
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/" + imageName));
        Image image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
    }
    */
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
    public void setTarget(int indexIn){
        this.target = indexIn;
    }
    public int getTarget(){ return this.target;}
    public void displayTarget(int indexIn, ArrayList<Role> targetList){
        ImageIcon icon = new ImageIcon(getClass().getResource(targetList.get(indexIn).getIcon()));
        Image image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        TargetLabel.setIcon(new ImageIcon(image));
        TargetStatsTextArea.setText("\n\n");
        for (String line : targetList.get(getTarget()).getStatsList()) {
            TargetStatsTextArea.append(" " + line + "\n");
        }
    }

    public void displayInitiative(int indexIn){
        ImageIcon icon = new ImageIcon(getClass().getResource(players.get(indexIn).getIcon()));
        Image image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        InitiativePlayerLabel.setIcon(new ImageIcon(image));
        PlayerStatsTextArea.setText("\n\n");
        for (String line : players.get(indexIn).getStatsList()) {
            PlayerStatsTextArea.append(" " + line + "\n");
        }
    }
    public void setActivePlayer(int indexIn) {
        if(indexIn >=4)
        {
            indexIn = 0;
        }
        this.activePlayer = indexIn;
        setAbilityIcons();
    }
    public int getActivePlayer(){
        return this.activePlayer;
    }
    public void setActiveEnemy(int indexIn) {
        if(indexIn >=4)
        {
            indexIn = 0;
        }
        this.activeEnemy = indexIn;
    }
    public int getActiveEnemy(){
        return this.activeEnemy;
    }
    public boolean getAbility1(){ return toggleAbility1; }
    public boolean getAbility2(){ return toggleAbility2; }
    public boolean getAbility3(){ return toggleAbility3; }
    public boolean getAbility4(){ return toggleAbility4; }
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
    public void setAbilityIcons(){
        for(int i = 0; i < 4; i++)
        {
            ImageIcon icon = new ImageIcon(getClass().getResource(players.get(getActivePlayer()).getAbilities().get(i).getIconLocation()));
            Image image = icon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
            abilityButtons.get(i).setIcon(new ImageIcon(image));
        }
    }
    public boolean playerAlive()
    {
        boolean oneAlive = false;
        for(Role player: players){
            oneAlive = checkIfLive(player);
            if(oneAlive){break;}
        }
        return oneAlive;
    }
    public boolean enemyAlive()
    {
        boolean oneAlive = false;
        for(Role enemy: enemies){
            oneAlive = checkIfLive(enemy);
            if(oneAlive){break;}
        }
        return oneAlive;
    }

    public void endBattle()
    {
        if(!enemyAlive())
            AbilityTextArea.setText("All of your enemies have been vanquished.\nYou Rock, now close this window asap!");
        else if(!playerAlive()) {
             {
                 System.out.println("No, that was not a crash. It was intended.");
                System.out.println("You've led poorly. Your soldiers have all fallen.");
            }
            System.exit(0);
        }
    }

    public boolean checkIfLive(Role lifeChecker)
    {
        return lifeChecker.getIsAlive();
    }

    //"AI"
    public void aiTurn()
    {
        int randomAbility = randomNum();
        System.out.println(enemies.get(activeEnemy).getName() + " Ai ability: " + randomAbility);
        int randomTarget = randomNum();

        if(randomAbility == 0){
            enemies.get(activeEnemy).getAbilities().get(0).applyAbility(enemies.get(activeEnemy), players.get(randomTarget));
            AbilityTextArea.setText(enemies.get(activeEnemy).getAbilities().get(0).whatHappened(enemies.get(activeEnemy), players.get(randomTarget)));
        }
        else if(randomAbility == 1){
            if(enemies.get(activeEnemy).getClassType().equals("Cleric")){
                enemies.get(activeEnemy).getAbilities().get(1).applyAbility(enemies.get(activeEnemy), enemies.get(randomTarget));
                AbilityTextArea.setText(enemies.get(activeEnemy).getAbilities().get(1).whatHappened(enemies.get(activeEnemy), enemies.get(randomTarget)));
            }
            else if(enemies.get(activeEnemy).getClassType().equals("Warrior")){
                enemies.get(activeEnemy).getAbilities().get(1).applyAbility(enemies.get(activeEnemy), enemies);
                AbilityTextArea.setText(enemies.get(activeEnemy).getAbilities().get(1).whatHappened(enemies.get(activeEnemy), enemies.get(randomTarget)));
            }
            else{
                enemies.get(activeEnemy).getAbilities().get(1).applyAbility(enemies.get(activeEnemy), players);
                AbilityTextArea.setText(enemies.get(activeEnemy).getAbilities().get(1).whatHappened(enemies.get(activeEnemy), players.get(randomTarget)));
            }
        }
        else if(randomAbility == 2){
            if(enemies.get(activeEnemy).getClassType().equals("Mage")){
                enemies.get(activeEnemy).getAbilities().get(2).applyAbility(enemies.get(activeEnemy), players.get(randomTarget));
                AbilityTextArea.setText(enemies.get(activeEnemy).getAbilities().get(2).whatHappened(enemies.get(activeEnemy), players.get(randomTarget)));
            }
            else{
                enemies.get(activeEnemy).getAbilities().get(2).applyAbility(enemies.get(activeEnemy), enemies.get(randomTarget));
                AbilityTextArea.setText(enemies.get(activeEnemy).getAbilities().get(2).whatHappened(enemies.get(activeEnemy), enemies.get(randomTarget)));
            }
        }
        else if(randomAbility == 3) {
            if (enemies.get(activeEnemy).getClassType().equals("Cleric")) {
                enemies.get(activeEnemy).getAbilities().get(3).applyAbility(enemies.get(activeEnemy), enemies.get(randomTarget));
                AbilityTextArea.setText(enemies.get(activeEnemy).getAbilities().get(3).whatHappened(enemies.get(activeEnemy), enemies.get(randomTarget)));
            } else {
                enemies.get(activeEnemy).getAbilities().get(3).applyAbility(enemies.get(activeEnemy), players.get(randomTarget));
                AbilityTextArea.setText(enemies.get(activeEnemy).getAbilities().get(3).whatHappened(enemies.get(activeEnemy), players.get(randomTarget)));
            }
        }
        characterTurnCounterIncrease();
        setActiveEnemy(getActiveEnemy()+1);
        if(!initiativeList.get(characterTurnCounter).getPlayerOwned())
        {
            aiTurn();
        }
    }

    public int randomNum()
    {
        Random randomNum = new Random();
        return randomNum.nextInt(4);
    }

    public void characterTurnCounterIncrease()
    {
        for(int i = 0; i < 4; i++)
        {
            icon = new ImageIcon(getClass().getResource(players.get(i).getIcon()));
            image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
            this.playerBtns.get(i).setIcon(new ImageIcon(image));

            icon = new ImageIcon(getClass().getResource(enemies.get(i).getIcon()));
            image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
            this.enemyBtns.get(i).setIcon(new ImageIcon(image));
        }
        if(!enemyAlive() || !playerAlive()){
            endBattle();
        }
        characterTurnCounter++;
        if(characterTurnCounter > 7)
        {
            characterTurnCounter = 0;
        }
        if(!initiativeList.get(characterTurnCounter).getIsAlive()){

            characterTurnCounterIncrease();}
    }
}