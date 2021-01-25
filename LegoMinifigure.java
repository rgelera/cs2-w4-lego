class LegoHat {
  String style;
  int size;

  public LegoHat(String newStyle, int newSize) {
    style = newStyle;
    size = newSize;
  }

  public String toString() {
    String sizeString;
    if (size <= 3) {
      sizeString = "small";
    } else if (size <= 6) {
      sizeString = "medium";
    } else {
      sizeString = "large";
    }
    return "a " + sizeString + " " + style;
  }

  public int computeStyle(String season) {
    int rating = 5;
    switch(style) {
      case "toque":
        if (season == "summer") {
          rating = 1;
        } else if (season == "winter") {
          rating = 10;
        } else {
          rating = 5;
        }
        break;
      default:
        rating = 5;
    }
    return rating;
  }
}

class LegoItem {
  String name;
  float weight;

  public LegoItem(String newName, float newWeight) {
    name = newName;
    weight = newWeight;
  }

  public String toString() {
    return "a " + weight + "-gram " + name;
  }

  public boolean isHeavy(float threshold) {
    return weight >= threshold;
  }
}

public class LegoMinifigure {
  String name;
  LegoHat hat;
  LegoItem leftHand;
  LegoItem rightHand;

  public LegoMinifigure(String newName, LegoHat newHat, LegoItem newLeft, LegoItem newRight) {
    name = newName;
    hat = newHat;
    leftHand = newLeft;
    rightHand = newRight;
  }

  public LegoMinifigure(String newName, LegoHat newHat, LegoItem newLeft) {
    name = newName;
    hat = newHat;
    leftHand = newLeft;
  }

  public LegoMinifigure(String newName, LegoHat newHat) {
    name = newName;
    hat = newHat;
  }

  public LegoMinifigure(String newName, LegoItem newLeft) {
    name = newName;
    leftHand = newLeft;
  }

  public LegoMinifigure(String newName, LegoItem newLeft, LegoItem newRight) {
    name = newName;
    leftHand = newLeft;
    rightHand = newRight;
  }

  public LegoMinifigure(String newName) {
    name = newName;
  }

  public String toString() {
    String build = "A Lego minifigure named " + name;
    if (hat != null || leftHand != null || rightHand != null) {
      build += ", who is ";
      if (hat != null) {
        build += "wearing " + hat.toString();
        if (leftHand != null || rightHand != null) build += " and ";
      }
      if (leftHand != null) {
        build += "holding " + leftHand.toString() + " in the left hand";
        if (rightHand != null) build += " and ";
      }
      if (rightHand != null) {
        build += "holding " + rightHand.toString() + " in the right hand";
      }
      build += ".";
    }
    return build;
  }

  public void swapHands() {
    LegoItem temp;
    temp = leftHand;
    leftHand = rightHand;
    rightHand = temp;
  }

  public void wearHat(LegoHat newHat) {
    hat = newHat;
  }

  public void placeInLeftHand(LegoItem item) {
    leftHand = item;
  }

  public void placeInRightHand(LegoItem item) {
    rightHand = item;
  }

  public boolean isGood(String season, float threshold) {
    return hat != null && hat.computeStyle(season) >= 6 && (leftHand == null || !leftHand.isHeavy(threshold) && (rightHand == null || !rightHand.isHeavy(threshold)));
  }
}