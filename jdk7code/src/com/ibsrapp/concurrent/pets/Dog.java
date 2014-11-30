package com.ibsrapp.concurrent.pets;

import java.util.Date;

public class Dog extends Pet {
  public Dog(String name) {
    super(name);
  }

  @Override
  public void examine() {
    System.out.println(new Date()+"  "+name+" Woof!");
  }
}
