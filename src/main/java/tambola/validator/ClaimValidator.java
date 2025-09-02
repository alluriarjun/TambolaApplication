package tambola.validator;

import tambola.model.Ticket;
import java.util.List;

public interface ClaimValidator {
    boolean isValid(Ticket ticket, List<Integer> announcedNumbers);
}