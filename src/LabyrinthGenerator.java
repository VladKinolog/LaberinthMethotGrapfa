import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Генератор Лаберинта 18.03.2016.
 */
public class LabyrinthGenerator {
    private static final int CELL = 0;
    private static final int WALL = 1;
    private static final int VISIT = 2;
    private int labyrinthWeigh;
    private int labyrinthHeight;
    private int [][] labyrinthField;
    int unvisitedCount;
    Cell initCell = new Cell(2,2);
    Stack<Cell> stackCell = new Stack<>();

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
    private List<Cell> getNeighbours ( Cell c, int distance){
        int x = c.x;
        int y = c.y;
        Cell up = new Cell(x,y+distance);
        Cell dwn = new Cell(x,y-distance);
        Cell lft = new Cell(x+distance,y);
        Cell rht = new Cell(x-distance,y);
        Cell [] checkDir = {up,dwn,lft,rht};
        List<Cell> notVisNeighbor= new ArrayList<>();


        for (Cell i:checkDir){
            if (i.x > 0 && i.y > 0 && i.x < labyrinthWeigh && i.y < labyrinthHeight){
                Cell currentCell = new Cell(i.x,i.y);
                if (labyrinthField[i.x][i.y] != VISIT && labyrinthField[i.x][i.y] != WALL){
                    notVisNeighbor.add(currentCell);
                }
            }
        }
        return notVisNeighbor;
    }

    // Удаление стенки лаберинта

    private void dellWall(Cell first, Cell second){
        int dx = second.x - first.x;
        int dy = second.y - first.y;
        int addX,addY;


        addX = (dx != 0) ? dx/Math.abs(dx):0;
        addY = (dy != 0) ? dy/Math.abs(dy):0;

        Cell currentWall = new Cell(addX,addY);

        labyrinthField[currentWall.x][currentWall.y] = VISIT;

    }

    // Генерация матрицы Лаберинта
    private void generatorMaze (){
        Cell currentCell = new Cell(2,2);
        Cell targetCell;

        do {

            //рассмотреть возможность упростить циклы определения не посещенных клеток
            unvisitedCount = 0;
            for (int i []:labyrinthField) {
                for (int j:i) {
                    if (j == CELL) unvisitedCount++;
                }
            }



        }while (unvisitedCount>0);

    }




}
