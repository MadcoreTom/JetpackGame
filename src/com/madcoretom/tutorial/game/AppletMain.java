package com.madcoretom.tutorial.game;

import javax.swing.*;

public class AppletMain extends JApplet
{
    private Game game;
    private Timer timer;

    public void start()
    {
        game = new Game(getWidth(), getHeight());
        add(new GamePanel(game));
        timer = new Timer(this, game, 25);
        timer.start();
    }

    public void stop()
    {
        timer.stop();
    }
}
