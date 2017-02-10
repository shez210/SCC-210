package engine2d;

import engine2d.behaviour.*;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

import java.util.ArrayList;
import java.util.Collections;

// This is the class that is used to instantiate every game object you want.
// There are some "create()" functions in the engine2d.World class, use them to instantiate.
public class GameObject
{
    public int type;
    public int status = Status.ALIVE.ordinal();
    public Sprite sprite;
    public ArrayList textures;
    public InputBehaviour input;
    public MotionBehaviour motion;
    public AIBehaviour ai;
    public StatsBehaviour stats;
    public ArrayList<Boolean> abilities;
    public ArrayList<AnimationBehaviour> anims;
    public AnimationStateBehaviour animState;


    public enum Ability{ MOVE_LEFT, MOVE_RIGHT, MOVE_UP, MOVE_DOWN, MOVE_ATTACK }
    public enum Type{ PLAYER_BULLET, ENEMY }
    public enum Status{ ALIVE, DEAD }

    // engine2d.GameObject is created by instantiating all the needed components/behaviours.
    public GameObject()
    {
        sprite = new Sprite();
        textures = new ArrayList();
        abilities = new ArrayList<>( Collections.nCopies( Ability.values().length, false ) );
        anims = new ArrayList<>( Collections.nCopies( Ability.values().length, null ) );
    }

    void update()
    {
        if( input != null ) { input.update(); } // If the engine2d.GameObject is controlled by input, handle the input.
        if( motion != null ) { motion.update(); } // If the engine2d.GameObject can move, then move it.
        if( animState != null ) { animState.update(); } // If the engine2d.GameObject supports animation, update it.
        if( ai != null ) { ai.update(); }
    }

    boolean hasMotion()
    {
        return motion != null;
    }

    void addBehaviour( AnimationBehaviour anim, int abilityIndex )
    {
        this.anims.set( abilityIndex, anim );
    }

    void addBehaviour( AnimationBehaviour anim )
    {
        this.anims.add( anim );
    }

    void addBehaviour( AnimationStateBehaviour animState )
    {
        this.animState = animState;
    }

    void addBehaviour( InputBehaviour input )
    {
        this.input = input;
    }

    void addBehaviour( MotionBehaviour motion )
    {
        this.motion = motion;
    }

    void addBehaviour( AIBehaviour ai )
    {
        this.ai = ai;
    }

    void addBehaviour( StatsBehaviour stats )
    {
        this.stats = stats;
    }

    void addTexture( Texture texture )
    {
        sprite.setTexture( texture );
        sprite.setOrigin( new Vector2f( sprite.getGlobalBounds().width/2.0f, sprite.getGlobalBounds().height/2.0f ) );
    }

    void addArrayOfTextures( ArrayList<Texture> textures )
    {
        this.textures = textures;
    }
}
