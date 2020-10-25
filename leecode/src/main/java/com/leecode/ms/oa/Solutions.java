package com.leecode.ms.oa;

import com.leecode.pratice.TreeNode;

import java.util.*;

public class Solutions {

    int maxLength = 0;
    Stack<Integer> stack = new Stack();

    public static void main(String[] args) {
        Solutions s = new Solutions();
        int[] x1 = { 1, 1, 2 }, y1 = { 3, 2, 3 };
        int[] x2 = { 1, 1, 1 }, y2 = { 2, 2, 2 };
        int[] x3 = { 1, 2, 3, 1, 2, 12, 8, 4 }, y3 = { 5, 10, 15, 2, 4, 15, 10, 5 };
        System.out.println(s.numberOfSumUpToOne(x1, y1));
        System.out.println(s.numberOfSumUpToOne(x2, y2));
        System.out.println(s.numberOfSumUpToOne(x3, y3));
    }

    int without3Letters(String s) {
        if (s == null || s.length() <= 2) return 0;
        int cnt = 0, res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                cnt++;
            else
                cnt = 0;
            if (cnt == 3) {
                res++;
                cnt = 0;
            }
        }
        return res;
    }

    int maxNetworkRank(int[] A, int[] B, int N) {
        Map<Integer, Integer> map = new HashMap<>(N);
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            map.put(B[i], map.getOrDefault(B[i], 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res = Math.max(res, map.get(A[i]) + map.get(B[i]));
        }
        return res;
    }

    int minStepToPalindorme(String s) {
        if (s == null || s.length() < 2) return 0;
        int l = 0, r = s.length() - 1;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                set.add(l);
                set.add(r);
            } else {
                q.offer(l);
            }
            l++;
            r--;
        }
        if (set.size() >= s.length() - 1) return 0;
        int res = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            boolean match = false;
            if (s.charAt(curr) == s.charAt(s.length() - curr - 1)) {
                match = true;
            } else {
                for (int i = curr + 1; i < s.length(); i++) {
                    if (!set.contains(i)) {
                        if (s.charAt(curr) == s.charAt(i)) {
                            s = swap(s, curr, i);
                            set.add(curr);
                            set.add(i);
                            res++;
                            match = true;
                            break;
                        }
                    }
                }
            }
            if (!match) return -1;
        }
        return res;
    }

    String swap(String s, int i, int j) {
        return s.substring(0, i) + s.charAt(j) + s.substring(i + 1, j) + s.charAt(i) + s.substring(j);
    }

    String longestSub(String s) {
        if (s.length() < 3) return s;
        int start = 0, end = 1, max = 0, cnt = 1;
        String res = "";
        while (end < s.length()) {
            if (s.charAt(end) == s.charAt(end - 1)) {
                if (cnt == 3) continue;
                cnt++;
            } else {
                if (cnt == 3) {
                    start = end - 2;
                }
                cnt = 1;
            }
            if (cnt == 3) {
                if (end - start > max) {
                    max = end - start;
                    res = s.substring(start, start + max);
                }
            }
            end++;
        }
        if (cnt < 3) {
            if (end - start > max) {
                res = s.substring(start, end);
            }
        }
        return res;
    }

    String removeOne(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1))
                return s.substring(0, i) + s.substring(i + 1);
        }
        return s.substring(0, s.length() - 1);
    }

    String stringWithout3identical(String s) {
        StringBuilder sb = new StringBuilder();
        char last = s.charAt(0);
        int cnt = 1;
        for (char c : s.toCharArray()) {
            if (c == last) cnt++;
            else cnt = 1;
            if (cnt < 3) sb.append(c);
            last = c;
        }
        return sb.toString();
    }

    int stepToEqualHigh(int[] N) {
        if (N.length < 2) return 0;
        Arrays.sort(N);
        int res = 0, cnt = 1;
        for (int i = N.length - 2; i >= 0; i--) {
            if (N[i] != N[i + 1]) {
                res += cnt;
            }
            cnt++;
        }
        return res;
    }

    String dayOfWeek(String s, int k) {
        ArrayList<String> week = new ArrayList<>(Arrays.asList("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"));
        return week.get((week.indexOf(s) + k) % 7);
    }

    int maxInsertObtainLessThan3A(String s) {
        int cnt = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') cnt++;
            else {
                res += 2 - cnt;
                cnt = 0;
            }
            if (cnt > 2) return -1;
        }
        return res + 2 - cnt;
    }

    int concatenateString(String[] arr) {
        backtrack(arr, 0, "");
        return maxLength;
    }

    void backtrack(String[] arr, int start, String curr) {
        if (selfDuplicate(curr)) return;
        maxLength = Math.max(maxLength, curr.length());
        for (int i = start; i < arr.length; i++) {
            if (!selfDuplicate(arr[i])) {
                backtrack(arr, i + 1, curr + arr[i]);
            }
        }
    }

//    int adjacentSwapToRed(String s){
//        int l=0,r=s.length()-1,lr=-1,rr=-1,maxSwap=0;
//        while (l<=r){
//            if(s.)
//            if(s.charAt(l)=='R')lr=l;
//            if(s.charAt(r)=='R')rr=r;
//            if(s.charAt(l)=='W'&&lr!=-1){
//
//            }
//        }
//    }

    boolean selfDuplicate(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) return true;
            set.add(c);
        }
        return false;
    }

    int kAndMinusK(int[] A) {
        Set<Integer> set = new HashSet<>();
        int maxK = 0;
        for (int i : A) {
            if (set.contains(-i))
                maxK = Math.max(maxK, i);
            set.add(i);
        }
        return maxK;
    }

    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int max = n / 2;
        for (int i = 0; i < max; i++) {
            arr[i] = i - max;
            arr[n - i - 1] = max - i;
        }
        return arr;
    }

    int minDeleteToAB(String s) {
        int cntA = 0, res = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') cntA++;
        }
        res = Math.min(cntA, s.length() - cntA);
        int delB = 0;
        for (char c : s.toCharArray()) {
            if (c == 'B') {
                res = Math.min(res, delB + cntA);
                delB++;
            } else {
                cntA--;
            }
        }
        return res;
    }

    int allStablePeriod(int[] arr) {
        if (arr.length < 3) return 0;
        int cnt = 0, curr = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] - arr[i - 1] == arr[i + 1] - arr[i]) {
                curr++;
                cnt += curr;
            } else {
                curr = 0;
            }
        }
        return cnt;
    }

    List partitionNSubset(int[] A, int N) {
        PriorityQueue<LinkedList<Integer>> q = new PriorityQueue<>(Comparator.comparingInt(O -> O.getFirst()));
        List<List<Integer>> res = new LinkedList<>();
        for (int i = A.length - 1; i > A.length - N - 1; i--) {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(A[i]);
            list.add(A[i]);
            q.offer(list);
        }
        for (int i = A.length - N - 1; i >= 0; i--) {
            LinkedList<Integer> curr = q.poll();
            curr.add(A[i]);
            curr.set(0, curr.getFirst() + A[i]);
            q.offer(curr);
        }
        while (!q.isEmpty()) {
            LinkedList<Integer> curr = q.poll();
            curr.removeFirst();
            res.add(curr);
        }
        return res;
    }

    int widestPathWithoutTree(int[] X, int[] Y) {
        Arrays.sort(X);
        int width = 0;
        for (int i = 1; i < X.length; i++) {
            width = Math.max(width, X[i] - X[i - 1]);
        }
        return width;
    }

    boolean jumpGame(int[] A, int index) {
        if (index < 0 || index >= A.length) return false;
        if (A[index] == 0) return true;
        return jumpGame(A, index - A[index]) || jumpGame(A, index + A[index]);
    }

    int fairIndexNumber(int[] A, int[] B) {
        int sumA = 0, sumB = 0, res = 0, N = A.length;
        int[] dpA = new int[N + 1], dpB = new int[N + 1];
        for (int i = 0; i < N; i++) {
            sumA += A[i];
            sumB += B[i];
        }
        if (sumA != sumB) return 0;
        for (int i = 0; i < N; i++) {
            dpA[i + 1] = dpA[i] + A[i];
            dpB[i + 1] = dpB[i] + B[i];
            if (dpA[i + 1] == dpB[i + 1] && sumA - dpA[i + 1] == dpA[i + 1] && sumB - dpB[i + 1] == dpB[i + 1])
                res++;
        }
        return res;
    }

    int minMeetingRoom(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> endqueue = new PriorityQueue<>();
        endqueue.offer(intervals[0][1]);
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > endqueue.peek()) {
                endqueue.poll();
            }
            endqueue.offer(intervals[i][1]);
        }
        return endqueue.size();
    }

    int shineBulb(int[] A) {
        int res = 0, sum = 0, target = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            target += i + 1;
            if (sum == target) res++;
        }
        return res;
    }

    String cropWord(String s, int K) {
        s = s.trim();
        if (K >= s.length()) return s;
        String res = s.substring(0, K);
        if (s.charAt(K) == ' ') return res.trim();
        int lastBlank = res.lastIndexOf(' ');
        return (lastBlank == -1) ? "" : res.substring(0, lastBlank).trim();
    }

    int maxChunkToSort(int[] A) {
        int n = A.length;
        int[] minRight = new int[n + 1];
        minRight[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            minRight[i] = Math.min(A[i], minRight[i + 1]);
        }
        int max = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, A[i]);
            if (max <= minRight[i + 1])
                res++;
        }
        return res;
    }

    int MaxXOccurXTimes(int[] A) {
        int N = A.length, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > N) continue;
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        for (Integer i : map.keySet()) {
            if (i == map.get(i)) res = Math.max(res, i);
        }
        return res;
    }

    int MAligedSubset(int[] A, int M) {
        if (A == null || A.length == 0) return 0;
        int[] subset = new int[M];
        int res = 0;
        for (int i : A) {
            int index = i < 0 ? i % M + M : i % M;
            subset[index]++;
            res = Math.max(subset[index], res);
        }
        return res;
    }

    int minCostGetStringWithoutConsecutive(String s, int[] C) {
        if (s == null) return 0;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                res += Math.min(C[i], C[i - 1]);
                C[i] = Math.max(C[i], C[i - 1]);
            }
        }
        return res;
    }

    String riddle(String s) {
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        StringBuilder sb = new StringBuilder();
        char last = 'a', next;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '?') {
                if (i == s.length() - 1 || s.charAt(i + 1) == '?')
                    next = 'a';
                else
                    next = s.charAt(i + 1);
                curr = arr[(Math.max(last - 'a', next - 'a') + 1) % arr.length];
            }
            sb.append(curr);
            last = curr;
        }
        return sb.toString();
    }

    int visibleNode(TreeNode root) {
        return traverse(root, Integer.MAX_VALUE);
    }

    int traverse(TreeNode root, int max) {
        if (root == null) return 0;
        int res = 0;
        if (root.val > max) {
            res = 1;
            max = root.val;
        }
        return res + traverse(root.left, max) + traverse(root.right, max);
    }

    int hoursValidation(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d};
        Arrays.sort(arr);
        return backtrack(arr, 0, new boolean[4], new int[4]);
//         return res.size();
    }

    int backtrack(int[] arr, int index, boolean[] visited, int[] curr) {
        if (index == 4) {
            if (isHours(curr)) return 1;
        }
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if (!visited[i]) {
                if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1])
                    continue;
                curr[index] = arr[i];
                visited[i] = true;
                cnt += backtrack(arr, index + 1, visited, curr);
                visited[i] = false;
            }
        }
        return cnt;
    }

    boolean isHours(int[] curr) {
        return curr[0] * 10 + curr[1] < 24 && curr[2] * 10 + curr[3] < 60;
    }

    int checkGames(String[] B) {

        for (int a = 0; a < B.length; a++) {
            for (int i = 0; i < B[0].length(); i++)
                if (B[a].charAt(i) == 'O') {
                    return Math.max(dfs(B, a - 2, i - 2, -1), dfs(B, a - 2, i + 2, 1));
                }
        }
        return 0;
    }


    int dfs(String[] B, int i, int j, int direct) {
        if (i < 0 || j < 0 || j >= B[0].length() || B[i].charAt(j) == 'X' || B[i + 1].charAt(j - direct) != 'X')
            return 0;
        return 1 + Math.max(dfs(B, i - 2, j - 2, -1), dfs(B, i - 2, j + 2, 1));
    }

    int numberOfSumUpToOne(int[] X,int[] Y){
        int res=0;
        for(int i=0;i<X.length;i++){
            int gcd=gcd(Y[i],X[i]);
            X[i]=X[i]/gcd;
            Y[i]=Y[i]/gcd;
        }
        for(int i=0;i<X.length-1;i++){
            for(int j=i+1;j<Y.length;j++){
                if(Y[i]==Y[j]&&X[i]+X[j]==Y[i])
                    res++;
            }
        }
        return res;
    }

    int gcd(int x,int y){
        if(y==0)return x;
        return gcd(y,x%y);
    }
}
