import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        int n = reader.nextInt();
        int prev = -1;
        int answer = 0;

        for(int i = 0; i < n; i++) {
            int cur = reader.nextInt();

            if(cur == 0 || (cur != 3 && cur == prev)) {
                answer++;
                prev = 0;
                continue;
            }

            if(prev > 0 && prev < 3 && cur == 3) {
                prev = 3 - prev;
            } else {
                prev = cur;
            }
        }

        writer.println(answer);
        writer.close();
        reader.close();
    }
}