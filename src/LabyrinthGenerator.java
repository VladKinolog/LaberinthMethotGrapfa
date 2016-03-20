/**
 * Генератор Лаберинта 18.03.2016.
 */
public class LabyrinthGenerator {
    private static final int CELL = 0;
    private static final int WALL = 1;
    private static final int VISIT = 2;
    private int labyrinthWeigh;
    private int labyrinthHeight;
    private int x,y;
    private int [][] labyrinthField;

         class Cell{
             int x;
             int y;

             Cell (int x,int y){
                 this.x = x;
                 this.y = y;
             }
        }


    // Конструкторы + генерация начального поля
    LabyrinthGenerator(){
       this.labyrinthWeigh = 15;
       this.labyrinthHeight = 15;
       labyrinthField = this.fieldGenerator();

    }

    LabyrinthGenerator(int length){
        if (length % 2 == 0){
            this.labyrinthWeigh = length + 1;
            this.labyrinthHeight = length + 1;
        } else {
            this.labyrinthWeigh = length;
            this.labyrinthHeight = length;
        }
        labyrinthField = this.fieldGenerator();
    }
    LabyrinthGenerator(int length,int height){
        if (length % 2 == 0){
            this.labyrinthWeigh = length + 1;
        } else {
            this.labyrinthWeigh = length;
        }
        if (height % 2 == 0){
            this.labyrinthHeight = length + 1;
        }
        else {
            this.labyrinthHeight = length;
        }
        labyrinthField = this.fieldGenerator();
    }

    // Инициализация полей лаберинта
    private  int [][] fieldGenerator (){

        int [][] labyrinthField = new int[labyrinthWeigh][labyrinthHeight];
        for (int i=0; i<labyrinthWeigh; i++){
            for (int j=0; j<labyrinthHeight; j++){
                if ((i % 2 != 0 && j % 2 != 0) && (i < labyrinthWeigh - 1 && j < labyrinthHeight - 1)) {
                    labyrinthField [i][j] = CELL;
                }
                else {
                    labyrinthField [i][j] = WALL;
                }
            }
        }

        return labyrinthField;
    }

    public static void main(String[] args){
        LabyrinthGenerator lab = new LabyrinthGenerator();
        for (int[] i:lab.labyrinthField){
            for (int j:i) {
                 System.out.print(j);

            }
            System.out.println();
        }
    }

    // массив непосещеных соседей
    private int [] getNeighbours ( Cell c ){
        //int step = 2;
        int x = c.x;
        int y = c.y;
        Cell up = new Cell(x,y+1);
        Cell dwn = new Cell(x,y-1);
        Cell lft = new Cell(x+1,y);
        Cell rht = new Cell(x-1,y);
        Cell [] checkDir = {up,dwn,lft,rht};

        for (Cell i:checkDir){
            if (x > 0 && y > 0 && x < labyrinthWeigh && y < labyrinthHeight){
                if (labyrinthField[i.x][i.y] == VISIT){

                }

            }
        }

        return ;
    }



}
