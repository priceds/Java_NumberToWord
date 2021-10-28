# Java Number To Word Conversion
Converting Given Number Between 0 & 99999999 to Words Using Indian Prefix like lakhs and crore.
# How It Works

Main Driver Functions Takes Any Number As String
Which is then converted to double before converting to int variable

Then Input Limits Given As Min = 0 and Max = 99999999 is checked and if input is outside of this then appropriate error message is displayed

then
We check input string (which contains inputted number) for any "." and digits after that
We split the numbers on either side of "." in two variables & boolean "decimal_point" is set to "true" if decimal point is present
If number doesn't have floating point , we directly convert string to int and pass value 
To "convertToWord()" function.

Now "convertToWord()" function has switch case style structure containing five cases to convert number to "tens","hundreds"& "thousands" using routine 
"Digit seperation method" of modulus and remainder and calling "filterAndPass()" function to choose appropriate word from array of strings
And pass on it to "appendToFinalString()" Method Where each word and prefix are added to string variable named "convertedWord" and when
All the switch case are passed then same string variable is then returned as value

Now in driver code we catch this return value in string variable , "now depending upon if number was decimal or with floating point
We wrote appropriate printline statements" , now in first input check block "we assigned value of isNumberFloatingPoint to true if it was
else left it as false", we refer this value to print appropriate message.

We also check for input value for zero , if it's zero we directly print appropriate message without going into main block of code.




