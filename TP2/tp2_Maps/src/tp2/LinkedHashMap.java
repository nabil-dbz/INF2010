package tp2;

public class LinkedHashMap<KeyType, DataType> {

    private static final double COMPRESSION_FACTOR = 2; // 50%
    private static final int DEFAULT_CAPACITY = 20;
    private static final int CAPACITY_INCREASE_FACTOR = 2;

    private Node<KeyType, DataType>[] map;
    private int capacity;
    private int size = 0;

    public LinkedHashMap() {
        capacity = DEFAULT_CAPACITY;
        map = new Node[DEFAULT_CAPACITY];
    }

    public LinkedHashMap(int capacity) {
        this.capacity = capacity;
        map = new Node[capacity];
    }

    /**
     * Finds the index attached to a particular key
     * @param key Value used to access to a particular instance of a DataType within map
     * @return The index value attached to a particular key
     */
    public int getIndex(KeyType key){
        int keyHash = key.hashCode() % capacity;
        return keyHash < 0 ? -keyHash : keyHash;
    }

    private boolean shouldRehash() {
        return size * COMPRESSION_FACTOR > capacity;
    }

    /** TODO
     * Increases capacity by CAPACITY_INCREASE_FACTOR (multiplication) and
     * reassigns all contained values within the new map
     */
    private void rehash() {
        //Node<KeyType, DataType>[] newMap = new Node[this.capacity * CAPACITY_INCREASE_FACTOR];
        Node<KeyType, DataType>[] oldMap = map;
        this.capacity *= CAPACITY_INCREASE_FACTOR;
        this.map = new Node[this.capacity];
        this.size = 0;
        for (int i = 0; i < oldMap.length; i++) {
            Node<KeyType, DataType> element = oldMap[i];
            while (element != null) {
                put(element.key, element.data);
                element = element.next;
            }
        }
    }

    private void addNode(Node<KeyType, DataType> newNode) {
        if (shouldRehash())
            rehash();
        newNode.next = map[getIndex(newNode.key)];
        map[getIndex(newNode.key)] = newNode;
        size++;
    }

    public int size() {
        return size;
    }

    public int getCapacity(){
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /** TODO
     * Finds if map contains a key
     * @param key Key which we want to know if exists within map
     * @return if key is already used in map
     */
    public boolean containsKey(KeyType key) {
        Node<KeyType, DataType> element = map[getIndex(key)];
        while((element != null) && (element.next != null) && !element.key.equals(key)){
            element = element.next;
        }
        if (element == null){
            return false;
        }
        if (element.key.equals(key)) {
            return true;
        }
        return false;
    }

    /** TODO
     * Finds the value attached to a key
     * @param key Key which we want to have its value
     * @return DataType instance attached to key (null if not found)
     */
    public DataType get(KeyType key) {
        Node<KeyType, DataType> element = map[getIndex(key)];
        while((element != null) && (element.next != null) && (!element.key.equals(key))){
            element = element.next;
        }
        if (element == null){
            return null;
        }
        else if (element.key.equals(key)) {
            return element.data;
        }
        else {
            return null;
        }
    }

    /** TODO
     * Assigns a value to a key
     * @param key Key which will have its value assigned or reassigned
     * @return Old DataType instance at key (null if none existed)
     */


    public DataType put(KeyType key, DataType value) {
        Node<KeyType, DataType> element = map[getIndex(key)];
        while ((element != null) && (element.next != null) && (!element.key.equals(key)))
            element = element.next;
        if (element == null) {
            addNode(new Node(key, value));
            return null;
        }
        if (element.key.equals(key)) {
            DataType retour = element.data;
            element.data = value;
            return retour;
        }
        addNode(new Node(key, value));
        return null;
    }

    /** TODO
     * Removes the node attached to a key
     * @param key Key which is contained in the node to remove
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType remove(KeyType key) {
        Node<KeyType, DataType> currentElement = map[getIndex(key)];
        Node<KeyType, DataType> previousElement = null;
        while((currentElement != null) && (currentElement.next != null) && (!currentElement.key.equals(key))){
            previousElement = currentElement;
            currentElement = currentElement.next;
        }
        if (currentElement == null){
            return null;
        }
        else if (currentElement.key.equals(key)) {
            size--;
            if (previousElement != null)
                previousElement.next = currentElement.next;
            else
                map[getIndex(key)] = currentElement.next;
            return currentElement.data;
        }
        else {
            return null;
        }
    }

    /** TODO
     * Removes all nodes contained within the map
     */
    public void clear() {
        for(int i = 0; i < map.length; i++)
            map[i] = null;
    }


    static class Node<KeyType, DataType> {
        final KeyType key;
        DataType data;
        Node next; // Pointer to the next node within a Linked List

        Node(KeyType key, DataType data)
        {
            this.key = key;
            this.data = data;
            next = null;
        }
    }
}


