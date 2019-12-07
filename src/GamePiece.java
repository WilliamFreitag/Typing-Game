import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class GamePiece {
	int x = 0;
	int dx = 0;
	int y = 0;
	int dy = 0;
	Color color;
	public GamePiece(int x, int y, int dx, int dy, Color color) {
		this.x = x;
		this.dx = dx;
		this.y = y;
		this.dy = dy;
		this.color = color;
	}
	
	public void move() {
		this.x+=this.dx;
		this.y+=this.dy;
		if(this.x<=0)this.x=0;
		if(this.x>=490)this.x=490;
		if(this.y<=0)this.y=0;
		if(this.y>=490)this.y=490;	
	}
	
	public Boolean isCollidingWith(GamePiece otherPiece) {
		if((otherPiece.x >= this.x && otherPiece.x <= this.x+10)&&(otherPiece.y >= this.y && otherPiece.y <= this.y+10)) return true;
		if((otherPiece.x+10 >= this.x && otherPiece.x+10 <= this.x+10)&&(otherPiece.y+10 >= this.y && otherPiece.y+10 <= this.y+10)) return true;
		if((otherPiece.x+10 >= this.x && otherPiece.x+10 <= this.x+10)&&(otherPiece.y >= this.y && otherPiece.y <= this.y+10)) return true;
		if((otherPiece.x >= this.x && otherPiece.x <= this.x+10)&&(otherPiece.y+10 >= this.y && otherPiece.y+10 <= this.y+10)) return true;
		return false;
	}
	
	public void draw(GraphicsContext gc) {
		gc.setFill(this.color);
		gc.fillRect(this.x, this.y, 10, 10);
	}
}
