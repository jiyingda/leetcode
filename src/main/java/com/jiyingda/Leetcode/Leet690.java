package com.jiyingda.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiyingda.
 * @date 2019/7/29.
 *
 *
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 *
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
 *
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 *
 * 示例 1:
 *
 * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出: 11
 * 解释:
 * 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
 * 注意:
 *
 * 一个员工最多有一个直系领导，但是可以有多个直系下属
 * 员工数量不超过2000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/employee-importance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet690 {

    public static void main(String[] args){
        Employee employee1 = new Employee();
        employee1.id = 1;
        employee1.importance = 5;
        employee1.subordinates = new ArrayList<Integer>(){{
            this.add(2);
            this.add(3);
        }};

        Employee employee2 = new Employee();
        employee2.id = 2;
        employee2.importance = 3;
        employee2.subordinates = new ArrayList<>();

        Employee employee3 = new Employee();
        employee3.id = 3;
        employee3.importance = 3;
        employee3.subordinates = new ArrayList<>();

        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);

        int im = getImportance(list, 1);
        System.out.println(im);

    }





    public static int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();

        for(Employee e : employees){
            map.put(e.id, e);
        }
        return getList(id, 0, map);
    }

    private static int getList(Integer a, int imp, Map<Integer, Employee> map){
        Employee e = map.get(a);
        if(e == null){
            return 0;
        }
        imp += e.importance;
        if(e.subordinates != null && e.subordinates.size() > 0){
            for(Integer i : e.subordinates){
                imp = getList(i, imp, map);
            }
        }
        return imp;
    }


    private static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
