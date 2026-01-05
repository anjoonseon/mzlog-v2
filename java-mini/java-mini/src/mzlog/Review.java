package mzlog;

public class Review {
    private final long id;
    private final long storeId;
    private final String author;
    private final int rating; // 1~5
    private final String content;

    public Review(long id, long storeId, String author, int rating, String content) {
        if (author == null || author.isBlank()) throw new IllegalArgumentException("author is required");
        if (rating < 1 || rating > 5) throw new IllegalArgumentException("rating must be 1~5");
        if (content == null) content = "";
        this.id = id;
        this.storeId = storeId;
        this.author = author;
        this.rating = rating;
        this.content = content;
    }

    public long getId() { return id; }
    public long getStoreId() { return storeId; }
    public String getAuthor() { return author; }
    public int getRating() { return rating; }
    public String getContent() { return content; }

    @Override
    public String toString() {
        return "Review{id=" + id + ", storeId=" + storeId + ", author='" + author + "', rating=" + rating + ", content='" + content + "'}";
    }
}
