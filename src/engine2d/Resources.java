package engine2d;

import org.jsfml.graphics.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

/** Holds all game content (textures, sounds, music, fonts, etc). */
public class Resources
{
    public ArrayList<Texture> textures = new ArrayList<>();
    public Font font= new Font();
    public Sprite cursorSprite;
    // Precache resources (only sprites and fonts for now).
    public Resources()
    {
        /**
        * Every time loadSpriteSheet() is called, a new element is added into the textures array.
        * So if you want to get the texture that you loaded the 2nd time you called loadSpriteSheet(), then you
        * Need to use game.resources.texture.get( 1 ), to access the 2nd texture.
        * The 2nd parameter is the background color of the sprite sheet.
        * You need to be really precise when specifying it or background wont be blended. */
        loadSpriteSheet( "sprites/player_running.png", new Color( 255, 254 ,254 ) );
        loadSpriteSheet( "sprites/placeholder_sprite.png", Color.WHITE ); // Color.WHITE is 255 255 255
        loadSpriteSheet( "sprites/chest_sprite.png", Color.WHITE );
        loadSpriteSheet( "sprites/bullet.png", Color.WHITE );
        loadSpriteSheet( "sprites/cursor.png", Color.WHITE );
        loadSpriteSheet( "sprites/placeholder_tile.png", Color.WHITE );
        // If you want to call loadSpriteSheet(), do it HERE, not before the other function calls.
        // load sprite sheet here.

        loadSpriteSheet ( "sprites/Images/Backgrounds/deathscroll.png" );
        loadSpriteSheet("sprites/Images/Buttons/Options.png");

        loadFont( "font.ttf" );


        //Set the cursor stuff.
        cursorSprite = new Sprite( textures.get( 4 ) );
        cursorSprite.setScale( 0.47f, 0.47f );
    }





    /** Loads sprite sheet
     * @param path the relative path to the file.
      TODO: 2 constructors, one without color */
    public void loadSpriteSheet( String path, Color color )
    {
        Image img = new Image();
        try{ img.loadFromFile( Paths.get( path ) ); }
        catch ( IOException e ) { e.printStackTrace(); }
        img.createMaskFromColor( color, 0 );
        Texture tex = new Texture();
        try { tex.loadFromImage( img ); }
        catch ( TextureCreationException e )
        { e.printStackTrace(); }
        textures.add( tex );
    }

    /** Loads sprite sheet
     * @param path the relative path to the file.
     */
    public void loadSpriteSheet( String path)
    {
        Image img = new Image();
        try{ img.loadFromFile( Paths.get( path ) ); }
        catch ( IOException e ) { e.printStackTrace(); }
        Texture tex = new Texture();
        try { tex.loadFromImage( img ); }
        catch ( TextureCreationException e )
        { e.printStackTrace(); }
        textures.add( tex );
    }


    /** Loads a font at the specified path.
     * @param path the path to the font.
     */
    public void loadFont( String path )
    {
        try{ font.loadFromFile( Paths.get( path ) ); }
        catch( IOException e ) { e.printStackTrace(); }
    }

}
