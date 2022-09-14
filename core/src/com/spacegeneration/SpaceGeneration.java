package com.spacegeneration;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class SpaceGeneration extends ApplicationAdapter
{
	private OrthographicCamera camera;
	static Star stars[];
	int amountOfStars;
	int amountOfPlanets;
	static Planet planets[];
	static Moon moon;
	
	@Override
	//Main create method. The class starts off with how many stars and planets will appear.
	//Next the camera is created, and the arrays are created to allow for the stars and planets to render.
	public void create ()
	{
		amountOfStars = 500;
		amountOfPlanets = 3;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		stars = new Star[amountOfStars];
		planets = new Planet[amountOfPlanets];
		moon = new Moon();
		for (int i = 0; i < amountOfPlanets; i++)
		{
			planets[i] = new Planet();
		}
		for (int i = 0; i < amountOfStars; i++)
		{
			stars[i] = new Star();
		}
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		for (int i = 0; i < amountOfStars; i++)
		{
			stars[i].starRenderer();
		}
		for (int i = 0; i < amountOfPlanets; i++)
		{
			planets[i].planetRenderer();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.G))
		{
			stars = new Star[amountOfStars];
			for (int i = 0; i < amountOfStars; i++)
			{
				stars[i] = new Star();
			}
			for (int i = 0; i < amountOfPlanets; i++)
			{
				planets[i] = new Planet();
			}
			moon = new Moon();
		}
		moon.planetRenderer();
	}
	
	@Override
	public void dispose ()
	{
		for (int i = 0; i < amountOfPlanets; i++)
		{
			planets[i].planetDispose();
		}
		for (int i = 0; i < amountOfStars; i++)
		{
			stars[i].starDispose();
		}
		moon.planetDispose();
	}
}
