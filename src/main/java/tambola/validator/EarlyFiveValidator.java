package tambola.validator;

import java.util.Arrays;

public class EarlyFiveValidator implements ClaimValidator{
    @Override
    public boolean isValid(tambola.model.Ticket ticket, java.util.List<Integer> announcedNumbers) {
        java.util.Set<Integer> announcedSet = new java.util.HashSet<>(announcedNumbers);

        int lastAnnounced = announcedNumbers.get(announcedNumbers.size() - 1);
        int count = 0;
        for (int[] row : ticket.getNumbers()) {
            for (int num : row) {
                if (num != 0 && announcedSet.contains(num)) {
                    count++;
                }
            }
        }
        // if count is 5 and last announced number is in ticket then return true
        if(count ==  5 && Arrays.stream(ticket.getNumbers()).flatMapToInt(Arrays::stream).anyMatch(num -> num == lastAnnounced))
        {
            return true;
        } else {
            return false;
        }
    }
}
