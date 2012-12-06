package com.madcoretom.tutorial.game;

import java.awt.*;

public class Game
{
    private int width;
    private int height;

    private float angle = 0;

    public Game(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.GREEN);
        g.fillRect(5, 5, width - 10, height - 10);

        Point start = new Point(width / 2, height / 2);
        Point end = new Point(width / 2 + (int) (Math.sin(angle) * 100), height / 2 + (int) (Math.cos(angle) * 100));
        g.setColor(Color.BLACK);
        g.drawLine(start.x, start.y, end.x, end.y);
    }

    public void update(int time)
    {
        angle += time * 0.001;
        if (angle > Math.PI * 2)
        {
            angle -= (float) (Math.PI * 2);
        }
    }
}
