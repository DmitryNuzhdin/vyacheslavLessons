package orm;


import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Consumer {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy = "consumer", fetch = FetchType.EAGER)
    private List<Order> orders;

    public Consumer(String name) {
        this.name = name;
    }

    public Consumer() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orders_ids='" + orders.stream().map(o -> String.valueOf(o.getId())).collect(Collectors.joining(",")) +
                '}';
    }
}
