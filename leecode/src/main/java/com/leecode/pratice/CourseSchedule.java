package com.leecode.pratice;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Arrays.sort(prerequisites, Comparator.comparingInt(o -> o[0]));
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> set=new HashSet<>();
        q.add(prerequisites[0][1]);
        while (!q.isEmpty()){
            int curr=q.poll();
        }
        return false;
    }


}
