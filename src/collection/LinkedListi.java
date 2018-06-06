package collection;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by shancm on 2018/3/21.
 */
public class LinkedListi {
    private Node first;
    private Node last;
    private int size;

    public int size(){
        return size;
    }

    public Object get(int index){
        if(index>=size){
            return "OutOfBounds";
        }
        Node node = new Node();
        node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getObject();
    }


    public void add(Object object){
        Node node = new Node();
        if(first==null){
            node.setObject(object);
            first = node;
            last = node;
        }else {
            node.setObject(object);
            last.setNext(node);
            node.setPrevious(last);
            last = node;
        }
        size++;
    }

    public boolean remove(Object object){
        Node node = first;
        do {
            if(node.getObject()==object){
                if(node.getPrevious()!=null){
                    node.getPrevious().setNext(null);
                    node.setPrevious(null);
                }else {
                    first = node.getNext();
                    node.setNext(null);
                }
                if(node.getNext()==null){
                    last=node.getPrevious();
                    node.setPrevious(null);
                }else {
                    node.getNext().setPrevious(node.getPrevious());
                }
                size--;
                return true;
            }
        }while((node = node.getNext()) != null ? true : false);
        return false;
        /*for (Node node = first; node!=null; node=node.getNext()){
            if (node.getObject()==object){
                if(node.getPrevious()!=null){
                    node.getPrevious().setNext(node.getNext());
                }
            }
        }*/
    }

    public LinkedListi(){
        this.first=null;
        this.last=null;
        size=0;
    }

    public String toString(){
        if(size==0){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        Node node = first;
       while (node.getNext()!=null){
           sb.append(node.getObject());
           node = node.getNext();
       }
       sb.append(last.getObject());
       return "["+sb.toString()+"]";
    }

    public static void main(String[] args) {
        List list = new LinkedList();
        LinkedListi linkedListi = new LinkedListi();
        linkedListi.add(1);
        linkedListi.add(2);
        linkedListi.add(3);
        linkedListi.add(4);
//        linkedListi.remove(1);
        linkedListi.remove(2);
//        System.out.println(linkedListi);
        System.out.println(linkedListi.size());
        System.out.println(linkedListi.get(0));
        System.out.println(linkedListi.get(1));
        System.out.println(linkedListi.get(2));
    }


}

class Node{
    private Node previous;
    private Object object;
    private Node next;

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node() {

    }

    public Node(Node previous, Object object, Node next) {

        this.previous = previous;
        this.object = object;
        this.next = next;
    }
}

