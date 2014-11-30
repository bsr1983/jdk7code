package com.ibsrapp.concurrent;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2014/11/17
 * Time: 15:15
 * To change this template use File | Settings | File Templates.
 */
public class Author {
    private final String name;

    public String getName() {
        return name;
    }

    public Author(String name_) {
        name = name_;
    }

    @Override
    public String toString() {
        return "Author [name=" + name + "]";
    }
}
