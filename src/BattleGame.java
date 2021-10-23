public class BattleGame {

    private Board firstPlayerBoard;
    private Board secondPlayerBoard;

    public BattleGame(Board firstPlayerBoard, Board secondPlayerBoard) {
        this.firstPlayerBoard = firstPlayerBoard;
        this.secondPlayerBoard = secondPlayerBoard;
    }

    private Cell attackCell(Cell src,Cell target){
        if (src.getMissile()!=null){
            if (target.getShip()!=null){
                target.getShip().setStatus(Ship.ShipStatus.DESTROYED);
                target.setCellStatus(Cell.CellStatus.HIT);
            }else {
                target.setCellStatus(Cell.CellStatus.MISS);
            }
        }

        return src;
    }

    public void play(){
        attackBoard(firstPlayerBoard,secondPlayerBoard);
        attackBoard(secondPlayerBoard,firstPlayerBoard);
    }

    private void attackBoard(Board src,Board target){
        int size=src.getSize();

        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                attackCell(src.getCell(i,j),target.getCell(i,j));
            }
        }
    }

    public Board getFirstPlayerBoard() {
        return firstPlayerBoard;
    }

    public Board getSecondPlayerBoard() {
        return secondPlayerBoard;
    }

    public void printResult(){
        BoardResult player1Result=getFirstPlayerBoard().getAliveShipsCount();
        BoardResult player2Result=getSecondPlayerBoard().getAliveShipsCount();


        StringBuilder sb=new StringBuilder();
        sb.append("P1:").append(player1Result.getHits()).append('\n');
        sb.append("P2:").append(player2Result.getHits()).append('\n');

        if (player1Result.getAliveShips()>player2Result.getAliveShips()){
            sb.append("Player 1 wins");
        }else if (player1Result.getAliveShips()<player2Result.getAliveShips()){
            sb.append("Player 2 wins");
        }else {
            sb.append("It is a draw");
        }

        System.out.println(sb);
    }
}
