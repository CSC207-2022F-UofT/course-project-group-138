import entities.character.Entity;
import org.junit.Test;


public class EntityTests {

    private static Entity entity;

    public void initializeEntity() {
        entity = new Entity(0, 0);
    }

    /**
     * Tests getX() and getY()
     */
    @Test
    public void testGetters(){
        initializeEntity();
        assert entity.getX() == 0 : entity.getY() == 0;
    }

    /**
     * Tests setX() and setY()
     */
    @Test
    public void testSetters(){
        entity.setX(10);
        entity.setY(-5);
        assert entity.getX() == 10 : entity.getY() == -5;
    }

    /**
     * Tests changex() and changey()
     */
    @Test
    public void testChangers(){
        entity.changex(-100);
        entity.setY(1);
        assert entity.getX() == -90 : entity.getY() == -4;
    }
}
