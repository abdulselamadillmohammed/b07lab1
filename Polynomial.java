import java.util.Arrays;


// This is the part which I need to modify
class Polynomial{
    
    // If you don't add visibility keyword, it defaults to package private
    
    // Supposed to contain non zero coefficents -> 
    // /Because no need to increment if you have exponents array

    // Eg. 6 - 2x + 5x^3
    private double[] coefficients; // [6, -2, 5]
    private int[] exponents; // [0,1,3]

    public Polynomial(){
        coefficients = new double[]{0};
        exponents = new int[]{0};
    }

    public Polynomial(double[] coeffs, int[] expos){
        coefficients = new double[coeffs.length];
        exponents = new int[expos.length];

        for (int i = 0; i < coefficents.length; i++){
            coefficients[i] = coeffs[i];
        }
        for (int i = 0; i < exponents.length; i++){
            exponents[i] = expos[i];
        }
    }


    // Save point:a49b170f02e9235959fad5e0e917a24549982b93

    public Polynomial add(Polynomial polynomial){
        // LOCAL: coefficients
        // LOCAL: exponents
        // INCOMING: polynomial.coefficients
        // INCOMING: polynomial.exponents

        int counter = 0;
        // Logically if you're only accounting for non zero coeffs, then it shouldn't matter if you take the len of expos or coeffs

        // These act as upper bounds
        int local_pointer = coefficents.length;
        int incoming_pointer = polynomial.coefficents.length;

        double summed_coeffs = new double[local_pointer + incoming_pointer];
        int summed_expos = new int[local_pointer + incoming_pointer];

        int local_start = 0;
        int incoming_start = 0;

        while ((local_start != local_pointer) && (incoming_start != incoming_pointer)) {
            if (exponents[local_start] == polynomial.exponents[incoming_start]){
                summed_coeffs[counter] = coefficents[local_start] + polynomial.coefficents[incoming_start];
                summed_expos[counter] = exponents[local_start] + polynomial.coefficents[incoming_start];

                incoming_start++;
                local_start++;
                counter++;
            }
            else if (exponents[local_start] < polynomial.exponents[incoming_start]){
                summed_coeffs[counter] = polynomial.coefficents[incoming_start];
                summed_expos[counter] =  polynomial.coefficents[incoming_start];
                incoming_start++;
                counter++;
            }
            else{
                summed_coeffs[counter] = coefficents[local_start];
                summed_expos[counter] = exponents[local_start];
                local_start++;
                counter++;
            }

        }
        



        // double[] bigger_arr;
        // double[] smaller_arr;

        // if (polynomial.coefficients.length > coefficients.length){
        //     bigger_arr = Arrays.copyOf(polynomial.coefficients, polynomial.coefficients.length);
        //     smaller_arr = coefficients;
        // }
        // // No need to watch out for "this" as there is no naming conflict. 
        // else{
        //     bigger_arr = Arrays.copyOf(coefficients, coefficients.length);
        //     smaller_arr = polynomial.coefficients;
        // }

        // for (int i = 0; i < smaller_arr.length; i++){
        //     bigger_arr[i] += smaller_arr[i];
        // }

        // return new Polynomial(bigger_arr);
    }

    public double evaluate(double value){
        double sum = 0;
        for (int i = 0; i < coefficients.length; i++){
            sum += coefficients[i] * Math.pow(value, i);
        }
        return sum;
    }

    public boolean hasRoot(double possibleRoot){
        boolean is_root = false;
        if (evaluate(possibleRoot) == 0){
            is_root = true;
        }
        return is_root;
    }

}