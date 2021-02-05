import java.awt.*;
import java.util.*;
//HELLO MACBOOKY
public class SandLab {
  public static void main(String[] args) {
    //130, (ANY) MACBOOK
    //250, 200 (Windows)
    SandLab lab = new SandLab(250, 200);
    lab.run();
  }

  //add constants for particle types here
  public static final int EMPTY = 0;
  public static final int METAL = 1;
  public static final int SAND = 2;
  public static final int WATER = 3;
  public static final int SNOW = 4;
  public static final int ICE = 5;
  public static final int FIRE = 6;
  public static final int LAVA = 7;
  public static final int SMOKE = 8;
  public static final int LIGHTNING_ROOT= 9;

  public static final int LIGHTNING=104;
  public static final int GLASS = 101;
  public static final int COBBLE = 102;
  public static final int OBSIDIAN = 103;


  //do not add any more fields
  private int[][] grid;
  private SandDisplay display;

  private static final int LIGHTNING_CHANCE=500;
  private static int GAME_TIME=5;



  public SandLab(int numRows, int numCols) {
    grid = new int [numRows][numCols];
    String[] names;
    names = new String[10];
    names[EMPTY] = "Empty";
    names[METAL] = "Metal";
    names[SAND] = "Sand";
    names[WATER] = "Water";
    names[SNOW] = "Snow";
    names[ICE] = "Ice";
    names[FIRE] = "Fire";
    names[LAVA] = "Lava";
    names[SMOKE] = "Smoke";
    names[LIGHTNING_ROOT]="Lightning";

    display = new SandDisplay("Falling Sand", numRows, numCols, names);
  }

  //called when the user clicks on a location using the given tool
  private void locationClicked(int row, int col, int tool) {
    grid[row][col]=tool;
    int size = display.getBrushSize();
    for(int y=-size+1;y<size;y++){
      for(int x=-size+1;x<size;x++){
        if(y*y + x*x <= size*size){
          grid[Math.max(Math.min(grid.length-1,row+y),0)]
                  [Math.max(Math.min(grid[0].length-1,col+x),0)] = tool;
        }
      }
    }


  }

  //copies each element of grid into the display
  public void updateDisplay() {
    for(int i=0;i<grid.length;i++){
      for(int j=0;j<grid[i].length;j++){
        int colourCode = grid[i][j];
        Random rand= new Random();

        switch(colourCode){
          case EMPTY:
            display.setColor(i,j,Color.black);
            break;

          case METAL:
            display.setColor(i,j,new Color(128,128,128));
            break;

          case SAND:
            display.setColor(i,j,Color.yellow);
            break;

          case WATER:
            display.setColor(i,j,new Color(0,123,174));
            break;

          case SNOW:
            display.setColor(i,j,new Color(255,255,255));
            break;

          case ICE:
            display.setColor(i,j,new Color(134,214,216));
            break;

          case FIRE:
            display.setColor(i,j,new Color(255,100,100));
            break;

          case GLASS:
            display.setColor(i,j,new Color(204, 229, 255));
            break;

          case LAVA:
            int Metal_Liquid_rand=rand.nextInt(50);
            if(Metal_Liquid_rand==0){
              display.setColor(i,j, new Color(255,93,23));
            }else{
              display.setColor(i,j,new Color(255,169,56));
            }
            break;

          case SMOKE:
            int Smoke_rand = rand.nextInt(10);
            if(Smoke_rand==0){
              display.setColor(i,j,new Color(125,125,125));
            }else{
              display.setColor(i,j,new Color(255,255,255));
            }
            break;

          case COBBLE:
            display.setColor(i,j,new Color(120,120,120));
            break;

          case OBSIDIAN:
            display.setColor(i,j,new Color(75,0,130));
            break;

          case LIGHTNING:
            display.setColor(i,j,new Color(70,50,220));
            break;
          case LIGHTNING_ROOT:
            display.setColor(i,j,new Color(150,150,150));
            break;

        }




      }
    }
  }

  //called repeatedly.
  //causes one random particle to maybe do something.
  public void step() {
    Random rand = new Random();
    int y = rand.nextInt(grid.length-1);
    int x = rand.nextInt(grid[0].length);
    GAME_TIME++;

    switch(grid[y][x]) {

      case SAND:
        if (y < grid.length) {
          if (grid[y + 1][x] == EMPTY) {
            grid[y + 1][x] = SAND;
            grid[y][x] = EMPTY;
          } else {
            int ran = rand.nextInt(2);
            if ((x) < grid[0].length - 1 && grid[y + 1][x] != METAL) {
              if (ran == 0 && (grid[y + 1][x + 1] == EMPTY || grid[y + 1][x + 1] == WATER)) {
                int temp = grid[y + 1][x + 1];
                grid[y + 1][x + 1] = grid[y][x];
                grid[y][x] = temp;
              } else if (x != 0 && ran == 1 && (grid[y + 1][x - 1] == EMPTY || grid[y + 1][x - 1] == WATER)) {
                int temp = grid[y + 1][x - 1];
                grid[y + 1][x - 1] = grid[y][x];
                grid[y][x] = temp;
              }
            }
          }
        }
        break;

      case WATER:
        if (y < grid.length) {
          if (grid[y + 1][x] == LAVA) {
            grid[y][x] = OBSIDIAN;
          }else if(grid[y+1][x]==ICE) {
            grid[y][x] = ICE;
          } else if (grid[y+1][x] != METAL && grid[y + 1][x] != SAND &&
                  grid[y + 1][x] != WATER && grid[y+1][x]!=OBSIDIAN && grid[y+1][x]!= COBBLE &&
                  grid[y+1][x]!=GLASS) {
            grid[y + 1][x] = WATER;
            grid[y][x] = EMPTY;
          } else {
            int num = rand.nextInt(2);
            if ((num == 0 && (x) < grid[0].length - 1) && grid[y][x + 1] == EMPTY) {
              grid[y][x + 1] = WATER;
              grid[y][x] = EMPTY;
            } else if (x != 0 && grid[y][x - 1] == EMPTY) {
              grid[y][x - 1] = WATER;
              grid[y][x] = EMPTY;
            }
          }
        }

        break;

      case SNOW:
        if (y < grid.length - 1) {
          if (grid[y + 1][x] == EMPTY) {
            grid[y + 1][x] = SNOW;
            grid[y][x] = EMPTY;
          } else if (grid[y + 1][x] == WATER) {
            grid[y][x] = WATER;
          } else {
            if (grid[y + 1][x] != ICE || grid[y + 1][x] != SNOW) {
              int melt = rand.nextInt(20000);
              if (melt == 0) {
                grid[y][x] = WATER;
              }
            }
          }

        }
        break;

      case FIRE:
        int fireRandom = rand.nextInt(10);

        if (y > 0) {

          if (fireRandom == 0) {
            grid[y][x] = EMPTY;
          }
          if (fireRandom != 0) {
            grid[y - 1][x] = FIRE;
            grid[y][x] = EMPTY;
          }

          final int MELT_RANGE = 10;
          int rand_Smoke = rand.nextInt(500);
          for (int y1 = -MELT_RANGE; y1 <= MELT_RANGE; y1++) {
            for (int x1 = -MELT_RANGE; x1 <= MELT_RANGE; x1++) {
              if (x1 * x1 + y1 * y1 <= MELT_RANGE * MELT_RANGE) {
              } else if (grid[clampY(y + y1)][clampX(x + x1)] == SNOW) { // SNOW TO WATER
                grid[clampY(y + y1)][clampX(x + x1)] = WATER;
              } else if (grid[clampY(y + y1)][clampX(x + x1)] == SAND) { // SAND TO GLASS
                grid[clampY(y + y1)][clampX(x + x1)] = GLASS;
              } else if (grid[clampY(y + y1)][clampX(x + x1)] == METAL) { // METAL TO METAL LIQUID
                grid[clampY(y + y1)][clampX(x + x1)] = LAVA; //ISSSUE
              } else if (grid[clampY(y + y1)][clampX(x + x1)] == ICE) { // ICE TO WATER
                grid[clampY(y + y1)][clampX(x + x1)] = WATER;
              }else if(rand_Smoke==0) {
                if(grid[clampY(y + y1)][clampX(x + x1)] == WATER) { // CHANCE TO TURN WATER TO SMOKE
                  grid[clampY(y + y1)][clampX(x + x1)] = SMOKE;
                }
              }
            }
          }
          if(grid[y][x]==(y=0)){
            grid[y][x]=EMPTY;
          }
        }

        break;

      case LAVA:
        if(y<grid.length){
          if(grid[y+1][x]==WATER){
            grid[y][x]=COBBLE;
          }else if(grid[y+1][x]!=METAL && grid[y+1][x]!=LAVA &&
                  grid[y+1][x]!=COBBLE && grid[y+1][x]!=OBSIDIAN) {
            grid[y + 1][x] = LAVA;
            grid[y][x] = EMPTY;
          }else{
            int num = rand.nextInt(2);
            if ((num == 0 && (x) < grid[0].length - 1) && grid[y][x + 1] == EMPTY) {
              grid[y][x + 1] = LAVA;
              grid[y][x] = EMPTY;
            } else if (x != 0 && grid[y][x - 1] == EMPTY) {
              grid[y][x - 1] = LAVA;
              grid[y][x] = EMPTY;
            }
          }
          final int LAVA_MELT_RANGE=10;
          int metal_melt=rand.nextInt(500);
          for(int y1=-LAVA_MELT_RANGE;y1<=LAVA_MELT_RANGE;y1++){
            for(int x1=-LAVA_MELT_RANGE;x1<=LAVA_MELT_RANGE;x1++) {
              if (x1 * x1 + y1 * y1 <= LAVA_MELT_RANGE * LAVA_MELT_RANGE) {
              } else if (grid[clampY(y + y1)][clampX(x + x1)] == SNOW) { // SNOW TO WATER
                grid[clampY(y + y1)][clampX(x + x1)] = WATER;
              } else if (grid[clampY(y + y1)][clampX(x + x1)] == SAND) { // SAND TO GLASS
                grid[clampY(y + y1)][clampX(x + x1)] = GLASS;
              } else if (grid[clampY(y + y1)][clampX(x + x1)] == ICE) { // ICE TO WATER
                grid[clampY(y + y1)][clampX(x + x1)] = WATER;
              }
            }
          }

        }
        break;

      case SMOKE:
        if(y>0){
          if(grid[y-1][x]==EMPTY){
            grid[y-1][x]=SMOKE;
            grid[y][x]=EMPTY;
          }else if(grid[y-1][x]!=EMPTY){
            grid[y][x]=EMPTY;
          }
          if(grid[y][x]==(y=0)){
            grid[y][x]=EMPTY;
          }
        }

        break;

      case LIGHTNING_ROOT:
        if(GAME_TIME%LIGHTNING_CHANCE==0){
          final int LIGHTNING_WIDTH = 6;
          for(int y1=y;y1<grid.length;y1++){
            int zig = y1%(LIGHTNING_WIDTH*2-2);
            int x1 = (zig > (LIGHTNING_WIDTH-1)) ?  LIGHTNING_WIDTH-1 - zig % (LIGHTNING_WIDTH-1) : zig;
            if(clampX(x+x1) == x+x1){
              System.out.println(GAME_TIME);
              grid[y1][x+x1] = LIGHTNING;
            }
          }

        }else{
          grid[y][x]=EMPTY;
        }

      case LIGHTNING:
        int disappear = rand.nextInt(10);
        if(disappear==0) grid[y][x] = EMPTY;

      break;

    }
  }


  private int clampX(int val){
    return(Math.max(0,Math.min(grid[0].length-1,val)));
  }

  private int clampY(int val){
    return(Math.max(0,Math.min(grid.length-1,val)));
  }
  //do not modify
  public void run() {
    while (true) {
      for (int i = 0; i < display.getSpeed(); i++)
        step();
      updateDisplay();
      display.repaint();
      display.pause(1);  //wait for redrawing and for mouse
      int[] mouseLoc = display.getMouseLocation();
      if (mouseLoc != null)  //test if mouse clicked
        locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
    }
  }
}
