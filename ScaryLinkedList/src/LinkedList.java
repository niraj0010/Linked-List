public class LinkedList {
    Node first;
    Node[] array = new Node[26];
    Node makeNode(String name) {
        Node newNode = new Node(name);
        return newNode;
    }
    public void init() {
        first = null;
    }
     Node findTail() {
        Node current = first;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }
    public void buildIndex() {
            for (int i = 0; i < array.length; i++) {
                Node current = first;
                Node prev = null;

                while (current != null) {
                    if (current.name.charAt(0) - 'a' == i) {
                        if (array[i] == null) {
                            array[i] = current;
                        }
                        if (prev != null) {
                            prev.next = current;
                        }
                        prev = current;
                    }
                    current = current.next;
                }
                if (prev != null) {
                    prev.next = null;
                }
            }
        }


    public void showList() {
        Node current = first;
        while (current != null) {
            System.out.println(current.name);
            current = current.next;
        }
    }
    public int listLen() {
        int len = 0;
        Node current = first;
        while (current != null) {
            len++;
            current = current.next;
        }
        return len;
    }
    public void insertSorted(String name) {
            Node sorted = new Node(name);
            if (first == null || name.compareTo(first.name) < 0) {
                sorted.next = first;
                first = sorted;
            } else {
                Node current = first;
                while (current.next != null && name.compareTo(current.next.name) > 0) {
                    current = current.next;
                }
                sorted.next = current.next;
                current.next = sorted;
            }
        }

    public void remove(String name) {
        Node current = first;
        Node prev = null;

        while (current != null && !current.name.equals(name)) {
            prev = current;
            current = current.next;
        }


        if (current != null) {
            if (prev == null) {
                first = current.next;
            } else {
                prev.next = current.next;
            }
           // System.out.println(current);
            System.out.println("Deleted " + name);
        } else {
            //System.out.println(current);
            System.out.println("Could not delete because could not find " + name);

        }
    }


    public void lengthSection(char alphabet) {
        int c = 0;
        Node thisSection = array[alphabet - 'a'];
        while (thisSection != null && thisSection.name.charAt(0) == alphabet) {
            c++;
            thisSection = thisSection.next;
        }
        System.out.println("Length of section starting with  " + alphabet + " is " + c);
    }
    public void showSection(char alphabet) {
        Node thisSection = array[alphabet - 'a'];
        while (thisSection != null && thisSection.name.charAt(0) == alphabet) {
            System.out.println(thisSection.name);
            thisSection = thisSection.next;
        }

        if (thisSection == null) {
            //System.out.println("No names found with the given starting letter.");
        }
    }
}
