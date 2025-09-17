// Generic ArrayList

public class MyArrayList <T>
{
    private T [] data;
    private int size; // Number of elements in list
    private int MAXELEMENTS = 100;

    // Constructor for creating an empty list
    public MyArrayList()
    {
        size = 0;
        Object [] temp = new Object[MAXELEMENTS];
        // T[] data = new T[100]; we wanted to do this, but can't create an array of generics
        data = (T[]) temp;

    }

    // Start By recreating JVM Array methods
    // 1. Add method requires index and value, and returns nothing

    public void add (int index, T value) 
    // Index is can just be any data type. Value has to be a T data type
    {

        // Index might be out of bounds
        if (index  <0 || index > size)
        {
            throw new IndexOutOfBoundsException("Index: " +index+ " is out of bounds.");
            // this automatically returns

        }

        // To add an element, the rest will have to move up
        // So we'll have to traverse through the array
        // To avoid rewriting elements, we start from the end
        for (int i = size - 1; i >= index; i--)
        // start at end of array, decrement by 1, while i hasn't reached index yet
        {
            data[index + i] = data[i];
            
        }
        
        // This leaves an opening (null element) at our index place
        data[index] = value;
        size++; // since array has increased by one element

        
    }

    // Polymorphism: Method overloading
    // If we just want to add at end of array, no index needed

    public void add(T value)
    {
        data[size] = value;
        size++;
        

    }


    // 2. Contains method checks if array has specified element and return T/F
    public boolean contains (Object element)
    // we use Obj. Item doesn't have to be generic type
    {
        // traverse through array
        for(int i = 0; i < size; i++)
        {
            if (element.equals(data[i]))
            // .equals approriate for checking logically equivalent
            // comparable is used if ordering is necessary or should be considered
            {
                return true;

            }
            
        }
        return false;

    }

    // 3. Get method finds the element at specific index and returns object
    public T get(int index)
    {
        // Index might be out of bounds
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("Index: " +index+ " out of bounds.");
            // automatically returns
        }

        // else loop not necessary, only code will suffice
        else 
        {
            return data[index];
        }

    }

    // 4. Remove method removes element at given index and returns element
    public T remove(int index)
    {
        // Index might be out of bounds
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("Index: " +index+ " out of bounds.");
            // automatically returns
        }

        // index within bounds
        // opposite of add() method
        T removed = data[index]; // save the object before we remove it

        for (int i = index; i < size -1; i++) // size -1 to avoid out of bounds exception.
        {
            data[i] = data[i +1];
        }
        
        data [size -1] = null; // Last index nolonger has an object
        size--;

        return removed;

    }

    // 5. size method returns size of arrayList

    public int getSize()
    {
        return size;
    }

    // 6. toString method returns entire array
    public String toString()
    {
        String string = "[";
        
        // traverse through array to get each item
        for(int i =0; i < size; i++)
        {
            // concatenate array
            string += data[i];

            // to add commas until the second last item in array
            if (i < size-1)
            {
                string += ", ";
            }

        }

        string += "]";

        return string;
    }


    // Heavy Methods
    // 7. SortList method sorting from smallest to largest returns T/F
    public boolean sortList()
    {
        T hold; // element that we'll be continously comparing

        for (int i =0; i < size-1; i++)
        {
            for (int j =0; j < size - 1; j++)
            {
                
                // Checks if value 1 > value 2, if true swaps them
                if (((Comparable)data[j]).compareTo(data[j+1]) >0)
                
                // compareTo, unlike .equals() compares object rank
                // Comparable is necessary for compareTo() 
                // Introducee Comparable through implementation or type-casted
                // type-casting however will throw ClassCastException at runtime if T element (data[i]) not Comparable
                {
                    hold = data[j]; // save the value we want to shift
                    data[j+1] = data[j]; // move the smaller value to previous index
                    data[j] = hold; // place saved value in "new" index
                }
            }

        }
        return true;
    }

    // 8. Filter array between two values, cutting array between those points.
    public void filter(T low, T high)
    {
        // If no element in array
        if(getSize()==0)
        {
            System.out.println("No elements in array.");
            return;
        }

        // If 'low' is actually higher than 'high'
        if (((Comparable)low).compareTo(high) > 0)
        {
            System.out.println("Low: " +low+ " is bigger than High:" +high);
            return;
        }

        // create new array called filtered
        Object [] temp = new Object [MAXELEMENTS];
        T [] filtered = (T[]) temp;

        // Create new var j for the filtered array
        int j =0;

        // Use comparable to populate new array
        
        for (int i =0; i < size; i++)
        {
            if ((((Comparable)data[i]).compareTo(low) >0) && (((Comparable)data[i]).compareTo(low) < 0))
            {
                filtered[j] = data[i];
                j++;

            } 
        }

        // Now transfer everything from filtered to data
        data = filtered;
        size = j; // size of data is now the amount of elements filtered has, which is j


    }

    // 9. Merge method
    // Combine arrayLists return array
    public MyArrayList <T> merge (MyArrayList<T> paramList)
    {
        MyArrayList<T> holdArray = new MyArrayList<>();
        
        // If current arrayList has no elements
        if(this.getSize() == 0)
        {
            return paramList;

        }

        // If parameterList is empty
        if(paramList.getSize() == 0)
        {
            return this;

        }

        // If there is no space in arrayList
        if(this.getSize() + paramList.getSize() > MAXELEMENTS)
        {
            throw new IndexOutOfBoundsException("Too many elemnts in arrayList");

        }

        MyArrayList<T> returnArrayList = new MyArrayList<>();

        int i =0; // counter for calling array (ours)
        int j = 0; // counter for paramter array
        int k =0; // counter for return array

        //Traverse both lists until one is empty

        while(i< this.getSize() &&  j< paramList.getSize())
        {
            // If data values smaller
            if(((Comparable) data[i]).compareTo(paramList.data[j]) < 0)
            {
                returnArrayList.data[k] = data[i];
                k++;
                i++;


            }
            // If param values smaller
            else
            {
                returnArrayList.data[k] = paramList.data[j];
                k++;
                j++;
            }
        }

        //copy remainder of calling ArrayList
        if (i < this.getSize())
        {
            for (int x = i; x< getSize(); x++)
            {
                returnArrayList.data[k] = data[x];
                k++;
            }
        }

        if (j < paramList.getSize())
        {
            for (int y = j; y< paramList.getSize(); y++)
            {
                returnArrayList.data[k] = paramList.data[y];
                k++;

            }
        }
        returnArrayList.size = k;

        return returnArrayList;


    }


    // METHODS FOR STACKS
    // 10. get maximum elements for list
    public int getMAXELEMENTS()
    {
        return MAXELEMENTS;
    }

    // 11. Checks if there is space in arraylist, should we want to add obj
    public boolean checkSpace()
    {
        if (size+1 < MAXELEMENTS)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    
}