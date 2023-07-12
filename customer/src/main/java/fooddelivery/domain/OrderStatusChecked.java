package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderStatusChecked extends AbstractEvent {

    public OrderStatusChecked(Order aggregate) {
        super(aggregate);
    }

    public OrderStatusChecked() {
        super();
    }
}
