package org.problems.dto;

import java.util.List;

public record User(int id, List<Product> products) {

    public List<Product> products() {
        return products;
    }

}
