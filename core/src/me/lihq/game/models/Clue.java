package me.lihq.game.models;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import me.lihq.game.Assets;
import me.lihq.game.Settings;


/**
 * Defines the clues that the player needs to find in order to solve the murder.
 */
public class Clue extends Sprite
{
    /**
     * The name of the clue, set when you initialise the clue and gettable using {@link #getName()}
     */
    private String name;

    /**
     * The description of the clue, set when you initialise the clue and gettable using {@link #getDescription()}
     */
    private String description;

    /**
     * This is the location on the map in terms of tiles can be set using {@link #setTileCoordinates(int, int)}
     * Note: this is different to com.badlogic.gdx.graphics.g2d.Sprite.position that is the position on the screen in terms of pixels,
     * whereas this is in terms of map tiles relative to the bottom left of the map.
     */
    private Vector2Int tileCoordinates = new Vector2Int(0, 0);
    
    /**
     * True if clue is a murder weapon, otherwise false.
     * 
     * @author JAAPAN
     */
    private boolean murderWeapon = false;

    /**
     * Creates a clue
     *
     * @param name 			- The name of the clue i.e. what it is
     * @param description 	- Describes what the clue is
     * @param weapon		- Whether this clue is the murder weapon or not
     * @param clueX			- The column of the texture on the spritesheet
     * @param clueY			- The row of the texture on the spritesheet
     * 
     * @author JAAPAN
     */
    public Clue(String name, String description, boolean weapon, int clueX, int clueY)
    {
        super(new TextureRegion(Assets.CLUE_SHEET, (clueX * Settings.CLUE_SIZE), (clueY * Settings.CLUE_SIZE), Settings.CLUE_SIZE, Settings.CLUE_SIZE));
        this.name = name;
        this.description = description;
        this.murderWeapon = weapon;
    }
    
    /**
     * Checks equality of this Clue object and another object.
     *
     * @param obj - The clue object to test against
     * @return True if {@code obj} is of type Clue and has the same name
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Clue) {
            Clue c = (Clue) obj;
            return c.getName().equals(this.getName());
        }

        return false;
    }

    /**
     *
     * @return (String) The name of clue.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     *
     * @return (String) The description of the clue.
     */
    public String getDescription()
    {
        return this.description;
    }
    
    /**
     * 
     * @return True if this is the murder weapon, false otherwise
     * 
     * @author JAAPAN
     */
    public boolean isMurderWeapon(){
    	return this.murderWeapon;
    }
    
    /**
     * Sets this clue as the murder weapon.
     * 
     * @return (Clue) This object once it has been set as the murder weapon
     * 
     * @author JAAPAN
     */
    public Clue setMurderWeapon()
    {
    	this.murderWeapon = true;
    	
    	return this;
    }
    
    /**
     * Sets the tile coordinates of the clue in the map.
     *
     * @param v - The Vector2Int that the clue's tile coordinates are to be set to
     *          <p>
     *          All coordinates relative to the bottom left of the map
     *          </p>
     * @return (Clue) This object once the location has been updated
     */
    public Clue setTileCoordinates(Vector2Int v)
    {
        return setTileCoordinates(v.x, v.y);
    }

    /**
     * Sets the tile coordinates of the clue in the map.
     *
     * @param x - The x coordinate for where the clue is, in terms of tiles.
     * @param y - The y coordinate for where the clue is, in terms of tiles.
     *          <p>
     *          All coordinates relative to the bottom left of the map
     *          </p>
     * @return (Clue) this object
     */
    public Clue setTileCoordinates(int x, int y)
    {
        this.tileCoordinates.x = x;
        this.tileCoordinates.y = y;

        return this;
    }

    /**
     *
     * @return (Vector2Int) The tile coordinates of the clue
     *          <p>
     *          All coordinates relative to the bottom left of the map
     *          </p>
     */
    public Vector2Int getPosition()
    {
        return this.tileCoordinates;
    }

    /**
     *
     * @return (int) The x component of the clue's tile coordinates
     *          <p>
     *          All coordinates relative to the bottom left of the map
     *          </p>
     */
    public int getTileX()
    {
        return tileCoordinates.x;
    }

    /**
     *
     * @return (int) The y component of the clue's tile coordinates
     *          <p>
     *          All coordinates relative to the bottom left of the map
     *          </p>
     */
    public int getTileY()
    {
        return tileCoordinates.y;
    }

}
