public class Robot {
  Food makeFood;
  String type;

  public Robot(String type, Food toMake) {
    this.type = type;
    this.makeFood = toMake;
  }

  public void run() {
    System.out.println("🟢 Robot " + type + " started");
    try {
      Thread.sleep(makeFood.getTime());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("🔴 Robot " + type + " finished");
  }

  public String getName() {
    return type;
  }
}
