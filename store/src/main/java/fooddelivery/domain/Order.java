package fooddelivery.domain;

import fooddelivery.StoreApplication;
import fooddelivery.domain.DeliveryAvailabilityChecked;
import fooddelivery.domain.OrderReceived;
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

    private String status;

    @PostPersist
    public void onPostPersist() {
        OrderReceived orderReceived = new OrderReceived(this);
        orderReceived.publishAfterCommit();

        DeliveryAvailabilityChecked deliveryAvailabilityChecked = new DeliveryAvailabilityChecked(
            this
        );
        deliveryAvailabilityChecked.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = StoreApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public void acceptOrder() {
        //implement business logic here:

        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();
    }

    public void rejectOrder() {
        //implement business logic here:

        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();
    }

    public void startCooking() {
        //implement business logic here:

        CookingStarted cookingStarted = new CookingStarted(this);
        cookingStarted.publishAfterCommit();
    }

    public void finishCooking() {
        //implement business logic here:

        CookingCompleted cookingCompleted = new CookingCompleted(this);
        cookingCompleted.publishAfterCommit();
    }

    public static void orderAcceptancePolicy(OrderReceived orderReceived) {
        //implement business logic here:

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderReceived.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
}
