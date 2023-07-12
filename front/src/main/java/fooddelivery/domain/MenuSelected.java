package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class MenuSelected extends AbstractEvent {

    public MenuSelected(Order aggregate) {
        super(aggregate);
    }

    public MenuSelected() {
        super();
    }
}
