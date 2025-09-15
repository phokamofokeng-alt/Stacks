// Stack class

public class StackAsMyArrayList  <T>
{
    MyArrayList <T> theStack;

    // Constructor/ Initializor
    public StackAsMyArrayList()
    {
        theStack = new MyArrayList<>();

    }

    // 1. Push method adds element to stack
    // O(1) since no traversing needed
    public void push(T element)
    {
        if (theStack.checkSpace())
        {
            // if there is space in Stack
            // Use arrayList method "add" which takes index and element
            theStack.add(theStack.getSize(), element);
            
        }
        else
        {
            throw new IndexOutOfBoundsException
            ("Stack out of bounds");
        }
    }

    // 2. Pop method to remove element at end of stack
    // Return removed element
    public T pop()
    {
        // If there are no elements in Stack
        if(theStack.getSize() == 0)
        {
            T removed = null;
            return removed;
        }
        else
        {
            // index of element (LAst element in Stack)
            int index = theStack.getSize() -1;

            // To get element, use get(index) array method
            T element = theStack.get(index);
            // We use array method called remove which takes index of obj to remove obj
            theStack.remove(index);

            return element;

        }

    }

    // 3. String method for string
    public String toString()
    {
        // We use string method in arrayList
        return theStack.toString();
    }
}