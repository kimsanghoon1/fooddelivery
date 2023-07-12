package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryAvailabilityChecked extends AbstractEvent {

    public DeliveryAvailabilityChecked(Order aggregate) {
        super(aggregate);
    }

    public DeliveryAvailabilityChecked() {
        super();
    }
}
