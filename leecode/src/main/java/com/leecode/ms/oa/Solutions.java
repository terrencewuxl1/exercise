package com.leecode.ms.oa;

import java.util.*;

public class Solutions {

    int without3Letters(String s){
        if(s==null||s.length()<=2)return 0;
        int cnt=0,res=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1))
                cnt++;
            else
                cnt=0;
            if(cnt==3){
                res++;
                cnt=0;
            }
        }
        return res;
    }

    int maxNetworkRank(int[] A, int[] B, int N){
        Map<Integer,Integer> map=new HashMap<>(N);
        for(int i=0;i<A.length;i++){
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            map.put(B[i],map.getOrDefault(B[i],0)+1);
        }
        int res=0;
        for(int i=0;i<A.length;i++){
            res=Math.max(res,map.get(A[i])+map.get(B[i]));
        }
        return res;
    }

    int minStepToPalindorme(String s){
        if(s==null||s.length()<2)return 0;
        int l=0,r=s.length()-1;
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> set=new HashSet<>();
        while(l<r){
            if(s.charAt(l)==s.charAt(r)){
                set.add(l);
                set.add(r);
            }else {
                q.offer(l);
            }
            l++;
            r--;
        }
        if(set.size()>=s.length()-1)return 0;
        int res=0;
        while (!q.isEmpty()){
            int curr=q.poll();
            boolean match=false;
            if(s.charAt(curr)==s.charAt(s.length()-curr-1)){
                match=true;
            }else{
                for(int i=curr+1;i<s.length();i++){
                    if(!set.contains(i)){
                        if(s.charAt(curr)==s.charAt(i)){
                            s=swap(s,curr,i);
                            set.add(curr);
                            set.add(i);
                            res++;
                            match=true;
                            break;
                        }
                    }
                }
            }
            if(!match)return -1;
        }
        return res;
    }

    String swap(String s,int i,int j){
        return s.substring(0,i)+s.charAt(j)+s.substring(i+1,j)+s.charAt(i)+s.substring(j);
    }

    String longestSub(String s){
        if(s.length()<3)return s;
        int start=0,end=1,max=0,cnt=1;
        String res="";
        while (end<s.length()){
            if(s.charAt(end)==s.charAt(end-1)){
                if(cnt==3)continue;
                cnt++;
            }else {
                if(cnt==3){
                    start=end-2;
                }
                cnt=1;
            }
            if(cnt==3){
                if(end-start>max) {
                    max = end - start;
                    res = s.substring(start, start + max);
                }
            }
            end++;
        }
        if(cnt<3){
            if(end-start>max){
                res=s.substring(start,end);
            }
        }
        return res;
    }

    String removeOne(String s){
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)>s.charAt(i+1))
                return s.substring(0,i)+s.substring(i+1);
        }
        return s.substring(0,s.length()-1);
    }

    String stringWithout3identical(String s){
        StringBuilder sb=new StringBuilder();
        char last=s.charAt(0);
        int cnt=1;
        for(char c:s.toCharArray()){
            if(c==last)cnt++;
            else cnt=1;
            if(cnt<3)sb.append(c);
            last=c;
        }
        return sb.toString();
    }

    int stepToEqualHigh(int[] N){
        if(N.length<2)return 0;
        Arrays.sort(N);
        int res=0,cnt=1;
        for(int i=N.length-2;i>=0;i--){
            if(N[i]!=N[i+1]){
                res+=cnt;
            }
            cnt++;
        }
        return res;
    }

    String dayOfWeek(String s,int k){
        ArrayList<String> week=new ArrayList<>(Arrays.asList("Sun","Mon","Tue","Wed","Thu","Fri","Sat"));
        return week.get((week.indexOf(s)+k)%7);
    }

    int maxInsertObtainLessThan3A(String s){
        int cnt=0,res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a')cnt++;
            else{
               res+=2-cnt;
               cnt=0;
            }
            if(cnt>2)return -1;
        }
        return res+2-cnt;
    }

    int maxLength=0;
    int concatenateString(String[] arr){
        for(String s:arr){
            if(!selfDuplicate(s)){
                backtrack(arr,1, new HashSet<>(),arr[0].length());
                break;
            }
        }
        return maxLength;
    }

    void backtrack(String[] arr,int start,Set<Character> set,int length){
        if(start==arr.length||selfDuplicate(arr[start]))return;
        for(int i=start;i<arr.length;i++){
            for(char c:arr[i].toCharArray()){
                if(set.contains(c))return;
            }
            for(char c:arr[i].toCharArray())
                if(set.add(c))return;
            maxLength=Math.max(maxLength,length+arr[i].length());
            backtrack(arr,start+1,set,length+arr[i].length());
            for(char c:arr[i].toCharArray())
                set.remove(c);
        }
    }

    boolean selfDuplicate(String s){
        Set<Character> set=new HashSet<>();
        for(char c:s.toCharArray()){
            if(set.contains(c))return true;
            set.add(c);
        }
        return false;
    }




}
