package com.sunny.grokkingalgorithms.ctci.c3;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sundas on 3/18/2018.
 */
enum AnimalType{
  CAT,
  DOG
}
class Animal{
  protected String name;
  protected  AnimalType animalType;
  protected Date arrivalTime;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AnimalType getAnimalType() {
    return animalType;
  }

  public void setAnimalType(AnimalType animalType) {
    this.animalType = animalType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Animal animal = (Animal) o;

    if (!getName().equals(animal.getName())) return false;
    if (getAnimalType() != animal.getAnimalType()) return false;
    return getArrivalTime().equals(animal.getArrivalTime());

  }

  @Override
  public int hashCode() {
    int result = getName().hashCode();
    result = 31 * result + getAnimalType().hashCode();
    result = 31 * result + getArrivalTime().hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Animal{" +
        "name='" + name + '\'' +
        ", animalType=" + animalType +
        ", arrivalTime=" + arrivalTime +
        '}';
  }

  public Date getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(Date arrivalTime) {
    this.arrivalTime = arrivalTime;
  }
}
class Cat extends Animal{
  public Cat() {
  }


}
class Dog extends Animal{

  public Dog() {
  }


}
public class AnimalShelter {

  /*
  Animal shelter operates in FIFO order and can have cats and dogs. Customers can select a cat or a dog and the oldest
  (based on arrival time) will    be returned. They can also select any which will return the oldest of all animals.
  Implement dequeueAny, dequeueCat and dequeuDog. You can use LinkedList data structure.
   */

  /**
   * Separate queues for separate animals
   */
  private Queue<Cat> catQueue;

  private Queue<Dog> dogQueue;

  /**
   *
   */
  public AnimalShelter(){
    this.catQueue = new LinkedList<>();
    this.dogQueue = new LinkedList<>();
  }

  /**
   *
   * @param animal
   */
  public void enqueue(Animal animal){
    if(animal instanceof  Cat){
      catQueue.add((Cat)animal);
    }
    else if(animal instanceof Dog){
      dogQueue.add((Dog)animal);
    }
  }

  /**
   *
   * @return
   */
  public Cat dequeueCat(){
    Cat cat = null;
    if(!catQueue.isEmpty()){
      cat = catQueue.poll();
    }
    return cat;
  }


  /**
   *
   * @return
   */
  public Dog dequeueDog(){
    Dog dog = null;
    if(!dogQueue.isEmpty()){
      dog = dogQueue.poll();
    }
    return dog;
  }


  /**
   *
   * @return
   */
  public Animal dequeueAny(){
    Animal animal = null;
    if(!catQueue.isEmpty() && !dogQueue.isEmpty()){
      if(catQueue.peek().arrivalTime.before(dogQueue.peek().arrivalTime)){
        animal = catQueue.poll();
      }
      else{
        animal = dogQueue.poll();
      }
    }
    else if(!dogQueue.isEmpty()){
      animal = dogQueue.poll();
    }
    else if(!catQueue.isEmpty()){
      animal = catQueue.poll();
    }
    return animal;
  }

  /**
   *
   */
  public static void sleepForOneSec(){
    try {
      Thread.currentThread().sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    AnimalShelter animalShelter = new AnimalShelter();
    Animal chuggy = new Dog();
    chuggy.setAnimalType(AnimalType.DOG);
    chuggy.setName("Chuggy");
    chuggy.setArrivalTime(new Date(System.currentTimeMillis()));
    animalShelter.enqueue(chuggy);
    sleepForOneSec();
    Animal fenix = new Cat();
    fenix.setName("Fenix");
    fenix.setAnimalType(AnimalType.CAT);
    fenix.setArrivalTime(new Date(System.currentTimeMillis()));
    animalShelter.enqueue(fenix);
    sleepForOneSec();
    Animal tiger = new Dog();
    tiger.setAnimalType(AnimalType.DOG);
    tiger.setName("Tiger");
    tiger.setArrivalTime(new Date(System.currentTimeMillis()));
    animalShelter.enqueue(tiger);
    sleepForOneSec();
    Animal rapherl = new Cat();
    rapherl.setName("Raphael");
    rapherl.setAnimalType(AnimalType.CAT);
    rapherl.setArrivalTime(new Date(System.currentTimeMillis()));
    animalShelter.enqueue(rapherl);
    sleepForOneSec();
    Animal doby = new Dog();
    doby.setAnimalType(AnimalType.DOG);
    doby.setName("Doby");
    doby.setArrivalTime(new Date(System.currentTimeMillis()));
    animalShelter.enqueue(doby);
    sleepForOneSec();
    Animal claudio = new Cat();
    claudio.setName("Claudio");
    claudio.setAnimalType(AnimalType.CAT);
    claudio.setArrivalTime(new Date(System.currentTimeMillis()));
    animalShelter.enqueue(claudio);
    System.out.println(animalShelter.dequeueAny());
    System.out.println(animalShelter.dequeueCat());
    System.out.println(animalShelter.dequeueDog());
    System.out.println(animalShelter.dequeueAny());
    System.out.println(animalShelter.dequeueDog());
    System.out.println(animalShelter.dequeueCat());
  }

}