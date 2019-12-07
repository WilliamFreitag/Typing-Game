import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{
  public static void main(String[] args){launch();}

  public void tick(Game currentGame, PlayerInput playerInput){
     currentGame.update(playerInput);
  }
  public void render(Game currentGame, GraphicsContext gc){
     gc.clearRect(0, 0, 500, 500);
     currentGame.draw(gc);
  }

  public void start(Stage stage){
     stage.setTitle("Typing Game");
     stage.setResizable(true);

     Group root = new Group();
     //creates the group object that will manage our main visual elements.
     Canvas canvas = new Canvas(500,500);
     /*
     / creates the canvas object that will manage our pixel placements on screen.
     /  - the integers in the canvas constructor call represent the canvas' dimension in pixels. form (x , y)
     */
     root.getChildren().add(canvas);
     //adds the canvas to root
     Scene scene = new Scene(root, Color.BLACK);
     /*
     / creates the scene object which will be used to render the root object onto the screen.
     / - The constructor takes a group that it will render onto the screen and a color for the background
     /     in areas of the screen that do not have anything else rendered onto them.
     */
     stage.setScene(scene);

     GraphicsContext gc = canvas.getGraphicsContext2D();
     //creates a graphics context for the canvas. This allows us to draw on the Canvas

     //tells the stage to use the scene as it's contents.
     PlayerInput playerInput = new PlayerInput();
     
     scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
      if(key.getCode() == KeyCode.A)playerInput.a = true;
      if(key.getCode() == KeyCode.B)playerInput.b = true;
      if(key.getCode() == KeyCode.C)playerInput.c = true;
      if(key.getCode() == KeyCode.D)playerInput.d = true;
      if(key.getCode() == KeyCode.E)playerInput.e = true;
      if(key.getCode() == KeyCode.F)playerInput.f = true;
      if(key.getCode() == KeyCode.G)playerInput.g = true;
      if(key.getCode() == KeyCode.H)playerInput.h = true;
      if(key.getCode() == KeyCode.I)playerInput.i = true;
      if(key.getCode() == KeyCode.J)playerInput.j = true;
      if(key.getCode() == KeyCode.K)playerInput.k = true;
      if(key.getCode() == KeyCode.L)playerInput.l = true;
      if(key.getCode() == KeyCode.M)playerInput.m = true;
      if(key.getCode() == KeyCode.N)playerInput.n = true;
      if(key.getCode() == KeyCode.O)playerInput.o = true;
      if(key.getCode() == KeyCode.P)playerInput.p = true;
      if(key.getCode() == KeyCode.Q)playerInput.q = true;
      if(key.getCode() == KeyCode.R)playerInput.r = true;
      if(key.getCode() == KeyCode.S)playerInput.s = true;
      if(key.getCode() == KeyCode.T)playerInput.t = true;
      if(key.getCode() == KeyCode.U)playerInput.u = true;
      if(key.getCode() == KeyCode.V)playerInput.v = true;
      if(key.getCode() == KeyCode.W)playerInput.w = true;
      if(key.getCode() == KeyCode.X)playerInput.x = true;
      if(key.getCode() == KeyCode.Y)playerInput.y = true;
      if(key.getCode() == KeyCode.Z)playerInput.z = true;
      if(key.getCode() == KeyCode.UP)playerInput.up = true;
      if(key.getCode() == KeyCode.DOWN)playerInput.down = true;
      if(key.getCode() == KeyCode.LEFT)playerInput.left = true;
      if(key.getCode() == KeyCode.RIGHT)playerInput.right = true;
      if(key.getCode() == KeyCode.SPACE)playerInput.space = true;
     });

     scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
    	 if(key.getCode() == KeyCode.A)playerInput.a = false;
         if(key.getCode() == KeyCode.B)playerInput.b = false;
         if(key.getCode() == KeyCode.C)playerInput.c = false;
         if(key.getCode() == KeyCode.D)playerInput.d = false;
         if(key.getCode() == KeyCode.E)playerInput.e = false;
         if(key.getCode() == KeyCode.F)playerInput.f = false;
         if(key.getCode() == KeyCode.G)playerInput.g = false;
         if(key.getCode() == KeyCode.H)playerInput.h = false;
         if(key.getCode() == KeyCode.I)playerInput.i = false;
         if(key.getCode() == KeyCode.J)playerInput.j = false;
         if(key.getCode() == KeyCode.K)playerInput.k = false;
         if(key.getCode() == KeyCode.L)playerInput.l = false;
         if(key.getCode() == KeyCode.M)playerInput.m = false;
         if(key.getCode() == KeyCode.N)playerInput.n = false;
         if(key.getCode() == KeyCode.O)playerInput.o = false;
         if(key.getCode() == KeyCode.P)playerInput.p = false;
         if(key.getCode() == KeyCode.Q)playerInput.q = false;
         if(key.getCode() == KeyCode.R)playerInput.r = false;
         if(key.getCode() == KeyCode.S)playerInput.s = false;
         if(key.getCode() == KeyCode.T)playerInput.t = false;
         if(key.getCode() == KeyCode.U)playerInput.u = false;
         if(key.getCode() == KeyCode.V)playerInput.v = false;
         if(key.getCode() == KeyCode.W)playerInput.w = false;
         if(key.getCode() == KeyCode.X)playerInput.x = false;
         if(key.getCode() == KeyCode.Y)playerInput.y = false;
         if(key.getCode() == KeyCode.Z)playerInput.z = false;
         if(key.getCode() == KeyCode.UP)playerInput.up = false;
         if(key.getCode() == KeyCode.DOWN)playerInput.down = false;
         if(key.getCode() == KeyCode.LEFT)playerInput.left = false;
         if(key.getCode() == KeyCode.RIGHT)playerInput.right = false;
         if(key.getCode() == KeyCode.SPACE)playerInput.space = false;
     });
     
     gc.setFill(Color.WHITE);
     gc.fillText("Typing Game", 215, 100);
     gc.fillText(">press space to start<", 194, 250);
     gc.fillText("Instructions:", 50, 400);
     gc.fillText("> If an enemy touches you, you lose!", 50, 415);
     gc.fillText("> Type an enemy's name to neutralize it", 50, 430);
     gc.fillText("> Use the Arrow keys to move around the screen", 50, 445);
     
     new AnimationTimer(){
     //begins the game loop.
     //These variables are used by the game loop:
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
     //game variables should be initialized here and will last for as long as the game is running.
        Boolean gameHasBegun = false;
        Game currentGame = new Game();
     //
         public void handle(long currentNanoTime){
           //loop variables are initialized here and will only last for one loop.
              long now = System.nanoTime();
           //
              delta += (now - lastTime) / ns;
              lastTime = now;
              while(delta >=1){
            	  if(!gameHasBegun) {
            		  if(playerInput.space)gameHasBegun = true; 
            	  }
            	  else if(!currentGame.gameOver)tick(currentGame, playerInput);
            	  else if(playerInput.space) {
            		  currentGame = new Game();
            	  }
                  delta--;
              }
              
              if(gameHasBegun)render(currentGame, gc);
              if(currentGame.gameOver) {
            	  gc.setFill(Color.WHITE);
            	  gc.fillText("Game Over", 225, 100);
            	  gc.fillText("Press space to start over", 185 , 300);
            	  gc.fillText("Instructions:", 50, 400);
            	  gc.fillText("> If an enemy touches you, you lose!", 50, 415);
            	  gc.fillText("> Type an enemy's name to neutralize it", 50, 430);
            	  gc.fillText("> Use the Arrow keys to move around the screen", 50, 445);
              }
              frames++;

              if(System.currentTimeMillis() - timer >= 1000){
                 timer += 1000;
                 System.out.println("FPS: "+ frames);
                 frames = 0;
              }
         }
     }.start();
     stage.show();
  }
}

