package tambola.validator;

import java.util.Arrays;

public class MiddleRowValidator implements ClaimValidator{
    @Override
    public boolean isValid(tambola.model.Ticket ticket, java.util.List<Integer> announcedNumbers) {
        java.util.Set<Integer> announcedSet = new java.util.HashSet<>(announcedNumbers);

        int lastAnnounced = announcedNumbers.get(announcedNumbers.size() - 1);
        int[] row = ticket.getNumbers()[1];
        for (int num : row) {
            if (num != 0 && !announcedSet.contains(num)) return false;
        }
        return Arrays.stream(row).anyMatch(num -> num == lastAnnounced);
    }
}
