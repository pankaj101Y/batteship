
public class BoardResult {

    private int hits;
    private int aliveShips;

    public BoardResult(int hits, int aliveShips) {
        this.hits = hits;
        this.aliveShips = aliveShips;
    }

    public int getAliveShips() {
        return aliveShips;
    }

    public int getHits() {
        return hits;
    }
}
