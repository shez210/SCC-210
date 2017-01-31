package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.Image;
import org.jsfml.graphics.Texture;
import org.jsfml.graphics.TextureCreationException;

/** Holds all game content (textures, sounds, music, fonts, etc). */
public class Resources {
	public ArrayList<Texture> textures = new ArrayList<>();
	public Font font = new Font();

	// Precache resources (only sprites and fonts for now).
	public Resources() {
		/**
		 * Every time loadSpriteSheet() is called, a new element is added into
		 * the textures array. So if you want to get the texture that you loaded
		 * the 2nd time you called loadSpriteSheet(), then you Need to use
		 * game.resources.texture.get( 1 ), to access the 2nd texture. The 2nd
		 * parameter is the background color of the sprite sheet. You need to be
		 * really precise when specifying it or background wont be blended.
		 */
		loadSpriteSheet("src/sprites/player_running.png", new Color(255, 254, 254));
		loadSpriteSheet("src/sprites/placeholder_sprite.png", Color.WHITE);
		loadSpriteSheet("src/sprites/chest_sprite.png", Color.WHITE);
		loadSpriteSheet("src/sprites/bullet.png", Color.WHITE);
		//loadSpriteSheet("src/sprites/cursor.png", Color.WHITE);
		// If you want to call loadSpriteSheet(), do it here, not before the
		// other function calls.
		// load sprite sheet here.

		loadFont("font.ttf");
	}

	/**
	 * Loads sprite sheet
	 * 
	 * @param path
	 *            the relative path to the file.
	 */
	public void loadSpriteSheet(String path, Color color) {
		final Image img = new Image();
		try {
			img.loadFromFile(Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		img.createMaskFromColor(color, 0);
		Texture tex = new Texture();
		try {
			tex.loadFromImage(img);
		} catch (TextureCreationException e) {
			e.printStackTrace();
		}
		textures.add(tex);
	}

	/**
	 * Loads a font at the specified path.
	 * 
	 * @param path
	 *            the path to the font.
	 */
	public void loadFont(String path) {
		try {
			font.loadFromFile(Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
