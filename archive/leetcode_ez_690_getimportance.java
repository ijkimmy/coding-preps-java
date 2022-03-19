/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
public class leetcode_ez_690_getimportance {
    class Employee{
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    // 31m
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees)
            map.put(e.id, e);
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        int importance = 0;
        while(!q.isEmpty()){ 
            int eid = q.poll();
            
            importance += map.get(eid).importance;
            q.addAll(map.get(eid).subordinates);
        }
        return importance;
    }   
}