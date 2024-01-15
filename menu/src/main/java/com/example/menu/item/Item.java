package com.example.menu.item;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.*;

public class Item {
    private final long id;

    @NotNull(message = "name is required")
    @Pattern(regexp="^[a-zA-Z ]+$", message="name must be a string")
    private final String name;

    @NotNull(message="price is required")
    @Positive(message="price must be positive")
    private final long price;

    @NotNull(message ="description is required")
    @Pattern(regexp="^[a-zA-Z ]+$",message="description must be a string")
    private final String description;

    @NotNull(message = "image is required")
    @URL(message = "image must be a URL")
    private final String image;
    public Item(long id, String name, long price, String description, String image){
        this.id=id;
        this.name=name;
        this.price=price;
        this.description=description;
        this.image=image;
    }
    @Id
    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public long getPrice(){
        return price;
    }
    public String getDescription(){
        return description;
    }
    public String getImage(){
        return image;
    }
    public Item updateWith(Item item){
        return new Item(this.id,item.name,item.price,item.description,item.image);
    }
}
