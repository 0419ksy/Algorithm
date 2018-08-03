package ETC;

import java.util.ArrayList;

public class test {
   
   static int[] arr = {1, 2, 3, 4, 5};
   static int m = 2;
   static int cnt = 0;
   
   public static void main(String[] args) {
      ArrayList<Integer> list = new ArrayList<>();
      recursive(0, list);
      System.out.println("cnt : "+cnt);
   }
   
   private static void recursive(int x, ArrayList list) {
      if (list.size() >= m) {
         for (int i = 0; i < list.size(); ++i) {
            System.out.print(list.get(i) + " ");
         }
         System.out.println();
         cnt++;
         return;
      }
      
      for (int i = x, length = arr.length; i < length; ++i) {
         ArrayList copy = new ArrayList(list);
         copy.add(arr[i]);
         
         recursive(i + 1, copy);
         
      }
   }

}