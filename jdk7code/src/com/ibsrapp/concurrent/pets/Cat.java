package com.ibsrapp.concurrent.pets;

import java.util.Date;

public class Cat extends Pet {
  public Cat(String name) {
    super(name);
  }

  public void examine() {
    System.out.println(new Date()+"  "+name+" Meow!");
  }
}