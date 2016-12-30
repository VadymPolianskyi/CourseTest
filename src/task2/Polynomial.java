package task2;

import task1.PascalsTriangle;


public class Polynomial {

    public void searchPolynom(int a, int b, int n) {
        String process;
        int power;

        PascalsTriangle pascalsTriangle = new PascalsTriangle();
//        коефіцієнтами біля кожної дії будуть відповідні елементи ряду трикутника Паскаля
        long[] coefficients = pascalsTriangle.rowN(n);

        long result = 0;
//        кількість дій буде рівна кількості елементів ряду трикутника Паскаля
        double actLength = coefficients.length;
//      знаходимо центральну дію, після якої змінюється спадання степеня для "a" і
//        починається зростання степеня для "b"
        int median = (int) (actLength-1)/2;

        process = "a^" + n;
        result += Math.pow(a,n);
        power = n-1;


        for (int i = 1; i < actLength-1; i ++) {
            //так як дія, що знаходиться в центрі завжди буде виглядати "коефіцієнт * a^2*b^2",
            //знаходимо її за медіаною дій і виводимо
            if (i == median) {
//                якщо кількість дій парна, то "центральна" дія повториться двічі
                if ((actLength/ 2 - (int) actLength/2) == 0) {
                    process += "+" + coefficients[i] + "*a^2*b^2";
                    process += "+" + coefficients[i] + "*a^2*b^2";
                    result += (coefficients[i]*Math.pow(a,2)*Math.pow(b,2))*2;

                    power+=2;
                    i++;
                } else {
//                    якщо ні - один раз
                    process += "+" + coefficients[i] + "*a^2*b^2";
                    result += coefficients[i]*Math.pow(a,2)*Math.pow(b,2);
                    power++;
                }

            } else if (i < median) {
//              після "центральної" дії степінь числа b буде щоразу збільшуватись на 1 до n
                process += "+" + coefficients[i] + "*a^" + power + "*b";
                result += coefficients[i] * Math.pow(a,power) * b;
                power--;
            } else if (i>median) {
//              перед "центральною" дією степінь числа а буде щоразу зменшуватись від n на 1
                process += "+" + coefficients[i] +"*a*b^"+power;
                result += coefficients[i] * a * Math.pow(b,power);
                power ++;
            }
        }
        process += "+b^" + n;
        result += Math.pow(b,n);

        System.out.println(process + " = " + result + "\n");
    }
}
