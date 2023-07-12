package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PaymentCompleted extends AbstractEvent {

    public PaymentCompleted(Order aggregate) {
        super(aggregate);
    }

    public PaymentCompleted() {
        super();
    }
}
