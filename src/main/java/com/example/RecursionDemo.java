package com.example;


import java.util.Iterator;
interface Node {
    Iterator<Node> getChildren();
    void setProperty(String key, String value);
}


/**
 * Question: Node has one method to get its children i.e. getChildren() which return Iterator<Node>
 * Node has a method i.e. setProperty(String key, String value) to provide its children.
 * <br>
 * TASK: We need to setProperty(String key, String value) of each Node
 * <br>
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
