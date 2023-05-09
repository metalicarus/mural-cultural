package com.hobgobllin.mulralcultural.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "concert_halls")
public class ConcertHall extends BaseEntity {
 
    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private int capacity;

    public ConcertHall() {
    }

    public ConcertHall(String name, String address, int capacity) {
    	super();
    	super.setName(name);
        this.address = address;
        this.capacity = capacity;
    }
 
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // toString method for debugging purposes

    @Override
    public String toString() {
        return "ConcertHall{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
