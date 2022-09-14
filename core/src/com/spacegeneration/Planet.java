package com.spacegeneration;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

public class Planet
{
    ShapeRenderer shapeRenderer;
    SpriteBatch batch;
    Texture planetTexture1 = new Texture("genericPlanet1.png");
    Texture planetTexture2 = new Texture("genericPlanet2.png");
    Texture planetTexture3 = new Texture("genericPlanet3.png");
    Sprite planet;
    Random rand;
    int randomX;
    int randomY;
    int randomRadius;
    boolean twinkle;
    //Constructor for the class. Generates random numbers to determine how the planet looks,
    // the size of the planet, where it is on the screen, and possibly if it twinkles. (Might be used for moon)
    public Planet()
    {
        batch = new SpriteBatch();
        rand = new Random();
        switch(rand.nextInt(3) + 1)
        {
            case 1:
                planet = new Sprite(planetTexture1);
                break;
            case 2:
                planet = new Sprite(planetTexture2);
                break;
            case 3:
                planet = new Sprite(planetTexture3);
                break;
            default:
                System.out.println("This is a bug!");
                break;
        }
        randomX = rand.nextInt(Gdx.graphics.getWidth());
        randomY = rand.nextInt(Gdx.graphics.getHeight());
        randomRadius = rand.nextInt(3) + 1;
        //twinkle = rand.nextBoolean();

    }

    //Renderer method
    public void planetRenderer()
    {
        batch.begin();
        planet.draw(batch);
        planet.setSize(50 * randomRadius, 50 * randomRadius);
        planet.setPosition(randomX, randomY);
        planet.setOrigin(25 * randomRadius, 25 * randomRadius);
        batch.end();
    }

    //Disposal method.
    public void planetDispose()
    {
        batch.dispose();
    }
}

