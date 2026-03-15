import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 도서 정보를 담을 클래스
class Book {
    int bookId;
    String category;
    int authorId;
    int price;
    String publishedDate; // 예시 포맷: "2021-01-01"

    public Book(int bookId, String category, int authorId, int price, String publishedDate) {
        this.bookId = bookId;
        this.category = category;
        this.authorId = authorId;
        this.price = price;
        this.publishedDate = publishedDate;
    }
}

public class TestBookListFilter {
    public void solution(List<Book> books) {
        List<Book> filteredBooks = new ArrayList<>();

        // 1. 조건 필터링: '인문' 카테고리 & 2021년 출판
        for (Book book : books) {
            if (book.category.equals("인문") && book.publishedDate.startsWith("2021")) {
                filteredBooks.add(book);
            }
        }

        // 2. 정렬: 출판일 기준 오름차순
        Collections.sort(filteredBooks, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.publishedDate.compareTo(b2.publishedDate);
            }
        });

        // 3. 결과 출력
        System.out.println("BOOK_ID\tPUBLISHED_DATE");
        for (Book book : filteredBooks) {
            System.out.println(book.bookId + "\t" + book.publishedDate);
        }
    }

    public static void main(String[] args) {
        TestBookListFilter filter = new TestBookListFilter();
        List<Book> bookList = new ArrayList<>();

        // 예시 데이터 삽입
        bookList.add(new Book(1, "인문", 1, 10000, "2020-01-01"));
        bookList.add(new Book(2, "경제", 2, 9000, "2021-02-05"));
        bookList.add(new Book(3, "인문", 2, 11000, "2021-04-11"));
        bookList.add(new Book(4, "인문", 3, 10000, "2021-03-15"));
        bookList.add(new Book(5, "생활", 1, 12000, "2021-01-10"));

        filter.solution(bookList);
    }
}