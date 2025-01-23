package com.jroman5.api.Model.DTO;

import java.util.ArrayList;
import java.util.List;

public class CustomerDTO {

        private Long id;
        private String firstName;
        private String lastName;
        private List<OrderDTO> orders;

    public CustomerDTO(Long id, String firstName, String lastName, List<OrderDTO> orders) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = orders;
    }

    public CustomerDTO(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public CustomerDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", orders=" + orders +
                '}';
    }
}
