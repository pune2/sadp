import java.util.Enumeration;
import java.util.Iterator;
import java.util.StringTokenizer;

// Adapter class to adapt Enumeration to Iterator
class EnumerationIteratorAdapter<T> implements Iterator<T> {
    private Enumeration<T> enumeration;

    public EnumerationIteratorAdapter(Enumeration<T> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public T next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported.");
    }
}

// Adapter class to adapt StringTokenizer to Enumeration
class StringTokenizerEnumerationAdapter implements Enumeration<String> {
    private StringTokenizer tokenizer;

    public StringTokenizerEnumerationAdapter(StringTokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    @Override
    public boolean hasMoreElements() {
        return tokenizer.hasMoreTokens();
    }

    @Override
    public String nextElement() {
        return tokenizer.nextToken();
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        // Create a StringTokenizer (source)
        StringTokenizer tokenizer = new StringTokenizer("One Two Three Four", " ");

        // Adapt the StringTokenizer to Enumeration using the adapter
        Enumeration<String> enumeration = new StringTokenizerEnumerationAdapter(tokenizer);

        // Adapt the Enumeration to Iterator using the adapter
        Iterator<String> iterator = new EnumerationIteratorAdapter<>(enumeration);

        // Use the Iterator interface to iterate through elements
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}