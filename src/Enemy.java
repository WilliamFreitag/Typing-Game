import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Enemy extends GamePiece{
	Queue<Character> healthBar = new LinkedList<Character>();
	public Enemy(Color color, Random rand, String possibleChars) {
		super(10+rand.nextInt(481),0,0,0,color);
		if(rand.nextInt(2) == 0) this.y = 500;
		for(int i = 0; i < rand.nextInt(3)+1; i++) {
			char current = possibleChars.charAt(rand.nextInt(possibleChars.length()));
			this.healthBar.add(current);
		}
	}
	
	public void update(Game game, PlayerInput playerInput, Random rand) {
		if(this.isCollidingWith(game.player)){game.gameOver = true; return;}
		switch(healthBar.peek()) {
		case 'a':
			if(playerInput.a)healthBar.remove();
			break;
		case 'b':
			if(playerInput.b)healthBar.remove();
			break;
		case 'c':
			if(playerInput.c)healthBar.remove();
			break;
		case 'd':
			if(playerInput.d)healthBar.remove();
			break;
		case 'e':
			if(playerInput.e)healthBar.remove();
			break;
		case 'f':
			if(playerInput.f)healthBar.remove();
			break;
		case 'g':
			if(playerInput.g)healthBar.remove();
			break;
		case 'h':
			if(playerInput.h)healthBar.remove();
			break;
		case 'i':
			if(playerInput.i)healthBar.remove();
			break;
		case 'j':
			if(playerInput.j)healthBar.remove();
			break;
		case 'k':
			if(playerInput.k)healthBar.remove();
			break;
		case 'l':
			if(playerInput.l)healthBar.remove();
			break;
		case 'm':
			if(playerInput.m)healthBar.remove();
			break;
		case 'n':
			if(playerInput.n)healthBar.remove();
			break;
		case 'o':
			if(playerInput.o)healthBar.remove();
			break;
		case 'p':
			if(playerInput.p)healthBar.remove();
			break;
		case 'q':
			if(playerInput.q)healthBar.remove();
			break;
		case 'r':
			if(playerInput.r)healthBar.remove();
			break;
		case 's':
			if(playerInput.s)healthBar.remove();
			break;
		case 't':
			if(playerInput.t)healthBar.remove();
			break;
		case 'u':
			if(playerInput.u)healthBar.remove();
			break;
		case 'v':
			if(playerInput.v)healthBar.remove();
			break;
		case 'w':
			if(playerInput.w)healthBar.remove();
			break;
		case 'x':
			if(playerInput.x)healthBar.remove();
			break;
		case 'y':
			if(playerInput.y)healthBar.remove();
			break;
		case 'z':
			if(playerInput.z)healthBar.remove();
			break;
		}
		if(healthBar.isEmpty()) {
			game.enemies.remove(this);
		}
		if(game.player.x > this.x)this.dx = 1;
		else if(game.player.x < this.x)this.dx = -1;
		else this.dx = 0;
		if(game.player.y > this.y)this.dy = 1;
		else if(game.player.y < this.y)this.dy = -1;
		else this.dy = 0;
		this.move();
		for(int i = 0; i < game.enemies.size()-1; i++) {
			if(game.enemies.get(i)!=this&& this.isCollidingWith(game.enemies.get(i))) {
				switch(rand.nextInt(4)) {
				case 0:
					this.x+=10;
					this.y+=10;
					break;
				case 1:
					this.x-=10;
					this.y-=10;
					break;
				case 2:
					this.x+=10;
					this.y-=10;
					break;
				case 3:
					this.x-=10;
					this.y+=10;
					break;
				}
				
			}
		}
	}
	
	public void drawNameTag(GraphicsContext gc) {
		gc.setFill(Color.RED);
		gc.fillText(this.healthBar.toString().replaceAll("[\\[\\],]", ""), this.x, this.y+10);
	}
}
