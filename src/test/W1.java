package test;

import java.util.*;

/**
 * @author weib
 * @date 2022-04-16 15:01
 */
public class W1 {


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Character>> result = new ArrayList<>();
        // 首部
        for (int i = 0; i < n; i++) {
            List<Character> line = new ArrayList<>();
            for (int j = n-i; j > 0; j--){
                line.add('.');
            }
            for (int j = 2*n - line.size(); j > 0; j--){
                line.add('*');
            }
            List<Character> line2 = new LinkedList<>(line);
            Collections.reverse(line);
            line2.addAll(line);
            result.add(line2);
        }
        // 体
        for (int i = 0; i < n; i++) {
            List<Character> line = new ArrayList<>();
            for (int j = n; j > 0; j--){
                line.add('*');
            }
            for (int j = n; j > 0; j--){
                line.add('.');
            }
            List<Character> line2 = new LinkedList<>(line);
            Collections.reverse(line);
            line2.addAll(line);
            result.add(line2);
        }

        List<List<Character>> result2 = new ArrayList<>(result);
        Collections.reverse(result);
        result2.addAll(result);
        for (List<Character> characters : result2) {
            for (Character character : characters) {
                System.out.print(character);
            }
            System.out.println();
        }
    }

}
