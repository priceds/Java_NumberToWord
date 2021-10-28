import java.util.*;

public class NumberToWord {
    String convertedWord;

    String single_digit[] = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", };

    String tens_power[] = { "Hundred", "Thousand", "Lakh", "Crore" };

    String double_digit[] = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Ninteen", };

    String tens_multiple[] = { "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninty" };

    //     Function That Converts Number Into Words
    public String convertToWord(int input_number) {
        int n = 1;
        int word;
        convertedWord = "";
//        Following Switch Case Will Use Routine Digit Seperation To Choose Appropriate Word And Prefix From String Arrays
        while (input_number != 0) {
            switch (n) {
                case 1:

                    word = input_number % 100;

                    filterAndPass(word);
                    if (input_number > 100 && input_number % 100 != 0) {
                        appendToFinalString("And ");
                    }
                    input_number /= 100;

                    break;

                case 2:

                    word = input_number % 10;

                    if (word != 0) {
                        appendToFinalString(" ");
                        appendToFinalString(tens_power[0]);
                        appendToFinalString(" ");
                        filterAndPass(word);
                    }
                    input_number /= 10;

                    break;

                case 3:
                    word = input_number % 100;

                    if (word != 0) {
                        appendToFinalString(" ");
                        appendToFinalString(tens_power[1]);
                        appendToFinalString(" ");
                        filterAndPass(word);
                    }
                    input_number /= 100;

                    break;

                case 4:
                    word = input_number % 100;

                    if (word != 0) {
                        appendToFinalString(" ");
                        appendToFinalString(tens_power[2]);
                        appendToFinalString(" ");
                        filterAndPass(word);
                    }
                    input_number /= 100;

                    break;

                case 5:
                    word = input_number % 100;

                    if (word != 0) {
                        appendToFinalString(" ");
                        appendToFinalString(tens_power[3]);
                        appendToFinalString(" ");
                        filterAndPass(word);
                    }
                    input_number /= 100;

                    break;

            }
            n++; //iterate next condition
        }
        return convertedWord;// return the created string of words
    }

//    Function That Will Test The Numbers With Certain Condition And Will Append The Final String With Appropriate Words From Corresponding
//   String Array For  Corresponding Number & It's Precedence


    public void filterAndPass(int number) {
        int word, wordIndex;
//        Condition To Check If Number Is Less Than 10
        if (number < 10) {
            appendToFinalString(single_digit[number]);
        }
//        Condition To Check If Number Is Double Digit
        if (number > 9 && number < 20) {
            appendToFinalString(double_digit[number - 10]);
        }
//        Condition To Check If Number is Greater than 19 if yes choose ten's Multiple
        if (number > 19) {
            word = number % 10;
            if (word == 0) {
                wordIndex = number / 10;
                appendToFinalString(tens_multiple[wordIndex - 2]);
            } else {
                wordIndex = number / 10;
                appendToFinalString(single_digit[word]);
                appendToFinalString(" ");
                appendToFinalString(tens_multiple[wordIndex - 2]);
            }
        }
    }

    //    Function That Appends Each Word For Corresponding In final String
    public void appendToFinalString(String wordToAdd) {
        String temp_string;
        temp_string = convertedWord;
        convertedWord = wordToAdd;
        convertedWord += temp_string;
    }

    //    Driver Code
    public static void main(String[] args) {
        int decimal_value=0;
        int number_to_convert=0;
        int dot_index=0;
        int input_valueAsInt=0;
        double input_valueAsDouble=0;
        boolean decimal_point=false;
        String input_value="";

        NumberToWord w = new NumberToWord();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number: ");
        input_value = scanner.nextLine();
        input_valueAsDouble=Double.parseDouble(input_value);
        input_valueAsInt=(int)input_valueAsDouble;




//        Condition to Check If Input is Within Boundaries
        if(input_valueAsInt<0||input_valueAsInt>99999999)
        {
            System.out.println("Input Value Out Of Range");
        }
        else
        {
            if(input_valueAsInt==0)
            {
                System.out.println("Rs.0 ONLY");
            }
            else
            {
                //           Condition To Check If Input Contains Floating Decimal Point If -> Exists -> Then Split The Number And Floating Point
                if(input_value.contains("."))
                {
                    dot_index = input_value.indexOf(".");
                    decimal_value = Integer.parseInt(input_value.substring(dot_index+1,input_value.length()));
                    number_to_convert=Integer.parseInt(input_value.substring(0,dot_index));
                    decimal_point=true;
                }
//            OtherWise If Number Doesnt Contain Floating Decimal Point Take Number As Is
                else
                {
                    number_to_convert = Integer.parseInt(input_value);
                }


//         Call To Conversion Function That Will Return String Containing Word Value Of Digits
                String numberInWords = w.convertToWord(number_to_convert);

//            If Number Contained Floating Point Decimals Then We Will Print The Returned String With Format Given For Floating Point Decimals
                if(decimal_point==true)
                {
                    System.out.println("Rs. "+numberInWords+" "+decimal_value+"/100" +" ONLY");
                }
                else
                {
                    System.out.println("Rs. "+numberInWords+" ONLY");
                }
            }
        }

    }
}