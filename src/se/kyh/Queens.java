package se.kyh;

public class Queens {
    private static void printBoard(int[][] board){
        for(int y = 0; y < board.length; y++){
            for(int x = 0; x < board[y].length; x++){
                if(board[y][x] == 1){
                    System.out.print(" Q ");
                }
                else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }

    private static boolean solve(int[][] board, int row, int q){
        if(q == 0){
            return true;
        }

        //Loopa över raden
        //  om det går att placera dam, gör det på aktuell position
        //    anropa solve rekursivt för nästa rad och en dam mindre
        //      om brädet är fyllt return true
        //  ta bort damen vi placerade
        //

        for(int i = 0; i < board[row].length; i++){
            if(possible(board, i, row)){
                board[row][i] = 1;
                if(solve(board, row+1, q-1)){
                    return true;
                }
                board[row][i] = 0;
            }
        }
        return false;
    }

    private static boolean possible(int[][] board, int x, int y){
        //Kontrollera om dam finns placerad i samma kolumn
        for(int i = 0; i < board.length; i++){
            if(board[i][x] == 1){
                return false;
            }
        }

        //Kontrollera diagonalen upp till vänster
        for(int i = x, j = y; i >= 0 && j >= 0; i--, j--){
            if(board[j][i] == 1){
                return false;
            }
        }

        //Kontrollera diagonalen upp till höger
        //Kontrollera diagonalen upp till vänster
        for(int i = x, j = y; i < board[j].length && j > 0; i++, j--){
            if(board[j][i] == 1){
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args){

        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0}};

        printBoard(board);
        System.out.println("--------------------");
        solve(board,0, board.length);
        printBoard(board);
    }
}
