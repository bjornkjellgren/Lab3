package se.kyh;

public class Main {
    /*
    TODO ett sätt att kontrollera att vi kan placera en siffra på given position
     */

    private static boolean possible(int[][] board, int x, int y, int value){
        //Kontroller rad och kolumn, om value finns i rad eller kolumn, return false
        for(int i = 0; i < 9; i++){
            if(board[y][i] == value || board[i][x] == value){
                return false;
            }
        }

        //Kontrollera aktuell 3x3 ruta
        int x0 = (x/3) * 3;
        int y0 = (y/3) * 3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[y0+i][x0+j] == value){
                    return false;
                }
            }
        }

        return true;
    }

    private static void solve(int[][] board){
        //Loopa igenom alla rader och kolumner (Två nästlade loopar)
        //  kolla om det är en nolla på den aktuella positionen
        //    Loopar vi igenom alla tal mellan 1 och 9
        //      Kolla, kan vi placera aktuellt tal på den aktuella positionen
        //        om ja, placerar vi aktuellt värde på positionen
        //          anropa solve
        //          ta bort det aktuella värdet
        //     return
        //Skriv ut lösningen
    }

    public static void main(String[] args) {
        int [][] board = {{0, 0, 0, 8, 0, 4, 9, 3, 7},
                          {0, 7, 4, 1, 0, 0, 0, 8, 0},
                          {8, 3, 2, 0, 0, 0, 4, 0, 0},
                          {2, 0, 5, 3, 0, 0, 7, 4, 0},
                          {0, 0, 0, 0, 0, 0, 0, 1, 6},
                          {1, 4, 3, 0, 0, 0, 2, 0, 0},
                          {0, 0, 7, 0, 9, 0, 6, 0, 0},
                          {0, 2, 1, 7, 5, 6, 8, 9, 0},
                          {6, 5, 9, 2, 3, 0, 0, 7, 4}};

        System.out.println("should be true " + possible(board, 4, 4, 2));
        System.out.println("should be false " + possible(board, 4, 4, 6));
        System.out.println("should be false " + possible(board, 4, 4, 5));
        System.out.println("should be false " + possible(board, 5, 4, 3));
    }
}
