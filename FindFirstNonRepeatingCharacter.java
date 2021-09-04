class FindFirstNonRepeatingChar{

String str = "zzzzzbbbccccddehhhhiii";
int[] countingArray = new int[128];
str.chars().forEach(value -> countingArray[value]++);
int nonRepeatingCharAsInt = 0;
for (int i = 0; i < countingArray.length; i++) {
    if (countingArray[i] == 1) {
        nonRepeatingCharAsInt = i;
        break;
    }
}
System.out.println("character = " + Character.valueOf((char) nonRepeatingCharAsInt));
}
