package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderReceived extends AbstractEvent {

    public OrderReceived(Order aggregate) {
        super(aggregate);
    }

    public OrderReceived() {
        super();
    }
}
