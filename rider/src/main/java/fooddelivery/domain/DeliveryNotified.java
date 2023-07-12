package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryNotified extends AbstractEvent {

    public DeliveryNotified(Order aggregate) {
        super(aggregate);
    }

    public DeliveryNotified() {
        super();
    }
}
