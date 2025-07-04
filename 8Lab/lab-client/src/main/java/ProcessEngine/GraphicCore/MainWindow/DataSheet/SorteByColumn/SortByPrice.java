package ProcessEngine.GraphicCore.MainWindow.DataSheet.SorteByColumn;

import java.util.Collections;
import java.util.Vector;
import java.util.stream.Collectors;

public class SortByPrice {

    public static Vector<String[]> sortByPriceAscendingOrder(Vector<String[]> arr) {
        arr = arr.stream()
            .sorted((a, b) -> Double.compare(Double.parseDouble(a[6]), Double.parseDouble(b[6])))
            .collect(Collectors.toCollection(Vector::new));
        return arr;
    }

    public static Vector<String[]> sortByPriceDescendingOrder(Vector<String[]> arr) {
        Vector<String[]> sorted = sortByPriceAscendingOrder(arr);
        Collections.reverse(sorted);
        return sorted;
    }

}
