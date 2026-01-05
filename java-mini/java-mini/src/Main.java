import mzlog.Store;
import mzlog.Review;

public class Main {
    public static void main(String[] args) {
        Store s1 = new Store(1, "카츠맛집", "일식");
        Review r1 = new Review(1, 1, "joonseon", 5, "가성비 좋고 데이트 추천");
        System.out.println(s1);
        System.out.println(r1);
    }
}
