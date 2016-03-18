/**
 * Генератор Лаберинта 18.03.2016.
 */
public class LabyrinthGenerator {
    private int labyrinthWeigh;
    private int labyrinthHeight;
    private int x,y;
    private boolean [][] labyrinthField;


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
    private  boolean [][] fieldGenerator (){

        boolean [][] labyrinthField = new boolean[labyrinthWeigh][labyrinthHeight];
        for (int i=0; i<labyrinthWeigh; i++){
            for (int j=0; j<labyrinthHeight; j++){
                if ((i % 2 != 0 && j % 2 != 0) && (i < labyrinthWeigh - 1 && j < labyrinthHeight - 1)) {
                    labyrinthField [i][j] = false;
                }
                else {
                    labyrinthField [i][j] = true;
                }
            }
        }

        return labyrinthField;
    }

    public static void main(String[] args){
        LabyrinthGenerator lab = new LabyrinthGenerator();
        for (boolean[] i:lab.labyrinthField){
            for (boolean j:i) {
                if (j) System.out.print("X");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    // массив непосещеных соседей
    private int [] getNeighbours (int x,int y ){
        int step = 2;
        int up = y - 2;
        int dwn = y + 2;
        int lft = x - 2;
        int rht = x + 2;

        


        return;
    }

}
