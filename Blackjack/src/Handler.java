
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author 222003038
 */
public class Handler {
    LinkedList<CardObject> object;
    private Random r = new Random();

    public Handler() {
        this.object = new LinkedList<CardObject>();
    }
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			CardObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			//GameObject tempObject = object.get(i);
			
			object.get(i).render(g);
		}
                //System.out.println(object.size());
	}
	
	public void addObject(CardObject object) {
		this.object.add(object);
	}
	
	public void removeObject(CardObject object) {
		this.object.remove(object);
	}
        public CardObject getRandom(){
            return object.get(r.nextInt(object.size()));
        }
}
