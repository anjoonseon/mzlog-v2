import mzlog.MzlogApp;
import mzlog.Review;
import mzlog.Store;

public class Main {
    public static void main(String[] args) {
        MzlogApp app = new MzlogApp();

        app.addStore(new Store(1, "카츠맛집", "일식"));
        app.addStore(new Store(2, "국밥천국", "한식"));

        app.addReview(new Review(1, 1, "joonseon", 5, "가성비 좋고 데이트 추천"));
        app.addReview(new Review(2, 1, "kim", 4, "맛있는데 웨이팅 있음"));
        app.addReview(new Review(3, 2, "lee", 3, "무난한 편"));

        System.out.println("== stores ==");
        for (Store s : app.listStores()) System.out.println(s);

        System.out.println("== reviews(storeId=1) ==");
        for (Review r : app.listReviewsByStore(1)) System.out.println(r);

        System.out.println("avg(storeId=1) = " + app.averageRating(1));

        System.out.println("== ranking by avg rating ==");
        for (Store s : app.rankStoresByAvgRatingDesc()) {
            System.out.println(s.getName() + " avg=" + app.averageRating(s.getId()));
        }

        System.out.println("== exception tests ==");

// (1) 중복 store id
        try {
            app.addStore(new Store(1, "중복가게", "한식"));
            System.out.println("ERROR: duplicate store test failed");
        } catch (IllegalArgumentException e) {
            System.out.println("OK duplicate store: " + e.getMessage());
        }

// (2) 없는 storeId에 리뷰 등록
        try {
            app.addReview(new Review(99, 999, "nope", 5, "없는 가게"));
            System.out.println("ERROR: missing store test failed");
        } catch (IllegalArgumentException e) {
            System.out.println("OK missing store: " + e.getMessage());
        }

    }
}
