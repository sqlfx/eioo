package org.example;

public class Main {
    public static void main(String[] args) {

        AbstractFactory factory = new ConcreteFactory1();


        AbstractProductA productA = factory.createProductA();
        AbstractProductB productB = factory.createProductB();


        System.out.println("Создан: " + productA.getName());
        System.out.println("Создан: " + productB.getName());
    }
}
