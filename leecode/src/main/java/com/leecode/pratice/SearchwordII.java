package com.leecode.pratice;

import java.util.ArrayList;
import java.util.List;

public class SearchwordII {
    class TrieNode{
        TrieNode[] children;
        String word;
        public TrieNode(){
            children = new TrieNode[26];
            word = null;
        }
    }
    class Solution {
        private TrieNode root = new TrieNode();
        private List<String> res;
        private int m, n, maxLen;
        private char[][] board;

        public List<String> findWords(char[][] board, String[] words) {
            this.res = new ArrayList<>();
            for(String word : words){
                if(word.length()==0)continue;
                addWord(word);
                maxLen = Math.max(maxLen, word.length());
            }
            this.board = board;
            this.m = board.length;
            this.n = board[0].length;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    search(i,j,0,root);
                }
            }
            return res;
        }

        private void search(int x, int y, int length, TrieNode root){
            char cur = this.board[x][y];
            if(cur == '#' ||
                    length > maxLen ||
                    root.children[cur-'a'] == null)return;
            TrieNode child = root.children[cur-'a'];
            if(child.word!=null){
                this.res.add(child.word);
                //to avoid adding next time
                child.word = null;
            }

            this.board[x][y] = '#';
            if(y<n-1)search(x, y+1, length+1, child);
            if(x<m-1)search(x+1,y,length+1,child);
            if(y>0)search(x,y-1,length+1,child);
            if(x>0)search(x-1,y,length+1,child);
            this.board[x][y] = cur;
        }

        private void addWord(String word){
            int wn = word.length(),
                    index = 0;
            TrieNode cur = this.root;
            while(index<wn){
                if(cur.children[word.charAt(index)-'a'] == null){
                    cur.children[word.charAt(index)-'a'] = new TrieNode();
                }
                cur = cur.children[word.charAt(index)-'a'];
                index++;
            }
            cur.word = word;
        }
    }
}
