package com.spacegeneration;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class Star
{
    ShapeRenderer shapeRenderer;
    SpriteBatch batch;
    Random rand;
    int randomX;
    int randomY;
    int randomRadius;
    boolean twinkle;
    double rateOfTwinkle = 1000;
    double start = System.currentTimeMillis();
    double finish;
    double timeElapsed;
    //Star constructor. Generates a bunch of random numbers for the location, the radius of the star, as well as if it
    //twinkles or not.
    public Star()
    {
        shapeRenderer = new ShapeRenderer();
        rand = new Random();
        randomX = rand.nextInt(Gdx.graphics.getWidth());
        randomY = rand.nextInt(Gdx.graphics.getHeight());
        randomRadius = rand.nextInt(2) + 1;
        twinkle = rand.nextBoolean();
    }
    //Function is used for rendering the star in the main function.
    //Function keeps track of how long the star has appeared on screen, which will matter only if the
    //boolean twinkle is true or false.
    //Currently the stars use the LibGDX shape renderer, but in the future there is
    // a possbility to switch over to an actual sprite.
    public void starRenderer()
    {
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(1, 1, 1, 1);
        if (twinkle == true)
        {
            if ((timeElapsed % rateOfTwinkle) == 0)
            {
                randomRadius = rand.nextInt(2) + 1;
                shapeRenderer.circle(randomX, randomY, randomRadius);
            }else
            {
                shapeRenderer.circle(randomX, randomY, randomRadius);
            }

        }else
        {
            shapeRenderer.circle(randomX, randomY, randomRadius);
        }
        shapeRenderer.end();
        rateOfTwinkle = rand.nextInt(1000);
    }

    //This function is used for destroying the class in the main function.
    public void starDispose()
    {
        shapeRenderer.dispose();
    }
}
