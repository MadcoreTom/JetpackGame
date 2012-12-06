package com.madcoretom.tutorial.game;

import javax.swing.*;
import java.awt.*;

public class AppMain
{
    final private static String TITLE = "Game";
    final private static int WIDTH = 600;
    final private static int HEIGHT = 360;
    private static JFrame frame;


    public static void main(String[] args)
    {
        Game game = new Game(WIDTH, HEIGHT);

        frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Without setting this, the window will keep running in the background after being closed

        GamePanel gamePanel = new GamePanel(game);
        Dimension dim = new Dimension(WIDTH,HEIGHT);
        gamePanel.setMinimumSize(dim);
        gamePanel.setPreferredSize(dim);
        gamePanel.setMaximumSize(dim);
        frame.add(gamePanel);

        Timer timer = new Timer(frame, game, 25);

        frame.pack();
        frame.setVisible(true);

        timer.start();
    }
}
