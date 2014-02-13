package com.me.mygdxgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture enemigo_texture;
    private Sprite sprite;
    private Sprite enemigo_sprite;
	int rotacion=0;
	
	@Override
	public void create()
	{		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		enemigo_texture = new Texture(Gdx.files.internal("data/marcial.png"));
		enemigo_texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(enemigo_texture, 0, 0, 512, 275);
		
		sprite = new Sprite(region);
		enemigo_sprite = new Sprite(region);
		enemigo_sprite.setPosition(0,-0.5f);
		enemigo_sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		enemigo_texture.dispose();
	}

	@Override
	public void render() {	
		sprite.setRotation(rotacion);
		
		
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
    	enemigo_sprite.draw(batch);
		batch.end();
		if(Gdx.input.isTouched())
		{
			rotacion++;
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
