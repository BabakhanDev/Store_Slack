public class Book extends Product {
    private String authorFullName;


    public Book(String name, String description, int price,
                String createdAt, String authorFullName) {
        super(name, description, price, createdAt);
        this.authorFullName = authorFullName;
    }
}
