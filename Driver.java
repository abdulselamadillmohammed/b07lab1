// public class Driver {
//     public static void main(String [] args) {
//         Polynomial p = new Polynomial();
//         System.out.println(p.evaluate(3));

//         double [] c1 = {6,0,0,5};
//         Polynomial p1 = new Polynomial(c1);
//         double [] c2 = {0,-2,0,0,-9};
//         Polynomial p2 = new Polynomial(c2);
//         Polynomial s = p1.add(p2);
        
//         System.out.println("s(0.1) = " + s.evaluate(0.1));
//         if(s.hasRoot(1))
//             System.out.println("1 is a root of s");
//         else
//             System.out.println("1 is not a root of s");
//     }
// }

public class Driver {
    public static void main(String[] args) {
        // p1 = 6 + 5x^3  → coeffs [6, 5], exps [0, 3]
        Polynomial p1 = new Polynomial(
            new double[]{6, 5},
            new int[]{0, 3}
        );

        // p2 = -2x - 9x^4 → coeffs [-2, -9], exps [1, 4]
        Polynomial p2 = new Polynomial(
            new double[]{-2, -9},
            new int[]{1, 4}
        );

        //p2.getCoefficients();
        Polynomial s = p1.add(p2); // expected: 6 - 2x + 5x^3 - 9x^4

        // Prefer toString() if available:
        System.out.println("p1 + p2 = " + s);
        s.getCoefficients();
        //s.getExponents();
        // If no toString(), and you added getters temporarily:
        // System.out.println("coeffs: " + java.util.Arrays.toString(s.getCoefficients()));
        // System.out.println("exps:   " + java.util.Arrays.toString(s.getExponents()));
    }
}
