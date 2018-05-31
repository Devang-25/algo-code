package vecna;

import com.sun.istack.internal.logging.Logger;

public class DogSearch {

    public static final boolean DEBUG = false;

    public static void main(String[] args) {
        //This code will not compile correctly until you fix it.
        //
        //We are trying to count the number of times the word
        //dog appears in some input text, but we can't seem to
        //remember the appropriate method call in the String class,
        //and are not sure our approach will work.
        //task: Use the JDK documentation to help us finish the code,
        //then discuss the ambiguity in the problem description, and
        //reword it to remove the ambiguity in the space provided below.

        /*
            (Trivial) Improvement 1 : I removed the string constructor because it's just not necessary as strings are by default immutable in Java
            Ambiguities: 
                * The problem statement doesn't give any information about case sensitivity
                * It says word 'dog', but the code seems to try to find the string 'dog'. This means that according to the problem definition,
                words like hotdogs and dog-like shouldn't be included.
                * Better to put quotation marks for the text that needs to be searched
        
        
                This code will not compile correctly until you fix it.
                //
                //We are trying to count the number of times the string/text
                //"dog" appears in some input text, but we can't seem to
                //remember the appropriate method call in the String class,
                //and are not sure our approach will work.
                //task: Use the JDK documentation to help us finish the code,
                //then discuss the ambiguity in the problem description, and
                //reword it to remove the ambiguity in the space provided below.
        
            Fix: Added the next start index for the remaining sub string 
         */
        String input = "The Dogman was no ordinary dog, nor man, but rather a peculiar dog-like man who barked like a dog, and panted like a dog, he even ate like a dog.  He owned a dog named Doglips, and interestingly enough, his favorite food was hotdogs.";
        System.out.println(input);
        int index = -1;
        int start_index = 0;
        int count = 0;
        System.out.print("Counting dogs: ");
        do {
            index = input.indexOf("dog", start_index);
            if (index != -1) {
                start_index = index + 1;
                count++;
                if (DEBUG) {
                    Logger.getLogger(DogSearch.class).info("index : " + index);
                }
                System.out.print(count + " ");
            }
        } while (index != -1);
        System.out.println("\nThe word \"dog\" appears " + count + " times.");
    }
}
