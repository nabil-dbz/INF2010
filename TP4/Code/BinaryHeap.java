import java.util.*; 


public class BinaryHeap<AnyType extends Comparable<? super AnyType>> extends AbstractQueue<AnyType>
{
    private static final int DEFAULT_CAPACITY = 100;
    private int currentSize;      // Nombre d'elements
    private AnyType [ ] array;    // Tableau contenant les donnees (premier element a l'indice 1)
    private boolean min;
    private int modifications;    // Nombre de modifications apportees a ce monceau
    
    @SuppressWarnings("unchecked")
    public BinaryHeap( boolean min ){
	    this.min = min;
	    currentSize = 0;
	    array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
    }
    
    @SuppressWarnings("unchecked")
    public BinaryHeap( AnyType[] items, boolean min ){
	    this.min = min;
		// COMPLETEZ
	    // invoquez buildMinHeap() ou buildMaxHeap() en fonction du parametre min
        array = (AnyType[]) new Comparable[ items.length + 1];
        for (int i = 0; i < items.length; i++)
            array[i+1] = items[i];
        currentSize = items.length;
        if (min)
            buildMinHeap();
        else
            buildMaxHeap();
    }
    
    public boolean offer( AnyType x ){
	    if (x == null)
	        throw new NullPointerException("Cannot insert null in a BinaryHeap");
	
	    if( currentSize + 1 == array.length )
	        doubleArray();

        int  hole = ++currentSize;

        if (min) {
            for (; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2)
                array[hole] = array[hole / 2];
        }
        else {
            for (; hole > 1 && x.compareTo(array[hole / 2]) > 0; hole /= 2)
                array[hole] = array[hole / 2];
        }

        array[ hole ]=x;
	
	    return true;
    }
    
    public AnyType peek(){
	    if(!isEmpty())
	    return array[1];
	
	    return null;
    }
    
    public AnyType poll(){
	    //COMPLETEZ
        if (currentSize == 0)
            return null;
        AnyType save = array[1];
        array[1]= array[currentSize];

        if(min)
            percolateDownMinHeap(1,currentSize);
        else
            percolateDownMaxHeap(1,currentSize);

        currentSize--;
    	return save;
    }
    
    public Iterator<AnyType> iterator(){
	    return new HeapIterator();
    }
    
    private void buildMinHeap(){
        for (int i = currentSize / 2; i > 0; i--)
            percolateDownMinHeap(i, currentSize);
    }
    
    private void buildMaxHeap(){
        for (int i = currentSize / 2; i > 0; i--)
            percolateDownMaxHeap(i, currentSize);
    }
    
    public boolean isEmpty(){
	    return currentSize == 0;
    }
    
    public int size(){
	    return currentSize;
    }
    
    public void clear(){
	    currentSize = 0;
	    modifications = 0;
	    array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
    }
    
    private static int leftChild( int i, boolean heapIndexing ){
	            return ( heapIndexing ? 2*i : 2*i+1 );
    }
    
    private void swapReferences( int index1, int index2 ){
	    swapReferences(array, index1, index2);
    }
    
    private static <AnyType extends Comparable<? super AnyType>>
				    void swapReferences( AnyType[] array, int index1, int index2 ){
	
    	AnyType tmp = array[ index1 ];
	    array[ index1 ] = array[ index2 ];
	    array[ index2 ] = tmp;
    }
    
    @SuppressWarnings("unchecked")
	private void doubleArray(){
	    AnyType [ ] newArray;
	
	    newArray = (AnyType []) new Comparable[ array.length * 2 ];
	    for( int i = 0; i < array.length; i++ )
	        newArray[ i ] = array[ i ];
	    array = newArray;
    }
    
    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMinHeap( int hole, int size ){
	     percolateDownMinHeap(array, hole, size, true);
    }
    
    /**
     * @param array   Tableau d'element
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    private static <AnyType extends Comparable<? super AnyType>>
				    void percolateDownMinHeap( AnyType[] array, int hole, int size, boolean heapIndexing )
    {
	    //COMPLETEZ
        int child = 0;
        AnyType tmp = array[hole];

        for( ; hole * 2 <= size; hole = child) {
            child = leftChild(hole, heapIndexing); // On prend le fils gauche

            if ((child + 1 <= size) && (array[child].compareTo(array[child + 1]) > 0)) // fils droit existe et est inferieur au fils gauche
                child ++;

            if (array[child].compareTo(tmp) < 0)
                array[hole] = array[child];
            else
                break;
        }
        array[hole] = tmp;
    }
    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMaxHeap( int hole, int size ){
	    percolateDownMaxHeap(array, hole, size, true);
    }
    
    /**
     * @param array         Tableau d'element
     * @param hole          Position a percoler
     * @param size          Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    private static <AnyType extends Comparable<? super AnyType>> 
				    void percolateDownMaxHeap( AnyType[] array, int hole, int size, boolean heapIndexing )
    {
        int child = 0;
        AnyType tmp = array[hole];

        for( ; hole * 2 <= size; hole = child) {
            child = leftChild(hole, heapIndexing);  // On prend le fils gauche

            if ((child + 1 <= size) && (array[child].compareTo(array[child + 1]) < 0)) // fils droit existe et est superieur au fils gauche
                child ++;

            if (array[child].compareTo(tmp) > 0) {
                array[hole] = array[child];
            }
            else
                break;
        }
        array[hole] = tmp;
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSort( AnyType[] a )
    {
	//COMPLETEZ
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSortReverse( AnyType[] a )
    {
	//COMPLETEZ
    }
    
    public String nonRecursivePrintFancyTree()
    {
	String outputString = "";
	
	//COMPLETEZ

	return outputString;
    }
    
    public String printFancyTree()
    {
	return printFancyTree(1, "");
    }
    
    private String printFancyTree( int index, String prefix)
    {
	String outputString = "";
	
	outputString = prefix + "|__";
	
	if( index <= currentSize )
	    {
		boolean isLeaf = index > currentSize/2;
		
		outputString += array[ index ] + "\n";
		
		String _prefix = prefix;
		
		if( index%2 == 0 )
		    _prefix += "|  "; // un | et trois espace
		else
		    _prefix += "   " ; // quatre espaces
		
		if( !isLeaf ) {
		    outputString += printFancyTree( 2*index, _prefix);
		    outputString += printFancyTree( 2*index + 1, _prefix);
		}
	    }
	else
	    outputString += "null\n";
	
	return outputString;
    }
    
    private class HeapIterator implements Iterator {
	
        public boolean hasNext() {
            //COMPLETEZ
                return false/**/;
        }

        public Object next() throws NoSuchElementException,
                        ConcurrentModificationException,
                        UnsupportedOperationException {
            //COMPLETEZ
            return null/**/;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
