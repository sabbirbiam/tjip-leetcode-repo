/**
*
* Time Complexity: O(N)
* Where N is the maximum length of two ListNode
* Space Complixity: O(M)
* where M is total number of Node
*
**/
public class Node {
     int value;
     Node next;
    
    Node(int value, Node node) {
        value = value;
        next = node;
    }
}

class MyLinkedList {
     Node root;
    int count;
    public MyLinkedList() {
        this.count = 0;
        root = new Node(Integer.MIN_VALUE, null);
    }

    public int get(int index) {
        Node currentNode = root;
        currentNode = currentNode.next;
        while(index-- > 0) {
            if(currentNode.next ==  null) return -1;
            currentNode = currentNode.next;
        }

        return currentNode.value;
    }

    public void addAtHead(int val) {
        Node currentNode = root;
        if(currentNode.next ==  null) {
            currentNode.next = new Node(val, null);
        }else {
            Node jointNode = currentNode.next;

            currentNode.next = new Node (val, null);
            currentNode.next.next = jointNode;
        }
        this.count += 1;
        this.printNode();
    }

    public void addAtTail(int val) {
        Node currentNode = root;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = new Node (val, null);
        this.count += 1;
                this.printNode();

    }

    public void addAtIndex(int index, int val) {
        Node currentNode = root;

        if(index > this.count)  return;
            while(index-- > 0) {
            System.out.println(index);
            System.out.println("&&");
            if(index == 0 && currentNode.next == null) {
                currentNode.next = new Node(val, null);
                this.count += 1;
                return;
            }
			
            currentNode = currentNode.next;
        }

        Node tempNode = currentNode.next;
        currentNode.next = new Node(val, null);
        currentNode.next.next = tempNode;
        this.count += 1;
        this.printNode();

    }

    public void deleteAtIndex(int index) {
        if(this.count > index) return;
        Node currentNode = root;
        while (index-- > 0) {
            currentNode = currentNode.next;
        }

        currentNode = currentNode.next.next;
        this.count -= 1;
        this.printNode();
    }

    public void printNode() {
        if(root.next ==  null) {
            System.out.println("Root is null");
            return;
        }
        Node currentNode = root;
        currentNode = currentNode.next;
        if(currentNode == null) return;
        while (currentNode != null) {
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */