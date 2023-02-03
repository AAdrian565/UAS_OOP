public class Food {
    String name;
    int price;
    int timeToMake;

    public Food(String name, int price, int timeToMake) {
        this.name = name;
        this.price = price;
        this.timeToMake = timeToMake;

    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getTime() {
        return this.timeToMake;

    }
}
