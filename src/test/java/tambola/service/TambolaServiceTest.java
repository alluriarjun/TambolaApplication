package tambola.service;

import tambola.model.ClaimType;
import tambola.model.Ticket;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TambolaServiceTest {

    @Test
    public void testValidateTopRowClaim_Accepted() {
        int[][] ticketArr = {
                {4, 16, 0, 0, 48, 0, 63, 76, 0},
                {7, 0, 23, 38, 0, 52, 0, 0, 80},
                {9, 0, 25, 0, 0, 56, 64, 0, 83}
        };
        Ticket ticket = new Ticket(ticketArr);
        List<Integer> announcedNumbers = Arrays.asList(90, 4, 46, 63, 89, 16, 76, 48);

        TambolaService service = new TambolaService();
        boolean result = service.validateClaim(ticket, announcedNumbers, ClaimType.TOP_ROW);

        assertTrue(result);
    }

    @Test
    public void testValidateTopRowClaim_Rejected_when_claimed_late() {
        int[][] ticketArr = {
                {4, 16, 0, 0, 48, 0, 63, 76, 0},
                {7, 0, 23, 38, 0, 52, 0, 0, 80},
                {9, 0, 25, 0, 0, 56, 64, 0, 83}
        };
        Ticket ticket = new Ticket(ticketArr);
        List<Integer> announcedNumbers = Arrays.asList(90, 4, 46, 63, 89, 16, 76, 48, 12);

        TambolaService service = new TambolaService();
        boolean result = service.validateClaim(ticket, announcedNumbers, ClaimType.TOP_ROW);

        assertFalse(result);
    }

    @Test
    public void testValidateTopRowClaim_Rejected() {
        int[][] ticketArr = {
                {4, 16, 0, 0, 48, 0, 63, 76, 0},
                {7, 0, 23, 38, 0, 52, 0, 0, 80},
                {9, 0, 25, 0, 0, 56, 64, 0, 83}
        };
        Ticket ticket = new Ticket(ticketArr);
        List<Integer> announcedNumbers = Arrays.asList(90, 4, 46, 63, 89);

        TambolaService service = new TambolaService();
        boolean result = service.validateClaim(ticket, announcedNumbers, ClaimType.TOP_ROW);

        assertFalse(result);
    }

    @Test
    public void testValidateEarlyFiveClaim_Accepted() {
        int[][] ticketArr = {
                {4, 16, 0, 0, 48, 0, 63, 76, 0},
                {7, 0, 23, 38, 0, 52, 0, 0, 80},
                {9, 0, 25, 0, 0, 56, 64, 0, 83}
        };
        Ticket ticket = new Ticket(ticketArr);
        List<Integer> announcedNumbers = Arrays.asList(1, 99, 4, 16, 23, 38, 52);

        TambolaService service = new TambolaService();
        boolean result = service.validateClaim(ticket, announcedNumbers, ClaimType.EARLY_FIVE);

        assertTrue(result);
    }

    @Test
    public void testValidateEarlyFiveClaim_Rejected() {
        int[][] ticketArr = {
                {4, 16, 0, 0, 48, 0, 63, 76, 0},
                {7, 0, 23, 38, 0, 52, 0, 0, 80},
                {9, 0, 25, 0, 0, 56, 64, 0, 83}
        };
        Ticket ticket = new Ticket(ticketArr);
        List<Integer> announcedNumbers = Arrays.asList(1, 99, 4, 16, 23, 38);

        TambolaService service = new TambolaService();
        boolean result = service.validateClaim(ticket, announcedNumbers, ClaimType.EARLY_FIVE);

        assertFalse(result);
    }

    @Test
    public void testValidateEarlyFiveClaim_Rejected_when_claimed_late() {
        int[][] ticketArr = {
                {4, 16, 0, 0, 48, 0, 63, 76, 0},
                {7, 0, 23, 38, 0, 52, 0, 0, 80},
                {9, 0, 25, 0, 0, 56, 64, 0, 83}
        };
        Ticket ticket = new Ticket(ticketArr);
        List<Integer> announcedNumbers = Arrays.asList(1, 99, 4, 16, 23, 38, 52, 12);

        TambolaService service = new TambolaService();
        boolean result = service.validateClaim(ticket, announcedNumbers, ClaimType.EARLY_FIVE);


        assertFalse(result);
    }

    @Test
    public void testValidateMiddleRowClaim_Rejected() {
        int[][] ticketArr = {
                {4, 16, 0, 0, 48, 0, 63, 76, 0},
                {7, 0, 23, 38, 0, 52, 0, 0, 80},
                {9, 0, 25, 0, 0, 56, 64, 0, 83}
        };
        Ticket ticket = new Ticket(ticketArr);
        List<Integer> announcedNumbers = Arrays.asList(1, 99, 4, 16, 23, 38);

        TambolaService service = new TambolaService();
        boolean result = service.validateClaim(ticket, announcedNumbers, ClaimType.MIDDLE_ROW);

        assertFalse(result);
    }

    @Test
    public void testValidateMiddleRowClaim_Accepted() {
        int[][] ticketArr = {
                {4, 16, 0, 0, 48, 0, 63, 76, 0},
                {7, 0, 23, 38, 0, 52, 0, 0, 80},
                {9, 0, 25, 0, 0, 56, 64, 0, 83}
        };
        Ticket ticket = new Ticket(ticketArr);
        List<Integer> announcedNumbers = Arrays.asList(90, 7, 23, 63, 89, 38, 80, 52);

        TambolaService service = new TambolaService();
        boolean result = service.validateClaim(ticket, announcedNumbers, ClaimType.MIDDLE_ROW);

        assertTrue(result);
    }

    @Test
    public void testValidateMiddleRowClaim_Rejected_when_claimed_late() {
        int[][] ticketArr = {
                {4, 16, 0, 0, 48, 0, 63, 76, 0},
                {7, 0, 23, 38, 0, 52, 0, 0, 80},
                {9, 0, 25, 0, 0, 56, 64, 0, 83}
        };
        Ticket ticket = new Ticket(ticketArr);
        List<Integer> announcedNumbers = Arrays.asList(90, 7, 23, 63, 89, 38, 80, 52, 12);

        TambolaService service = new TambolaService();
        boolean result = service.validateClaim(ticket, announcedNumbers, ClaimType.MIDDLE_ROW);

        assertFalse(result);
    }

    @Test
    public void testValidateBottomRowClaim_Rejected() {
        int[][] ticketArr = {
                {4, 16, 0, 0, 48, 0, 63, 76, 0},
                {7, 0, 23, 38, 0, 52, 0, 0, 80},
                {9, 0, 25, 0, 0, 56, 64, 0, 83}
        };
        Ticket ticket = new Ticket(ticketArr);
        List<Integer> announcedNumbers = Arrays.asList(1, 99, 4, 16, 23, 38);

        TambolaService service = new TambolaService();
        boolean result = service.validateClaim(ticket, announcedNumbers, ClaimType.BOTTOM_ROW);

        assertFalse(result);
    }

    @Test
    public void testValidateBottomRowClaim_Accepted() {
        int[][] ticketArr = {
                {4, 16, 0, 0, 48, 0, 63, 76, 0},
                {7, 0, 23, 38, 0, 52, 0, 0, 80},
                {9, 0, 25, 0, 0, 56, 64, 0, 83}
        };
        Ticket ticket = new Ticket(ticketArr);
        List<Integer> announcedNumbers = Arrays.asList(90, 9, 25, 63, 89, 56, 83, 64);

        TambolaService service = new TambolaService();
        boolean result = service.validateClaim(ticket, announcedNumbers, ClaimType.BOTTOM_ROW);

        assertTrue(result);
    }

    @Test
    public void testValidateBottomRowClaim_Rejected_when_claimed_late() {
        int[][] ticketArr = {
                {4, 16, 0, 0, 48, 0, 63, 76, 0},
                {7, 0, 23, 38, 0, 52, 0, 0, 80},
                {9, 0, 25, 0, 0, 56, 64, 0, 83}
        };
        Ticket ticket = new Ticket(ticketArr);
        List<Integer> announcedNumbers = Arrays.asList(90, 9, 25, 63, 89, 56, 83, 64, 12);

        TambolaService service = new TambolaService();
        boolean result = service.validateClaim(ticket, announcedNumbers, ClaimType.BOTTOM_ROW);

        assertFalse(result);
    }

    @Test
    public void testValidateFullHouseClaim_Rejected() {
        int[][] ticketArr = {
                {4, 16, 0, 0, 48, 0, 63, 76, 0},
                {7, 0, 23, 38, 0, 52, 0, 0, 80},
                {9, 0, 25, 0, 0, 56, 64, 0, 83}
        };
        Ticket ticket = new Ticket(ticketArr);
        List<Integer> announcedNumbers = Arrays.asList(1, 99, 4, 16, 23, 38);

        TambolaService service = new TambolaService();
        boolean result = service.validateClaim(ticket, announcedNumbers, ClaimType.FULL_HOUSE);

        assertFalse(result);
    }

    @Test
    public void testValidateFullHouseClaim_Accepted() {
        int[][] ticketArr = {
                {4, 16, 0, 0, 48, 0, 63, 76, 0},
                {7, 0, 23, 38, 0, 52, 0, 0, 80},
                {9, 0, 25, 0, 0, 56, 64, 0, 83}
        };
        Ticket ticket = new Ticket(ticketArr);
        List<Integer> announcedNumbers = Arrays.asList(4,16,48,63,76,7,23,38,52,9,25,56,64,83,12,80);

        TambolaService service = new TambolaService();
        boolean result = service.validateClaim(ticket, announcedNumbers, ClaimType.FULL_HOUSE);

        assertTrue(result);
    }

    @Test
    public void testValidateFullHouse_Rejected_when_claimed_late() {
        int[][] ticketArr = {
                {4, 16, 0, 0, 48, 0, 63, 76, 0},
                {7, 0, 23, 38, 0, 52, 0, 0, 80},
                {9, 0, 25, 0, 0, 56, 64, 0, 83}
        };
        Ticket ticket = new Ticket(ticketArr);
        List<Integer> announcedNumbers = Arrays.asList(4,16,48,63,76,7,23,38,52,9,25,56,64,83,12,80, 20);

        TambolaService service = new TambolaService();
        boolean result = service.validateClaim(ticket, announcedNumbers, ClaimType.FULL_HOUSE);

        assertFalse(result);
    }
}