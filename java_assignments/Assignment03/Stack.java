package java_assignments.Assignment03;

import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> container = new ArrayList<T>();

    void push(T item){
        container.add(item);
    }
    T pop(){
        T toReturn;
        if(container.size() == 0){
            toReturn = null;
        }else{
            toReturn = container.get(container.size()-1);
            container.remove(container.size()-1);
        }
        return toReturn;
    }
    boolean IsEmpty(){return container.isEmpty();}
    void show(){System.out.println(container);}
}
