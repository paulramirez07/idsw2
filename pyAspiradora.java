import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class pyAspiradora{

    static int[][] map= {
        {3,	4,	1,	3,	4,	1,	1,	4,	3,	2,	2,	2,	1,	1,	4,	4,	4,	2,	0,	0,	2,	1,	3,	0,	1},
        {3,	3,	1,	3,	3,	4,	0,	3,	4,	2,	4,	3,	4,	3,	4,	3,	1,	2,	3,	2,	4,	1,	2,	0,	1},
        {4,	1,	0,	2,	2,	3,	1,	1,	2,	2,	1,	1,	2,	2,	0,	2,	1,	4,	3,	0,	0,	3,	4,	0,	1},
        {1,	2,	2,	3,	3,	0,	1,	2,	0,	3,	0,	1,	0,	1,	0,	0,	0,	4,	4,	1,	2,	1,	4,	4,	0},
        {4,	2,	0,	0,	4,	0,	2,	4,	2,	3,	1,	2,	3,	2,	1,	0,	3,	3,	1,	1,	0,	2,	2,	4,	1},
        {4,	2,	3,	3,	4,	2,	1,	4,	2,	0,	3,	1,	1,	2,	3,	3,	4,	4,	0,	0,	4,	0,	4,	4,	2},
        {3,	0,	0,	0,	4,	0,	4,	4,	0,	4,	3,	3,	0,	0,	3,	1,	3,	1,	2,	4,	2,	4,	1,	1,	3},
        {2,	3,	3,	2,	4,	1,	0,	1,	2,	4,	4,	4,	3,	0,	4,	0,	0,	4,	4,	4,	4,	0,	2,	0,	3},
        {1,	3,	3,	2,	4,	4,	2,	3,	3,	4,	4,	4,	2,	2,	2,	0,	3,	0,	4,	4,	4,	2,	1,	0,	3},
        {0,	2,	1,	1,	4,	2,	1,	3,	2,	0,	0,	4,	3,	3,	3,	1,	3,	3,	3,	3,	1,	2,	1,	0,	0},
        {0,	1,	0,	2,	2,	3,	3,	2,	0,	1,	2,	2,	0,	0,	0,	3,	2,	4,	4,	4,	4,	4,	3,	2,	1},
        {3,	3,	2,	2,	4,	0,	1,	0,	1,	2,	1,	0,	0,	1,	1,	3,	1,	2,	2,	1,	1,	0,	3,	3,	4},
        {3,	0,	3,	0,	2,	4,	1,	3,	3,	1,	0,	0,	1,	1,	3,	1,	4,	0,	3,	3,	0,	2,	0,	2,	4},
        {2,	1,	0,	1,	4,	0,	2,	1,	3,	0,	0,	0,	1,	2,	4,	4,	3,	0,	2,	4,	0,	3,	1,	1,	3},
        {0,	4,	0,	3,	2,	1,	3,	1,	0,	3,	1,	4,	2,	0,	4,	1,	3,	1,	0,	0,	1,	4,	4,	2,	2},
        {4,	0,	4,	4,	2,	4,	4,	4,	0,	2,	2,	3,	1,	4,	3,	3,	3,	3,	1,	1,	4,	3,	2,	1,	4},
        {3,	0,	2,	0,	4,	1,	2,	3,	3,	2,	3,	1,	0,	1,	1,	3,	1,	3,	1,	0,	1,	3,	2,	0,	3},
        {1,	1,	3,	0,	1,	2,	1,	4,	2,	1,	2,	0,	1,	3,	4,	2,	4,	1,	1,	1,	3,	1,	3,	4,	2},
        {2,	0,	3,	0,	2,	2,	1,	2,	4,	0,	0,	2,	4,	3,	0,	3,	4,	4,	3,	3,	1,	3,	2,	1,	1},
        {3,	4,	0,	3,	3,	0,	4,	4,	0,	1,	1,	0,	3,	1,	3,	2,	3,	4,	4,	2,	0,	3,	2,	4,	3},
        {3,	4,	2,	3,	4,	3,	2,	2,	2,	2,	1,	1,	1,	4,	4,	3,	4,	4,	3,	1,	2,	2,	1,	1,	3},
        {0,	4,	2,	1,	3,	0,	0,	3,	4,	2,	3,	3,	3,	0,	1,	1,	2,	3,	3,	1,	0,	0,	2,	3,	0},
        {1,	2,	3,	3,	0,	0,	0,	0,	3,	3,	3,	4,	2,	0,	2,	3,	0,	3,	0,	1,	3,	4,	3,	1,	0},
        {0,	0,	3,	3,	4,	2,	2,	2,	3,	2,	1,	0,	0,	3,	2,	1,	4,	4,	1,	2,	4,	2,	2,	4,	2},
        {4,	0,	3,	2,	2,	0,	4,	0,	1,	2,	4,	2,	4,	2,	1,	4,	1,	1,	0,	1,	4,	0,	4,	2,	3}
    };

    static String[] levels = {" . ","ooo","***","OOO","000"};

    static int xVacuum = 12;
    static int yVacuum = 12;

    public static void main(String[] args){
        
       
        int[][] moves = {
            {-1,-1},
            {-1,0},
            {-1,1},
            {0,-1},
            {0,1},
            {1,-1},
            {1,0},
            {1,1}
        };

        

        while (true){
            int move = (int)(Math.random()*8);
            if(xVacuum + moves[move][0] < 0 || xVacuum + moves[move][0] > map[0].length || yVacuum + moves[move][0] < 0 || yVacuum + moves[move][0] > map.length) continue;
            xVacuum += moves[move][0];
            yVacuum += moves[move][1];
            map[yVacuum][xVacuum] = Math.max(0,map[yVacuum][xVacuum]-1);
            printMap();
            BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
 
            // Quit with "q"
            try {
                String input = reader.readLine();
                if(input.equals("q")) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printMap(){
        for(int row = 0; row<map.length;row++){
            for(int col = 0; col<map[row].length;col++){
                if(row == yVacuum && col == xVacuum) System.out.print("(O)");
                else System.out.print(levels[map[row][col]]);
            }
            System.out.println();
        }
    }
}