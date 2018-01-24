package test;

import java.util.LinkedList;
import java.util.List;

public class Test<E> {
    private E e;

    private List<E> list;

    E get(){
        return list.get(0);
    }

    void put(E e){
        list.add(e);
    }

    public Test(){
        list = new LinkedList<>();
    }

    public static void main(String[] args) {
        Test<Integer> test = new Test<>();
        test.put(1);
        System.out.println(test.get().getClass());
    }
}
