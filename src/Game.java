import java.util.LinkedList;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Game{
	Boolean gameOver = false;
	Random rand = new Random();
	Player player = new Player(Color.WHITE);
	LinkedList<Enemy> enemies = new LinkedList<Enemy>(); 
	final String possibleChars = "abcdefghijklmnopqrstuvwxyz";
	public Game() {}
	
	public void update(PlayerInput playerInput) {
		if(rand.nextInt(70) == 0) enemies.add(new Enemy(Color.RED,rand,possibleChars));
		player.update(playerInput);
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).update(this, playerInput, rand);
		}
	}
	
	public void draw(GraphicsContext gc) {
		player.draw(gc);
		for(int i = 0; i < enemies.size(); i++) {
			//enemies.get(i).draw(gc); //draws a hitbox for the enemies if uncommented
			enemies.get(i).drawNameTag(gc);
		}
	}
}
