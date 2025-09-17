public class TestClass
{
    public static void main (String [] args)
    {
        StackAsMyArrayList <String> myStack = new StackAsMyArrayList<>();

        // Print empty list
        System.out.println(myStack);

        // Populate Stack using push
        myStack.push(new String ("Godzilla"));
        myStack.push(new String ("Transporter 2"));
        myStack.push(new String ("Batman vs Superman"));
        myStack.push(new String ("The Gentlemen"));
        System.out.println(myStack);

        // Remove item from Stack. LIFO
        myStack.pop();
        System.out.println(myStack);

        // Remove another item
        myStack.pop();
        System.out.println(myStack);
        
        // Add new item in stack
        myStack.push(new String ("Bonnie and Clyde"));
        System.out.println(myStack);




    }

}
