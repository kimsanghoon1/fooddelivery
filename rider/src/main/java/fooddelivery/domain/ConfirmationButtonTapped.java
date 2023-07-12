package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ConfirmationButtonTapped extends AbstractEvent {

    public ConfirmationButtonTapped(Order aggregate) {
        super(aggregate);
    }

    public ConfirmationButtonTapped() {
        super();
    }
}
