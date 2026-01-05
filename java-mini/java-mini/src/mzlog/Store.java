package mzlog;

public class Store {
    private final long id;
    private final String name;
    private final String category; // 한식/중식/일식/양식 등

    public Store(long id, String name, String category) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name is required");
        if (category == null || category.isBlank()) throw new IllegalArgumentException("category is required");
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return "Store{id=" + id + ", name='" + name + "', category='" + category + "'}";
    }
}
