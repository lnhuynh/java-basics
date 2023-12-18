package javaadvanced.designpattern;

class Pizza {

}

class Chef {
  public Pizza pizza;
//  private Pizza pizza;
  //Without DI
  Chef() {
    Pizza pizza = new Pizza();
  }

  //With DI
  Chef(Pizza pizza) {
    this.pizza = pizza;
  }

  public void setPizza(Pizza pizza) {
    this.pizza = pizza;
  }
}

public class DependenciesInjection {
  public static void main(String[] args) {
    //3 types of DI
    Pizza pizza = new Pizza();

    //Constructor injection
    Chef chef1 =  new Chef(pizza);

    //Setter injection
    Chef chef2 = new Chef();
    chef2.setPizza(pizza);

    //Field injection
    Chef chef3 = new Chef();
    chef3.pizza = pizza;

  }

}
