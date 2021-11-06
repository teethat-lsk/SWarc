

import java.util.Comparator;
import java.util.List;

public class HeightSortStrategy implements SortStrategy {
    // YOU MAY ADD UP TO 5 LINES OF CODE BELOW THIS COMMENT !! A LINE OF CODE MAY CONTAIN UP TO ONE SEMI-COLON !!
    public void customSort(List<Person> people) {
        people.sort((Person p1,Person p2) -> p1.getHeight()-p2.getHeight());
    }
}
