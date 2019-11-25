package com.sunny.grokkingalgorithms.boot2019.java;

import java.util.Objects;

class Key{
    public Key(int a, String b) {
        this.a = a;
        this.b = b;
    }

    int a;
    String b;

    @Override
    public String toString() {
        return "Key{" +
                "a=" + a +
                ", b='" + b + '\'' +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o instanceof Key){
            if((this.a == ((Key) o).a)
                    && (Objects.equals(b,((Key) o).b))){
                return true;
            }else{
                return false;
            }

        }else{
            return false;
        }
    }
}
public class ImplementingEqualsCorrectly {


    public static void main(String[] args) {
        Key key1 = new Key(1,"sunny");
        Key key2 = new Key(1,"sunny");
        System.out.println(key1.equals(key2));
    }

}
