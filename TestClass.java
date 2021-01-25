public class TestClass {
  public static void main(String[] args) {
    LegoHat toque = new LegoHat("toque", 6);
    System.out.println(toque.toString());
    LegoItem sword = new LegoItem("sword", 40f);
    System.out.println(sword.toString());
    LegoItem shield = new LegoItem("shield", 70f);
    System.out.println(shield.toString());

    LegoMinifigure me = new LegoMinifigure("Rodney", toque, sword, shield);
    System.out.println(me.toString());
    System.out.println(me.name + " is swapping hands.");
    me.swapHands();
    System.out.println(me.toString());

    LegoMinifigure alex = new LegoMinifigure("Alex", shield);
    System.out.println(alex.toString());
    alex.wearHat(new LegoHat("visor", 3));
    System.out.println(alex.toString());
    System.out.println("Alex is good? " + alex.isGood("summer", 56f));

    System.out.println("me is good? " + me.isGood("winter", 56f));

    me.placeInLeftHand(new LegoItem("book", 10f));
    me.placeInRightHand(new LegoItem("book", 10f));

    System.out.println(me.toString());
    System.out.println("me is good? " + me.isGood("winter", 56f));

  }
}
