package pl.hetman.wiktoria.solvd.customlinkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Generics and collections task
public class GenericLinkedList<T> {
    private static final Logger LOGGER = LogManager.getLogger(GenericLinkedList.class);

    private Node head;

    public static <T> GenericLinkedList insert(GenericLinkedList list, T data) {

        LOGGER.info("insert()");

        if (list.head == null) {
            list.head = new Node(data);
        } else {
            Node last = list.head;

            while (last.next != null) {
                last = last.next;
            }

            last.next = new Node(data);

        }
        LOGGER.info("insert(...)");
        return list;
    }

    public static void printList(GenericLinkedList list) {
        LOGGER.info("printList()");
        Node currentNode = list.head;
        if (currentNode == null) {
            LOGGER.info("List is empty");
        }

        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
        LOGGER.info("printList(...)");
    }

    public static GenericLinkedList deleteAtPosition(GenericLinkedList list, int index) {
        LOGGER.info("deleteAtPosition()");
        Node currentNode = list.head;
        Node previousNode = null;

        //Case 1
        if (index == 0 && currentNode != null) {
            list.head = currentNode.next;

            // Display the message
            System.out.println(
                    index + " position element deleted");
            LOGGER.info("deleteAtPosition(...)");
            return list;
        }

        // CASE 2
        int counter = 0;

        while (currentNode != null) {

            if (counter == index) {
                previousNode.next = currentNode.next;
                LOGGER.info("deleteAtPosition(...)");
                break;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.next;
                counter++;
            }
        }

        //Case 3
        if (currentNode == null) {
            LOGGER.info(index + " position element not found");
        }

        LOGGER.info("deleteAtPosition(...)");
        return list;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    private static class Node<T> {
        private T data;
        private Node next;

        Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

