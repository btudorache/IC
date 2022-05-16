/**
 * Implementation of a circular linked list
 */
public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    /**
     * Adds a node to the list
     * @param value to be added to the list
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
     * Checks if the node is present in the list
     * @param searchValue value to be searched
     * @return true if the node is present, else false
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
     * Deletes the node from the list if present
     * @param valueToDelete value of node to be deleted
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
     * Gets the next node from the node specified
     * @param currentNode node specified
     * @return
     */
    public Node getNode(Node currentNode) {
        if (currentNode == null || currentNode.nextNode == null) {
            return null;
        }

        return currentNode.nextNode;
    }
}