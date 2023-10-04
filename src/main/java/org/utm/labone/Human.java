package org.utm.labone;

public class Human {
    private String name;
    private int age;
    private String program;
    private String group;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello, my name is " + this.name);
    }
    public void introduce(int group) {
        System.out.println("I am " + this.age + " years old, my group is FAF-" + this.group);
    }
    public void code(int program) {
        System.out.println(name + " has written " + this.program + " programs today.");
    }

}

