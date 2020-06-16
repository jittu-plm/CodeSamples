package com.jiten.samples;

public class JavDinamicDispatcher {
    public static void main(String[] args) {
        A a = new B();
        a.sum();  //If there is no sum() in class A, getting compile time error - cannot find symbol
    }
}


class A {
    public  void sum(){
        System.out.println("A - Sum");
    }
}



class B extends  A{
    public  void sum(){
        System.out.println("B - Sum");
    }
}