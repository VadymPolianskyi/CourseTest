package task1;

public class PascalsTriangle {
    int rowIndex;
    long[] row;

    public long[] rowN(int n) {
        if (n<0) {
            System.out.println("Ряду Паскаля з від'ємним індексом не існує..");
        } else if (n >66) {
            System.out.println("Програма не працює з індеком більшим за 66!");
        } else {
            rowIndex = n;
            row = new long[n+1];

            if (n==0) {
                printZeroRow();
            } else {

                for (int i = 0; i < n+1; i++) {
                    row = nextRow(row);
                }
                return row;
            }
        }
        return null;
    }


    public void printZeroRow() {
        System.out.println(1);
    }

    public long[] nextRow(long [] row) {
        long [] nextRow = new long [row.length];
        for (int i = 0; i < row.length; i++) {
            if (i == 0 || i == row.length-1) {
                nextRow[i] = 1;
            } else {
                nextRow[i] = row[i-1] + row[i];
            }


        }

        return nextRow;
    }
}
