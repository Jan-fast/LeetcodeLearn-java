package search;
public class offer12 {
    public static void main(String[] args) {
        char[][] board = {{'c', 'a', 'a'}, {'a', 'a', 'a'}, {'b', 'c', 'd'}};
        String word = "aab";
        offer12 ex = new offer12();
        System.out.println(ex.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        if (word == null) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (findRoad(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean findRoad(char[][]board, String word, int pos, int X, int Y) {
        if (word.charAt(pos) != board[X][Y]) return false;
        if (pos == word.length() - 1) return true;
        char c = board[X][Y];
        board[X][Y] = '0';
        if (X + 1 < board.length && board[X + 1][Y] != '0') {
            if (findRoad(board, word, pos + 1, X + 1, Y)) return true;
        }
        if (X - 1 >= 0 && board[X - 1][Y] != '0') {
            if (findRoad(board, word, pos + 1, X - 1, Y)) return true;
        }
        if (Y + 1 < board[0].length && board[X][Y + 1] != '0') {
            if (findRoad(board, word, pos + 1, X, Y + 1)) return true;
        }
        if (Y - 1 >= 0 && board[X][Y - 1] != '0') {
            if (findRoad(board, word, pos + 1, X, Y - 1)) return true;
        }
        board[X][Y] = c;
        return false;
    }
}
