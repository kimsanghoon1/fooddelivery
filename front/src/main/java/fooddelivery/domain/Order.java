package fooddelivery.domain;

import fooddelivery.FrontApplication;
import fooddelivery.domain.ConfirmationButtonTapped;
import fooddelivery.domain.CookingCompleted;
import fooddelivery.domain.CookingStarted;
import fooddelivery.domain.DeliveryAvailabilityChecked;
import fooddelivery.domain.DeliveryCompleted;
import fooddelivery.domain.DeliveryNotified;
import fooddelivery.domain.DeliveryStarted;
import fooddelivery.domain.MenuSelected;
import fooddelivery.domain.NotificationSent;
import fooddelivery.domain.OrderAccepted;
import fooddelivery.domain.OrderCancelled;
import fooddelivery.domain.OrderPlaced;
import fooddelivery.domain.OrderReceived;
import fooddelivery.domain.OrderRejected;
import fooddelivery.domain.OrderStatusChecked;
import fooddelivery.domain.PaymentCompleted;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)

    private String orderId;

    private String menu;

    @OneToOne
    private Payment payment;

    private String status;

    @PostPersist
    public void onPostPersist() {
        MenuSelected menuSelected = new MenuSelected(this);
        menuSelected.publishAfterCommit();

        PaymentCompleted paymentCompleted = new PaymentCompleted(this);
        paymentCompleted.publishAfterCommit();

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        OrderReceived orderReceived = new OrderReceived(this);
        orderReceived.publishAfterCommit();

        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();

        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();

        CookingStarted cookingStarted = new CookingStarted(this);
        cookingStarted.publishAfterCommit();

        CookingCompleted cookingCompleted = new CookingCompleted(this);
        cookingCompleted.publishAfterCommit();

        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();

        DeliveryAvailabilityChecked deliveryAvailabilityChecked = new DeliveryAvailabilityChecked(
            this
        );
        deliveryAvailabilityChecked.publishAfterCommit();

        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();

        DeliveryNotified deliveryNotified = new DeliveryNotified(this);
        deliveryNotified.publishAfterCommit();

        OrderStatusChecked orderStatusChecked = new OrderStatusChecked(this);
        orderStatusChecked.publishAfterCommit();

        NotificationSent notificationSent = new NotificationSent(this);
        notificationSent.publishAfterCommit();

        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();

        ConfirmationButtonTapped confirmationButtonTapped = new ConfirmationButtonTapped(
            this
        );
        confirmationButtonTapped.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }
}
