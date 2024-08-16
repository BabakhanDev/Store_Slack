public class Device extends Product {
    private String brand;
    private String color;
    private String isNew;
    private int memory;

    public Device(String name, String description, int price,
                  String createdAt, String brand, String color, String isNew, int memory) {
        super(name, description, price, createdAt);
        this.brand = brand;
        this.color = color;
        this.isNew = isNew;
        this.memory = memory;
    }


}
