/* Zeb Fischer-Crawford 
 * Dr. Steinberg
 * COP3330 Spring 2022
 * Programming Assignment 2
 */

public class TextAnalysis {
 
    private int limit;
    private String[] data = new String[limit];
    private int[] alphabet = new int[26];
    private int[] wordsize = new int[15];
    private int[] wordcount = new int[30];
    
  
    private String strAlphabet = "abcdefghijklmnopqrstuvwxyz";
  
    // Overloaded Constructor
    public TextAnalysis(int limit, String[] data){
        this.limit = limit;
        this.data = data;
    }
   
    /** This non-static method will display the content of
     * text document stored in the class object data
     * attribute. Each sentence will be displayed on its own line. 
     * */
    public void display(){
        for(int i = 0; i < data.length; i++){
            System.out.println(data[i]);
        }
    }
  
    /** This non-static method will display the content of
     * the analyses done in the text stored for the
     * respective class object in a simple table format. 
     * */
    public void tableDisplay(){
        int count = 0;
        char letter;
  
        System.out.printf("Letter\t  Count\n");
        while(count < 26){
            letter  = Character.toUpperCase(strAlphabet.charAt(count));
            System.out.printf(letter + "     %d\n", alphabet[count]);
            count++;
        }
  
        count = 1;
        System.out.println("---------------------------------");
        System.out.printf("Word Length\tOccurances\n");
        while(count <= 15){
            System.out.printf((count) + "\t   %d\n", wordsize[count - 1]);
            count++;
        }
  
        count = 1;
        System.out.println("---------------------------------");
        System.out.printf("Sentence Length\t   Occurances\n");
        while(count <= 30){
            System.out.printf((count) + "\t\t  %d\n", wordcount[count - 1]);
            count++;
        }
    }

    /** This non-static method will analyze the letter characters in the document.
     * You do not need to worry about other characters used in sentences such as
     * the comma, period, semicolon, quotes, etc... The method will count each
     * respective character and store the information in alphabet
     * array. This information will get displayed in tableDisplay().
     * */
    public void letterAnalysis(){
        int i, j, num;
        String sentence;
        char[] temp;
  
        for(i = 0; i < data.length; i++){
            sentence = data[i].toLowerCase();
            temp = sentence.toCharArray();
            for(j = 0; j < sentence.length(); j++){
                num = strAlphabet.indexOf(temp[j]);
                if(num != -1){
                    alphabet[num] += 1;
                }
            }
        }
    }
  
    /**  This method will count the number of words used in each sentence.
     * The result of each sentence will be stored in the wordsize attribute.
     * Do not count the special characters as part of the words. This information
     * will get displayed in tableDisplay().
     * */
    public void wordAnalysis(){
        int i, j, length;
        String[] words;
        for(i = 0; i < data.length; i++){  
            words = formatString(data[i]);
           for(j = 0; j < words.length; j++){
            length = words[j].length();
            wordsize[length - 1] += 1;
           }
        }
    }

    /** This method will measure the length of each sentence. In simple terms
     * you will count the number of words contained in a sentence. You can assume 
     * that all sentences will have at least one word. The result of each sentence 
     * will be stored in the wordcount attribute. This information will get 
     * displayed in tableDisplay
     * */
    public void wordAnalysis(int num){
        int i, j, length;
        String[] words;
        if(num > limit || 0 > num){
            System.out.println("Exceeded and cannot produce an analysis on this component");
        }
        else {
            for(j = 0; j < num; j++){
                System.out.println(data[j]);
            }
            i = 0;
            while(i < num){
                words = formatString(data[i]);
                length = words.length;
                wordcount[length - 1]++;
                i++;
            }
        }
    }
    
    /**
     * This additional method will format each String in the array data
     * it will remove all numeric value and special 
     * characters and then return a String[] array
     * with the sentence split up in to the array
     */
    public String[] formatString(String str){
        String strSentence = str.replaceAll("’", "");
        strSentence = strSentence.replaceAll("'", "");
        char[] sentence = strSentence.toCharArray();
        char[] fSentence = new char[sentence.length];
        char temp;
        for(int i = 0; i < sentence.length; i++){
            temp = sentence[i];
            if(Character.isAlphabetic(temp)){
                fSentence[i] = temp;
            } else if(!Character.isAlphabetic(temp)){
                fSentence[i] = ' ';
            }
        }
        String strFinalSentence = String.valueOf(fSentence);
        strFinalSentence = strFinalSentence.replaceAll("\\s+", " ");
        String[] Final = strFinalSentence.split(" ");
        //System.out.println(strFinalSentence);
        return Final;
    }
 }
 