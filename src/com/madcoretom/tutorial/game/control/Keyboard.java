package com.madcoretom.tutorial.game.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The singleton keyboard class
 */
public class Keyboard implements KeyListener
{
    private static Keyboard instance = new Keyboard();

    private boolean keyDown = false;
    private int code; // the key code of the key that was last pressed

    public static Keyboard getInstance()
    {
        return instance;
    }

    private Keyboard()
    {
        // Stop other people from instantiating it
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(!keyDown)
        {
            code = e.getKeyCode();
            keyDown = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == code)
        {
            // Only set keyDown to false if the key code matches
            keyDown = false;
        }
    }

    public boolean isKeyDown()
    {
        return keyDown;
    }
}
