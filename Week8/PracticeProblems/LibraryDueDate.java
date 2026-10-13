
import java.time.LocalDate;
import java.util.*;

interface LibraryItem {
    LocalDate getDueDate();
}

class Book implements LibraryItem {
    private LocalDate currentDate;

    Book(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public LocalDate getDueDate() {
        return currentDate.plusDays(14);
    }
}

class DVD implements LibraryItem {
    private LocalDate currentDate;

    DVD(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public LocalDate getDueDate() {
        return currentDate.plusDays(7);
    }
}

class Magazine implements LibraryItem {
    private LocalDate currentDate;

    Magazine(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public LocalDate getDueDate() {
        return currentDate.plusDays(3);
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        LocalDate currentDate = LocalDate.parse("2023-10-26");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(
                    line.indexOf('"') + 1,
                    line.lastIndexOf('"'));

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book(currentDate);
                    break;
                case "DVD":
                    item = new DVD(currentDate);
                    break;
                default:
                    item = new Magazine(currentDate);
            }

            System.out.println(title + ": " + item.getDueDate());
        }

        sc.close();
    }
}
