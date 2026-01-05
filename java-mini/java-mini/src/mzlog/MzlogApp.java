package mzlog;

import java.util.*;

public class MzlogApp {
    // stores: id -> Store
    private final Map<Long, Store> storeMap = new HashMap<>();
    // reviewsByStore: storeId -> List<Review>
    private final Map<Long, List<Review>> reviewsByStore = new HashMap<>();

    public void addStore(Store store) {
        if (storeMap.containsKey(store.getId())) {
            throw new IllegalArgumentException("duplicate store id: " + store.getId());
        }
        storeMap.put(store.getId(), store);
    }

    public void addReview(Review review) {
        if (!storeMap.containsKey(review.getStoreId())) {
            throw new IllegalArgumentException("store not found: " + review.getStoreId());
        }
        reviewsByStore.computeIfAbsent(review.getStoreId(), k -> new ArrayList<>()).add(review);
    }

    public List<Store> listStores() {
        return new ArrayList<>(storeMap.values());
    }

    public List<Review> listReviewsByStore(long storeId) {
        return new ArrayList<>(reviewsByStore.getOrDefault(storeId, Collections.emptyList()));
    }

    public double averageRating(long storeId) {
        List<Review> reviews = reviewsByStore.get(storeId);
        if (reviews == null || reviews.isEmpty()) return 0.0;

        int sum = 0;
        for (Review r : reviews) sum += r.getRating();
        return (double) sum / reviews.size();
    }

    public List<Store> rankStoresByAvgRatingDesc() {
        List<Store> stores = listStores();
        stores.sort((a, b) -> {
            double ar = averageRating(a.getId());
            double br = averageRating(b.getId());
            // 내림차순
            return Double.compare(br, ar);
        });
        return stores;
    }

}
