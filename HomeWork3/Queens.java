package HomeWork3;


public class Queens {
    public static void main(String[] args) {
        char[][] chess = new char[8][8];
        fillCharArray(chess);

        
        int index = (chess.length - 1) / 2;
        int a = chess.length - index;
        for (int i = 0; i < chess.length; i++, a--) {
            if (a == 1) 
                a = (chess.length + 1) / 2;
            if (index > chess.length - 1)
                index = index - chess.length;
            chess[i][index] = 'Q';
            index += a;           
        }

        System.out.println("\nВаши ферзи (Q):\n");
        printBoard(chess);
        System.out.println();
    }

    private static void fillCharArray (char[][] array)
    {
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = '-';
            }
        }
    }

    private static void printBoard (char[][] board)
    {
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
