class Node {
    String name;
    int codeName;
    Node next;

    public Node(String name) {
        this.name = name.trim();
        this.codeName = calculateCodeName(name);
        this.next = null;
    }
    private int calculateCodeName(String name) {
        int code = 0;
        for (int i = 0; i < Math.min(3, name.length()); i++) {
            code += getLetVal(name.charAt(i)) * Math.pow(26, 2 - i);
        }
        return code;
    }
    private int getLetVal(char ch) {
        return ch - 'a';
    }
}
