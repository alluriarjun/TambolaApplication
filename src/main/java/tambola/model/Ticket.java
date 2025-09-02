package tambola.model;

import java.util.List;

public class Ticket {
    private final int[][] numbers;

    public Ticket(int[][] numbers) {
        this.numbers = numbers;
    }

    public int[][] getNumbers() {
        return numbers;
    }
}