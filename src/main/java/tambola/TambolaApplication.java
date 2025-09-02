package tambola;

import tambola.model.*;
import tambola.service.*;

import java.util.Arrays;
import java.util.List;

public class TambolaApplication {
    public static void main(String[] args) {
        int[][] numbers = {
            {4, 16, 0, 0, 48, 0, 63, 76, 0},
            {7, 0, 23, 38, 0, 52, 0, 0, 80},
            {9, 0, 25, 0, 0, 56, 64, 0, 83}
        };
        Ticket ticket = new Ticket(numbers);
        List<Integer> announced = Arrays.asList(90, 4, 46, 63, 89, 16, 76, 48);

        TambolaService service = new TambolaService();
        boolean accepted = service.validateClaim(ticket, announced, ClaimType.TOP_ROW);
        System.out.println(accepted ? "Accepted" : "Rejected");
    }
}