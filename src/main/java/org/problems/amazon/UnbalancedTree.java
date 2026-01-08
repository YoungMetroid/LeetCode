package org.problems.amazon;

public class UnbalancedTree {
    Node root;

    void insert(int key, int position){
        root = insertNode(root,key,position);
    }

    Node insertNode(Node node, int key, int position){
        if(node == null) return new Node(key,position);
        if(key < node.key) node.left = insertNode(node.left,key,position);
        else if (key > node.key) node.right = insertNode(node.right,key,position);
        return node;
    }

    int processedFirst(int key, int position){
        int value =  processedFirst(root, key, position);
        return value;
    }
    int processedFirst(Node node, int key, int position){
        int value = 0;
        if(node == null){
            insert(key,position);
            return value;
        }
        if(key > node.key) {
            insert(key,position);
            value = node.position - position;
            return value;
        }
        else {
            value = processedFirst(node.left,key,position);
            return value;
        }
    }
}
