package com.ibsrapp.concurrent.pets;

public abstract class Pet {
  protected final String name;

  public Pet(String name) {
    this.name = name;
  }

  public abstract void examine();
}
