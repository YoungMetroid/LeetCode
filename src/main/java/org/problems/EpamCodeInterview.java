package org.problems;

import org.problems.dto.DoubleObjects;
import org.problems.dto.Product;
import org.problems.dto.User;

import javax.sound.sampled.Port;
import java.util.*;
import java.util.stream.Collectors;

public class EpamCodeInterview {

    public EpamCodeInterview(){

        Product product1 = new Product(1,"Product1", true);
        Product product2 = new Product(2,"Product2", true);
        Product product3 = new Product(3,"Product3", true);
        Product product4 = new Product(4,"Product4", true);
        Product product5 = new Product(5,"Product5", true);
        Product product6 = new Product(6,"Product6", true);

        List<User> users = List.of(
                new User(1,new ArrayList<>(List.of(product2,product4)))
                ,new User(2,new ArrayList<>(List.of(product4,product1,product6)))
                ,new User(3,new ArrayList<>(List.of(product2,product4,product6)))
                ,new User(4,new ArrayList<>(List.of(product1,product2,product5,product6)))
                ,new User(5,new ArrayList<>(List.of(product2,product3,product5)))
                ,new User(6,new ArrayList<>(List.of(product2)))
        );


        users.stream().forEach(user ->{
            List<Product>products =user.products();
            products.stream().filter(p->p.id() == 5)
                    .findFirst()
                    .ifPresent(p->products.add(new Product(p.id(),p.name(),p.active())));
        });

        DoubleObjects<List<User>,Integer> duplicator = (list, id) -> list.forEach(user -> {
            List<Product> products = user.products();
            products.stream()
                    .filter(p -> p.id() == ((int)id))
                    .findFirst()
                    .ifPresent(p -> products.add(new Product(p.id(), p.name(), p.active())));
        });

        duplicator.search(users,1);
        duplicator.search(users,1);
/*
        users.stream().flatMap(x->x.products().stream()).toList()
                .stream()
                .limit(3)
                .sorted(Comparator.comparing(Produc))
                .collect(Collectors.groupingBy(Product::id)).;



 */





        int []top =
                users.stream()
                .flatMap(x->x.products().stream())
                .collect(Collectors.groupingBy(
                        Product::id,
                        Collectors.collectingAndThen(Collectors.counting(),Long::intValue))

                ).entrySet().stream().
                        sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .mapToInt(Map.Entry::getKey)
                        .limit(3)
                        .toArray();
        
         Arrays.stream(top).forEach(System.out::println);


        //(x->x.g)collect(Collectors.groupingBy(User::products,Collectors.counting()));

    }
}
