package com.spacegeneration;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Moon extends Planet
{
    Texture MoonTexture1 = new Texture("moonGif.gif");
    Texture MoonTexture2 = new Texture("genericMoon2.png");
    Texture MoonTexture3 = new Texture("genericMoon3.png");

    public Moon()
    {
        batch = new SpriteBatch();
        rand = new Random();
        switch(rand.nextInt(3) + 1)
        {
            case 1:
                planet = new Sprite(MoonTexture1);
                break;
            case 2:
                planet = new Sprite(MoonTexture2);
                break;
            case 3:
                planet = new Sprite(MoonTexture3);
                break;
            default:
                System.out.println("This is a bug!");
                break;
        }
        randomX = rand.nextInt(Gdx.graphics.getWidth());
        randomY = rand.nextInt(Gdx.graphics.getHeight());
        randomRadius = rand.nextInt(5) + 1;
    }
}
