package window;

import characters.Persona;

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
    private JButton ButtonAttack;
    private JPanel PanelPlayer;
    private JPanel PanelButtons;
    private JLabel PlayerStats;
    private JLabel PlayerImageLabel;
    private JLabel EnemyImageLabel;
    private JTextArea EnemyStatsTextArea;
    private JTextArea PlayerStatsTextArea;
    private BufferedImage img = null;

    private int count;

    public CombatWindow() {
        Persona testCharacter = new Persona();
        count = 0;
        ButtonAttack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                showImage(count);
//                count++;
//                if(count>2){count = 0;}
                PlayerStatsTextArea.setText("\n\n\n");
                EnemyStatsTextArea.setText("\n\n\n");
                for(String line: testCharacter.getStatsList()) {
                    EnemyStatsTextArea.append("\t" + line + "\n");
                    PlayerStatsTextArea.append("\t" + line + "\n");
                    showImage(3);
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
        Image image = icon.getImage().getScaledInstance(400, 275, Image.SCALE_SMOOTH);
        PlayerImageLabel.setIcon(new ImageIcon(image));
        EnemyImageLabel.setIcon(new ImageIcon(image));
    }
    public void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
                SwingUtilities.isEventDispatchThread());
        URL iconURL = getClass().getResource("/favicon/TTfavicon.png");
        ImageIcon icon = new ImageIcon(iconURL);
        JFrame frame = new JFrame("Tallest Tower Build 1.5");
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(PanelCombatMain);

        frame.pack();
        frame.setVisible(true);
    }
}