import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args)
    {
        //String mega = Mega.mega;
        String itemCategories = "wxyzzyxwz";
        int k = 1;
        int part = countValidPartitionsOptimized(Mega.mega,k);
        System.out.println(part);
        int validPartitions = countValidPartitions(Mega.mega, k);
        System.out.println("validPartitions: " + validPartitions);
    }

    public static int countValidPartitions(String itemCategories, int k)
    {
        int validPartitions = 0;
        HashMap<Integer,Character> prefix = new HashMap<>();
        HashMap<Character,Character> found = new HashMap<>();
        StringBuilder suffix = new StringBuilder(itemCategories);
        boolean continues = true;
        int i = 0;
        int countSuffix;

        while(continues)
        {
            prefix.put(i,itemCategories.charAt(i));
            suffix.deleteCharAt(0);
            i++;
            found.clear();

            for(int j = 0; j < prefix.size(); j++)
            {
                if(suffix.indexOf(prefix.get(j).toString()) >= 0)
                {
                    found.put(prefix.get(j),prefix.get(j));
                }
            }
            countSuffix = found.size();
            if(countSuffix > k)
            {
                validPartitions++;
            }

            if(suffix.isEmpty())
            {
                continues = false;
            }

            /*System.out.println("itemCategories: " + itemCategories);
            System.out.println("k: " + k);
            System.out.print("Preffix: ");
            for(int l = 0; l < prefix.size(); l++)
            {
                System.out.print(prefix.get(l));
            }
            System.out.println("\nSuffix: " + suffix);
            System.out.println("countSuffix: " + countSuffix  + "\n");

             */

        }
        return validPartitions;
    }

    public static int countValidPartitionsOptimized(String itemCategories, int k){

        HashSet<Character> prefix = new HashSet<>();
        HashMap<Character,Integer> suffix = new HashMap<>();
        int sharedCount = 0;
        for(int i = 0; i < itemCategories.length(); i++){
            char c = itemCategories.charAt(i);
            int count = suffix.getOrDefault(c,0);
            count++;
            suffix.put(c,count);
        }

        for(int i = 0; i < itemCategories.length(); i++){
            char c = itemCategories.charAt(i);
            int count = suffix.getOrDefault(c,0);
            if(count == 1){
                suffix.remove(c);
                prefix.remove(c);
            }
            else{
                count--;
                prefix.add(c);
                suffix.put(c,count);
            }
            if(prefix.size() > k){
                sharedCount++;
            }
        }
        return sharedCount;
    }
}
