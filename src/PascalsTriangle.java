import java.util.Arrays;

public class PascalsTriangle {
    int rowIndex;
    int[] row;

    public void rowN(int n) {
        if (n<=0) {
            System.out.println("Ряду Паскаля з від'ємним індексом не існує..");
        } else if (n >20) {
            System.out.println("Програма не працює з індеком більшим за 20!");
        } else {
            rowIndex = n;
            row = new int[n+1];

            if (n==0) {
                printZeroRow();
            } else {
                row[0] =1;
                row[row.length-1] = 1;
                for (int i = 1; i < row.length - 1; i++) {
                    row[i] = searchElement(i);
                }
                System.out.println(Arrays.toString(row) + "\n");
            }
        }
    }

    public long factorial(int number) {
        long result=1;
        for (; number > 0; result *= number--);

        return result;
    }

    public int searchElement(int index) {
        long element;
        element = factorial(rowIndex)/(factorial(index)*factorial(rowIndex-index));
        return (int) element;
    }

    public void printZeroRow() {
        System.out.println(1);
    }
}
