package tambola.service;

import tambola.model.*;
import tambola.validator.*;

import java.util.*;

public class TambolaService {
    private final Map<ClaimType, ClaimValidator> validators = new HashMap<>();

    public TambolaService() {
        validators.put(ClaimType.TOP_ROW, new TopRowValidator());
        validators.put(ClaimType.MIDDLE_ROW, new MiddleRowValidator());
        validators.put(ClaimType.BOTTOM_ROW, new BottomRowValidator());
        validators.put(ClaimType.FULL_HOUSE, new FullHouseValidator());
        validators.put(ClaimType.EARLY_FIVE, new EarlyFiveValidator());
    }

    public boolean validateClaim(Ticket ticket, List<Integer> announced, ClaimType type) {
        return validators.get(type).isValid(ticket, announced);
    }
}