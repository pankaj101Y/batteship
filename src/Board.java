import java.util.Arrays;

public class Board {

    private Cell[][] board;
    private int size;
    private int player;

    public Board(int m){
        board=new Cell[m][m];
        size=m;
        initBroad();
    }

    private void initBroad(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j]=new Cell(null,null);
            }
        }
    }

    public void  setCell(int i,int j,Ship ship,Missile missile){
        if (!isValidCell(i,j)){
            //throw exception ?
        }
        board[i][j]=new Cell(ship,missile);
    }

    public Cell getCell(int i,int j){
        if (isValidCell(i,j)){
            return board[i][j];
        }

        return null;
    }


    public boolean isValidCell(int i,int j){
        if (i<0||j<0||i>=size||j>=size){
            return false;
        }

        return true;
    }

    public int getSize() {
        return size;
    }


    public void print() {
        StringBuilder sb=new StringBuilder();

        for (Cell[] cells:board){
            sb.append(Arrays.toString(cells)).append('\n');
        }

        System.out.println(sb);
    }

    public BoardResult getAliveShipsCount(){

        int hits=0,alive=0;
        for (Cell[] row:board){
            for (Cell cell:row){
                if (cell.getShip()!=null && cell.getShip().isAlive()){
                    alive+=1;
                }

                if (cell.isHitCell()){
                    hits+=1;
                }
            }
        }
        return new BoardResult(hits,alive);
    }
}
