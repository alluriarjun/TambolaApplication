package tambola.validator;

import javax.xml.validation.Validator;
import java.util.Arrays;

public class FullHouseValidator implements ClaimValidator {
    @Override
    public boolean isValid(tambola.model.Ticket ticket, java.util.List<Integer> announcedNumbers) {
        java.util.Set<Integer> announcedSet = new java.util.HashSet<>(announcedNumbers);

        int lastAnnounced = announcedNumbers.get(announcedNumbers.size() - 1);
        int[][] numbers = ticket.getNumbers();
        for (int[] row : numbers) {
            for (int num : row) {
                if (num != 0 && !announcedSet.contains(num)) return false;
            }
        }
        return Arrays.stream(numbers).flatMapToInt(Arrays::stream).anyMatch(num -> num == lastAnnounced);
    }
}
