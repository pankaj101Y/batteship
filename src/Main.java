import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * Player
 * Board
 * Cell
 * Game
 *
 */
public class Main {

    public static void main(String[] args) {
        BattleGame battleGame=new BattleGame(getBoard1(),getBoard2());

//        battleGame.getFirstPlayerBoard().print();
//        battleGame.getSecondPlayerBoard().print();
        battleGame.play();
        battleGame.getFirstPlayerBoard().print();
        battleGame.getSecondPlayerBoard().print();
        battleGame.printResult();
    }

    public static Board getBoard1(){
        int size=5;
        String player1Ship="1,1:2,0:2,3:3,4:4,3";
        String player1Missile="0,1:4,3:2,3:3,1:4,1";

        return getBoard(size,player1Ship,player1Missile);
    }

    public static Board getBoard2(){
        int size=5;
        String player2Ship="0,1:2,3:3,0:3,4:4,1";
        String player2Missile="0,1:0,0:1,1:2,3:4,3";

        return  getBoard(size,player2Ship,player2Missile);
    }


    public static Board getBoard(int m,String ships,String missiles){
        Board board=new Board(m);

        Set<String> shipsSet=getPointUniqueIds(ships);
        Set<String> missilesSet=getPointUniqueIds(missiles);

        for (int i=0;i<m;i++){
            for (int j=0;j<m;j++){
                Ship cellShip=shipsSet.contains(getId(i+","+j))?new Ship():null;
                Missile cellMissile=missilesSet.contains(getId(i+","+j))?new Missile():null;
                board.setCell(i,j,cellShip,cellMissile);
            }
        }

        return board;
    }

    private static Set<String> getPointUniqueIds(String pointsString) {
        if (pointsString!=null){
            return Arrays.stream(pointsString.split(":")).collect(Collectors.toSet());
        }

        return new HashSet<>();
    }

    private static String getId(String point){
        return point;
    }
}
