public class Node
{
    //Defining variabels
    public String value;
    public Node left;
    public Node right;
    //Defining the constructor for the Node
    public Node(String value, Node left, Node right)
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    //Need to override the ToString function to return the values
    @Override
    public String toString()
    {
        return value;
    }
    //Need to define a function that traverses the tree and returns the value of the node

}