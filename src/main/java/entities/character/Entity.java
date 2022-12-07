package entities.character;

public class Entity {
    protected int x;
    protected int y;

    /**
     * === Constructors ===
     */
    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * === Getters and Setters ===
     */
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    /**
     * @param x - increment this Entity's y value by this amount
     */
    public void changex(int x) {
        this.x += x;
    }
    /**
     *
     * @param y- Increment this Entity's y value by this amount
     */
    public void changey(int y) {
        this.y += y;
    }

}
