package com.example;


import java.util.Iterator;
interface Node {
    Iterator<Node> getChildren();
    void setProperty(String key, String value);
}


/**
 * Question: We need to call Node.getChildren() recursively
 * Asked: Optus
 */
public class RecursionDemo {
    void xyz(Node node, String key, String value){
        node.setProperty(key, value);
        Iterator<Node> children = node.getChildren();
        while(children.hasNext()){
            Node n = children.next();
            xyz(n, key, value);
        }
    }
}
