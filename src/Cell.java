public class Cell {

    private Ship ship;
    private Missile missile;
    private CellStatus cellStatus;

    public Cell(Ship ship, Missile missile) {
        this.ship = ship;
        this.missile = missile;
        if (ship!=null){
            cellStatus=CellStatus.SHIP;
        }else {
            cellStatus=CellStatus.EMPTY;
        }
    }

    public Missile getMissile() {
        return missile;
    }

    public Ship getShip() {
        return ship;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public boolean isShipCell(){
        return cellStatus==CellStatus.SHIP;
    }

    public boolean isHitCell(){
        return cellStatus==CellStatus.HIT;
    }

    @Override
    public String toString() {
        return " "+ cellStatus +" ";
    }

    enum CellStatus{

        SHIP('B'),
        EMPTY('-'),
        HIT('X'),
        MISS('O');

        char status;

        CellStatus(char c){
            status=c;
        }

        @Override
        public String toString() {
            return "" + status;
        }
    }
}
