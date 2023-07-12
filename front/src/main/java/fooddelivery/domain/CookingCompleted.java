package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookingCompleted extends AbstractEvent {

    public CookingCompleted(Order aggregate) {
        super(aggregate);
    }

    public CookingCompleted() {
        super();
    }
}
