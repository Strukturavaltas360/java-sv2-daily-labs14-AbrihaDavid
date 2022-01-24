package day01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService {

    private List<Order> orders = new ArrayList<>();

    public void saveOrder(Order order) {
        orders.add(order);
    }

    public List<Order> findOrdersByStatus(String status){
        return orders.stream().
                filter(o -> o.getStatus().equals(status)).
                collect(Collectors.toList());
    }

    public long getNumberOfOrdersByStatus(String status){
        return orders.stream().
                filter(o -> o.getStatus().equals(status)).
                count();
    }
}
