import javafx.scene.paint.Color;

public class Player extends GamePiece{
	public Player(Color color) {
		super(250,250,0,0,color);
	}
	
	public void update(PlayerInput playerInput) {
		if(playerInput.up) this.dy =-5;
		else if(playerInput.down) this.dy = 5;
		else this.dy = 0;
		
		if(playerInput.left) this.dx =-5;
		else if(playerInput.right) this.dx =5;
		else this.dx = 0;
		
		this.move();
	}
}
