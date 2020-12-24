package cn.bgs.StringTest.ListTest;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname PersonUtils
 * @Description  list.stream().collect(Collectors.xxx());
 * 1.把Stream对象转换为list集合(Collectors.toList())，如1,2,3
 * 2.Stream对象转换为map对象(Collectors.toMap())，如4
 * 3.Stream对象转换为set对象(Collectors.toSet())，如5
 * 4.Stream对象用joining拼接成字符串，如6
 * 5.Stream对象用mapping按照指定格式输出，如7
 * @Date 2020/12/16 10:22
 * @Created by liulx
 */
public class PersonUtils {

    //1.查询名称以m开始的
    public List<Person> findNameStartWith(String name, List<Person> list){
        list.stream().filter(person ->
           person.getName().startsWith(name)
        ).collect(Collectors.toList());
        return list;
    }
    //2.查询年龄大于给定年龄的Person集合
    public List<Person> findPersonOlderThan(Integer age, List<Person> list){
        List<Person> list1 = new ArrayList<>();
        list.stream().forEach(person -> {
            if (person.getAge()>age){
                list1.add(person);
            }
        });
        return list1;
    }
    //3.获取年龄最大的两个Person用户
    public List<Person> getTwoPersonOldest(List<Person> list){
        list.stream().sorted((p1,p2)->p1.getAge()-p2.getAge()).limit(20).forEach(p-> System.out.println(p));
        return list;
    }
    //4.把list<Person>集合转换为map<String,Person>的map集合，其中key为person的名称
    public Map<String,Person> listToMap(List<Person> list){

        return list.stream().collect(Collectors.toMap(Person::getName,person->person));
    }
    //5.把list<Person>集合中的用户名称放到set集合中
    public Set<String> listToSet(List<Person> list){
        List<String> list1 = new ArrayList<>();
        list.stream().forEach(p->{
            list1.add(p.getName());
        });
        Set<String> set = list1.stream().collect(Collectors.toSet());
        return set;
    }
    //6.返回List集合中所有的用户名，用逗号进行拼接
    public String toString(List<Person> list){

        return list.stream().map(Person::getName).collect(Collectors.joining(","));
    }
    //7.返回List集合中所有用户名的list集合
    public List<String> listString(List<Person> list){
        return list.stream().map(Person::getName).collect(Collectors.toList());
    }
}
