package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int x = 5;
        System.out.println(Integer.toBinaryString(x));
        int[] arr = new int[]{1, 2, 34};
        List<Integer> list = Arrays.asList(1, 2, 3);
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    public static int ALPHABET_SIZE = 26;

    public TrieNode() {
        isEndOfWord = false;
        children = new TrieNode[ALPHABET_SIZE];
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;

        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;

        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }

        return cur.isEndOfWord;
    }

    public void delete(String word) {
        deleteString(word, 0, root);
    }

    public TrieNode deleteString(String word, int idx, TrieNode cur) {
        if(cur == null) {
            return cur;
        }

        if(idx == word.length()) {
            if(!cur.isEndOfWord) {
                return cur;
            } else {
                if(getNumberOfChildren(cur) == 0) {
                    return null;
                } else {
                    return cur;
                }
            }
        }

        int charIdx = word.charAt(idx) - 'a';

        if(cur.children[charIdx] != null) {
            cur.children[charIdx] = deleteString(word, idx + 1, cur.children[charIdx]);
            if(getNumberOfChildren(cur) == 0 && !cur.isEndOfWord) {
                return null;
            } else {
                return cur;
            }
        }

        return cur;
    }

    private int getNumberOfChildren(TrieNode cur) {
        int count = 0;
        for(int i = 0; i < TrieNode.ALPHABET_SIZE; i++) {
            if(cur.children[i] != null) {
                count++;
            }
        }

        return count;
    }

    public void printTrie() {
        System.out.println("---- PRINTING TRIE ----");
        print(root, new StringBuilder());
    }

    public void print(TrieNode cur, StringBuilder stringBuilder) {
        if(cur == null) {
            return;
        }

        if(cur.isEndOfWord) {
            System.out.println(stringBuilder.toString());
        }

        for(int i = 0; i < TrieNode.ALPHABET_SIZE; i++) {
            if(cur.children[i] != null) {
                stringBuilder.append((char)('a' + i));
                print(cur.children[i], stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
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