
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;

/** Handles window initialization, settings, holds all resources and records input. */
public class Game
{
	public static final int SCREEN_WIDTH  = 640;
	public static final int SCREEN_HEIGHT = 480;

	private static final String TITLE = "Game";

	public static RenderWindow window;
	public static InputHandler inputHandler = new InputHandler();
	public static Resources resources = new Resources();
	public static Sprite cursorSprite;


	public Game()
	{
		initWindow();
	}

	public static void initWindow()
	{
		window = new RenderWindow();
		window.create( new VideoMode( SCREEN_WIDTH, SCREEN_HEIGHT ), TITLE, WindowStyle.DEFAULT );
		Game.window.setFramerateLimit( 120 ); // Avoid excessive updates
		Game.window.setMouseCursorVisible( false );
		cursorSprite = new Sprite( resources.textures.get( 4 ) );
		cursorSprite.setScale( 0.47f, 0.47f );
	}
	public int getScreenWidth(){
		return SCREEN_WIDTH;
	}
	public int getScreenHeight(){
		return SCREEN_HEIGHT;
	}
}