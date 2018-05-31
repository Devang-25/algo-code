package vecna;

public class PrimesImprovement {
    
    public static void main(String[] args) {

        //This code should print out the prime numbers.
        //task: Fix and improve the algorithm
        /* Answer :
        Bug 1 : Since every number is divisible by 1, j should start from 2
        Improvement 1 : Stoping the check for prime after the first divisor is found. ( && check in the inside for loop) or use 'break'
        Improvement 2 : Mathematically, it is guaranteed to find a divisor before square of a number (if it exists)
        
         */
        System.out.println("Printing primes from 1 to 100");
        int i;
        int j;
        boolean prime;
        for (i = 1; i <= 100; i++) {
            prime = true;
            for (j = 2; j <= Math.sqrt(i) && prime; j++) {
                if (i % j == 0) {
                    prime = false;
                }
            }

            if (prime) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
