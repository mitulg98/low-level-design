package org.example;

import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int n = reader.nextInt();

        double arr[] = new double[n];

        for(int i = 0; i < n; i++) {
            arr[i] = reader.nextDouble();
        }

        for(int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}

class Solver {
    public static int solve() {
        return 0;
    }
}

class FastReader {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer;

    public String next() throws IOException {
        if(Objects.isNull(tokenizer) || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public String nextLine() throws IOException {
        String line = "";
        if(tokenizer.hasMoreTokens()) {
            line = tokenizer.nextToken("\n");
        } else {
            line = reader.readLine();
        }
        return line;
    }
}