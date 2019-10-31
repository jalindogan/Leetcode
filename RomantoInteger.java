import java.util.HashMap;
import java.util.Scanner;

class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(romanToInt(s));
        in.close();
    }

    static public int romanToInt(String s) {
        int total = 0; // actual integer
        char roman[] = s.toCharArray();
        int curr_int = 0;
        int next_int = 0;
        int i = 0;
        
        /* make sure its upper case */
        s = s.toUpperCase();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        /* Placing each conversion */
        map.put('I', 1);
        //map.put('IV', 4);   //
        map.put('V', 5);
        //map.put('IX', 9);   //
        map.put('X', 10);
        //map.put('XL', 40);  //
        map.put('L', 50);
        //map.put('XC', 90);  //
        map.put('C', 100);
        //map.put('CD', 400); //
        map.put('D', 500);
        //map.put('CM', 900); //
        map.put('M', 1000);
        
        while(i <= s.length()-1){
            curr_int = map.get(roman[i]);
            //System.out.println("current int: " + curr_int + " " + roman[i]);
            next_int = 0; // reset
            if(i != s.length()-1){
                next_int = map.get(roman[i+1]);
                //System.out.println("next int: " + next_int + " " + roman[i+1]);
            }

            if(curr_int >= next_int){
                total = curr_int + total;
            }else if (curr_int < next_int){
                //System.out.println(next_int + " - " + curr_int);
                int x  = next_int - curr_int;
                //System.out.println(" = " + x);
                total = x + total;
                i++;
            }
            i++;
        }

        return total;
    }
    
}