public class Ship {

    private ShipStatus status; //1 for alive, 2 for destroyed


    public Ship() {
        this.status=ShipStatus.ALIVE;
    }

    public void setStatus(ShipStatus status) {
        this.status = status;
    }


    public ShipStatus getStatus() {
        return status;
    }

    public boolean isAlive(){
        return status==ShipStatus.ALIVE;
    }

    enum ShipStatus{

        ALIVE,
        DESTROYED

    }
}
