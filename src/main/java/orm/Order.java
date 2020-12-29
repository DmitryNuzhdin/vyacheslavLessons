package orm;

import javax.persistence.*;

@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn
    private Consumer consumer;

    public Order(Consumer consumer) {
        this.consumer = consumer;
    }

    public Order() {
    }

    public long getId() {
        return id;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", consumer=" + consumer +
                '}';
    }
}
