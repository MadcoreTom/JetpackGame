package com.madcoretom.tutorial.game;

import com.madcoretom.tutorial.game.control.Keyboard;

import java.awt.*;

public class Game
{
    private int width;
    private int height;

    private final float GRAVITY = 0.2f;
    private static final int PLAYER_HEIGHT = 20;
    private static final int PLAYER_X = 40;
    private static final float THRUSTER_FORCE = -0.5f;
    private static final float BOUNCE_FACTOR = 0.25f;

    private float playerY = 0;
    private float playerVelocity = 0;

    public Game(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.WHITE);
        g.drawLine(0, height - 20, width, height - 20);

        // Draw an circle with the bottom at playerY and the middle at PLAYER_X
        g.drawOval(PLAYER_X - PLAYER_HEIGHT / 2, (int) (playerY) - PLAYER_HEIGHT, PLAYER_HEIGHT, PLAYER_HEIGHT);
    }

    public void update(int time)
    {
        playerVelocity += GRAVITY;

        if (Keyboard.getInstance().isKeyDown())
        {
            playerVelocity += THRUSTER_FORCE;
        }

        playerY += playerVelocity;
        int floor = height - 20;
        if (playerY > floor)
        {
            playerVelocity = -playerVelocity * BOUNCE_FACTOR;
            playerY = floor;
        }
    }
}
