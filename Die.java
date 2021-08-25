import java.lang.Math;
import java.util.Random;

public class Die { // Create dice objects named Die
  private int diceNum;
  private Random random = new Random(); 
  // Setter
  public void setDiceNum(int diceValue) {
    diceNum = diceValue;
  }
  // Getter
  public int getDiceNum() {
    return diceNum;
  }
  // Randomize dice roll
  public void roll() {
    diceNum = random.nextInt(6) + 1;
  }
  
  @Override
  public boolean equals(Object other) {
    if (other == null){
      return false;
    }
    if (this.getClass() != other.getClass()) {
      return false;
    }
    if (this.diceNum != ((Die)other).diceNum) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    String s;
    if (diceNum == 1) {
      s = "one";
    } else if (diceNum == 2) {
      s = "two";
    } else if (diceNum == 3) {
      s = "three";
    } else if (diceNum == 4) {
      s = "four";
    } else if (diceNum == 5) {
      s = "five";
    } else {
      s = "six";
    } return s;
  } 
}