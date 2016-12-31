package task2;

import task1.PascalsTriangle;

public class Polynomial {
    String process;
    int power;
    long result;
    PascalsTriangle pascalsTriangle;

    private int a, b, n;

    public void searchPolynom(int a, int b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;
        result = 0;

//        коефіцієнтами біля кожної дії будуть відповідні елементи ряду трикутника Паскаля
        pascalsTriangle = new PascalsTriangle();
        long[] coefficients = pascalsTriangle.rowN(n);

//      кількість дій буде рівна кількості елементів ряду трикутника Паскаля
        double actCount = coefficients.length;
//      знаходимо центральну дію, після якої змінюється спадання степеня для "a" і
//        починається зростання степеня для "b"
        int median = (int) (actCount-1)/2;

        firstAction();
        for (int i = 1; i < actCount-1; i ++) {
            //так як дія, що знаходиться в центрі завжди буде виглядати "коефіцієнт * a^2*b^2",
            //знаходимо її за медіаною дій і виводимо
            if (i == median) {
//                якщо кількість дій парна, то "центральна" дія повториться двічі
                if ((actCount/ 2 - (int) actCount/2) == 0) {

                    medianAction((int) coefficients[i]);
                    medianAction((int) coefficients[i]);
                    i++;
                } else {
//                    якщо ні - один раз
                    medianAction((int) coefficients[i]);
                }
            } else if (i < median) {
                beforeMedianAction((int) coefficients[i]);
            } else if (i>median) {

                postMedianAction((int) coefficients[i]);
            }
        }
        lastAction();
        printResult();
    }

    public void postMedianAction(int coeficient){
//     після "центральної" дії степінь числа b буде щоразу збільшуватись на 1 до n
        process += "+" + coeficient +"*a*b^"+power;
        result += coeficient * a * Math.pow(b,power);
        power ++;
    }

    public void beforeMedianAction(int coeficient) {
//     перед "центральною" дією степінь числа а буде щоразу зменшуватись від n на 1
        process += "+" + coeficient + "*a^" + power + "*b";
        result += coeficient * Math.pow(a,power) * b;
        power--;
    }

    public void firstAction() {
        process = "a^" + n;
        result += Math.pow(a,n);
        power = n-1;
    }

    public void lastAction(){
        process += "+b^" + n;
        result += Math.pow(b,n);
    }

    public void medianAction(int coefficient) {
        process += "+" + coefficient + "*a^2*b^2";
        result += coefficient*Math.pow(a,2)*Math.pow(b,2);
        power++;
    }

    public void printResult() {
        System.out.println(process + " = " + result + "\n");

    }
}