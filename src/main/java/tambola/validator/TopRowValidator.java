package tambola.validator;

import tambola.model.Ticket;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class TopRowValidator implements ClaimValidator {
    @Override
    public boolean isValid(Ticket ticket, List<Integer> announcedNumbers) {
        Set<Integer> announcedSet = new HashSet<>(announcedNumbers);
        int lastAnnounced = announcedNumbers.get(announcedNumbers.size() - 1);
        int[] row = ticket.getNumbers()[0];
        for (int num : row) {
            if (num != 0 && !announcedSet.contains(num)) return false;
        }
        return Arrays.stream(row).anyMatch(num -> num == lastAnnounced);
    }
}