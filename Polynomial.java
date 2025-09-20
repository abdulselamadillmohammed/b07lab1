class Polynomial{
    
    // If you don't add visibility keyword, it defaults to package private
    private double[] coefficients;

    public Polynomial(){
        coefficients = new double[]{0};
    }

    public Polynomial(double[] arr){
        coefficients = new double[arr.length];
        for (int i = 0; i < arr.length; i++){
            coefficients[i] = arr[i];
        }
    }

    public Polynomial add(Polynomial polynomial){
        double[] bigger_arr;
        double[] smaller_arr;
        if (polynomial.length > coefficients.length){
            bigger_arr = Arrays.copyOf(polynomial.coefficients, polynomial.coefficients.length);
            smaller_arr = coefficients;
        }
        else{
            bigger_arr = Arrays.copyOf(this.coefficients, this.coefficients.length);
            smaller_arr = polynomial.coefficients;
        }
        for (int i = 0; i < smaller_arr.length; i++){
            bigger_arr[i] += smaller_arr[i];
        }
        return new Polynomial(bigger_arr);

    }

}