
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 *
 * @author 222003038
 */
public class CardObject {
    private CardType type;
    private CardSuit suit;
    private int value;
    private int x,y;
    private int velX, velY;
    private boolean visible;
    private String imgPath;
    BufferedImage img = null;
    
    public CardObject (CardType type,CardSuit suit, int x, int y,int velX, int velY, boolean visible){
        if (null != type) switch (type) {
            case Ace:
                this.value = 1;
                break;
            case Two:
                this.value = 2;
                break;
            case Three:
                this.value = 3;
                break;
            case Four:
                this.value = 4;
                break;
            case Five:
                this.value = 5;
                break;
            case Six:
                this.value = 6;
                break;
            case Seven:
                this.value = 7;
                break;
            case Eight:
                this.value = 8;
                break;
            case Nine:
                this.value = 9;
                break;
            case Ten:
                this.value = 10;
                break;
            case Jack:
                this.value = 10;
                break;
            case Queen:
                this.value = 10;
                break;
            case King:
                this.value = 10;
                break;
            default:
                break;
        }
        this.type = type;
        this.suit = suit;
        this.x = 100;
        this.y = 100;
        this.visible = visible;
        this.velX = velX;
        this.velY = velY;
        this.imgPath = "res/" + type.name() + suit.name() + ".png";
        try {
            img = ImageIO.read(new File(imgPath));
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
	return x;
    }
    public int getY() {
	return y;
    }
    public void setVelX(int velX) {
	this.velX = velX;
    }
    public void setVelY(int velY) {
        this.velY = velY;
    }
    public int getVelX() {
        return velX;
    }
    public int getVelY() {
	return velY;
    }
    public boolean getVisible(){
        return visible;
    }
    public void setVisible(boolean visible){
        this.visible = visible;
    }
    public void tick(){
        
    }
    public void render(Graphics g){
        if (visible == true){
        	g.setColor(Color.white);
        	g.fillRect(x-5, y-5, 232, 333);
            g.drawImage(img,x,y, null); 
        }
    }
}

