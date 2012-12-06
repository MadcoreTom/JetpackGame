package com.madcoretom.tutorial.game;

import java.awt.Component;

public class Timer implements Runnable
{
    private Game game;
    private Component component;
    private int delay;
    private Thread thread;
    boolean run;
    long lastTime;

    /**
     *
     * @param component the AWT component to repaint
     * @param game the game object
     * @param delay the delay between frames an updates (in milliseconds)
     */
    public Timer(Component component, Game game, int delay)
    {
        this.component = component;
        this.game = game;
        this.delay = delay;
        run = true;
    }

    public void start()
    {
        if (thread == null)
        {
            thread = new Thread(this);
            thread.setDaemon(true);
            thread.start();
        }
    }

    public void stop()
    {
        run = false;
        try
        {
            // Give the thread a second to stop before interrupting it
            thread.join(1000);
        }
        catch (InterruptedException e)
        {
            // Do nothing
        }
        if(!thread.isAlive())
        {
            thread.interrupt();
        }
    }

    @Override
    public void run()
    {
        try
        {
            lastTime = System.currentTimeMillis();
            while (run)
            {
                Thread.sleep(delay);
                long time = System.currentTimeMillis();
                game.update((int)(time - lastTime));
                component.repaint();

                lastTime = time;
            }
        }
        catch (InterruptedException e)
        {
            // Do nothing
        }
    }
}
