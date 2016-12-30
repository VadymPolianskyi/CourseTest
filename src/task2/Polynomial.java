package task2;

public class Polynomial {
    public String process;
    public int multiplier = 4;
    public int power;

    public void searchPolynom(int a, int b, int n) {

        long result = 0;
//        кількість дій буде рівна "n*2 - 3"
        int actLength = n*2 - 3;
//      знаходимо центральну дію, після якої змінюється спадання степеня для "a" і
//        починається зростання степеня для "b"
        int median = (actLength-1)/2;
        process = "a^" + n;
        result += Math.pow(a,n);
        power = n-1;

        for (int i = 1; i < actLength-1; i ++) {
            //так як дія, що знаходиться в центрі завжди буде виглядати "коефіцієнт * a^2*b^2",
            //знаходимо її за медіаною дій і виводимо
            if (i == median) {
                process += "+" +multiplier + "*a^2*b^2";
                result += multiplier*Math.pow(a,2)*Math.pow(b,2);
                multiplier -= 2;
                power++;
            } else if (i < median) {
                process += "+" + multiplier + "*a^" + power + "*b";
                result += multiplier * Math.pow(a,power) * b;
                multiplier += 2;
                power--;
            } else if (i>median) {
                process += "+" + multiplier+"*a*b^"+power;
                result += multiplier * a * Math.pow(b,power);
                multiplier -= 2;
                power ++;
            }
        }

        process += "+b^" + n;
        result += Math.pow(b,n);

        System.out.println(process + " = " + result + "\n");
    }

}
