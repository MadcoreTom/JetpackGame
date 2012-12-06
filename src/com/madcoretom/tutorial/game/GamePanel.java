package com.madcoretom.tutorial.game;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel
{
    private Game game;

    public GamePanel(Game game)
    {
        this.game = game;
    }
    public void paintComponent(Graphics g)
    {
        game.paint(g);
    }
}
