/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    if(head==null){
        return false;
    }
    HashSet<Node> set = new HashSet();
    Node current = head;
    while(current!=null){
        if(!set.contains(current)){
            set.add(current);
        }
        else{
            return true;
        }
        current=current.next;
    }
    return false;
}
