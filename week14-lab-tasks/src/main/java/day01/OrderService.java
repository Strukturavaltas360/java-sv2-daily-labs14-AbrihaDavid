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

    public List<Order> getOrdersBetweenDates(LocalDate startDate, LocalDate endDate){
        return orders.stream().
                filter(s -> s.getOrderDate().isAfter(startDate)).
                filter(e -> e.getOrderDate().isBefore(endDate)).
                collect(Collectors.toList());
    }

    public boolean orderWithLessThan(int min){
        return orders.stream().
                anyMatch(o -> o.getProducts().size() < min);
    }

    public Order getOrderWithMostProduct(){
        return orders.stream().
                max(new Comparator<Order>() {
                    @Override
                    public int compare(Order o1, Order o2) {
                        return o1.getProducts().size() - o2.getProducts().size();
                    }
                }).get();

    }

    public List<Order> getOrdersWithProductCategory(String category){
        return orders.stream().
                filter(o->o.getProducts().stream().
                        anyMatch(p->p.getCategory().equals(category))).
                collect(Collectors.toList());
    }
}
