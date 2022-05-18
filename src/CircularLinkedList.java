/**
 * CircularLinkedList
 *
 * This class is the implementation of data structure circular
 * linked list. This kind of list is a list that allows the
 * user to access both the head and the tail of the list in O(1).
 *
 * @author  Cosmin-Viorel Lovin
 * @version 1.0
 * @since   2022-5-18
 */
public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    /**
     * This method is used to add a new node to the list.
     * The node is always added at the end of the list, updating
     * the tail reference of the queue.
     * @param value this is the value of the new node
     */
    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
    }

    /**
     * This method is used to verify the existance of a value
     * in the queue. The queue is parsed from head to tail,
     * returning true if the value is found in the queue,
     * otherwise fail.
     * @param searchValue the value of the node searched
     * @return this returns true if the value is found or false
     */
    public boolean containsNode(int searchValue) {
        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return false;
        }
    }

    /**
     * This method is used to delete a specific node that
     * holds the value we are looking for.
     * When the first node that holds the value is found, we delete it
     * and then exit the function.
     * @param valueToDelete
     */
    public void deleteNode(int valueToDelete) {
        Node currentNode = head;
        if (head == null) {
            return;
        }
        do {
            Node nextNode = currentNode.nextNode;
            if (nextNode.value == valueToDelete) {
                if (tail == head) {
                    head = null;
                    tail = null;
                } else {
                    currentNode.nextNode = nextNode.nextNode;
                    if (head == nextNode) {
                        head = head.nextNode;
                    }
                    if (tail == nextNode) {
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head);
    }

    /**
     * This method is used to return the next node.
     * @param currentNode this is a reference to the current node
     * @return
     */
    public Node getNextNode(Node currentNode) {
        return currentNode.nextNode;
    }
}