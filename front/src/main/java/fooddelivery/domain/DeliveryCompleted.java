package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryCompleted extends AbstractEvent {

    public DeliveryCompleted(Order aggregate) {
        super(aggregate);
    }

    public DeliveryCompleted() {
        super();
    }
}
