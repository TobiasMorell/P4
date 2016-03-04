public abstract class Node{
    //Need to define the print function, preorder postorder or inorder
    //Depth first search
    //We also add a custom print method
    protected void print(){
        print(this.toString());
    }
    protected void print(String value){
        System.out.print(value + " ");
    }
    //We need to override the toString function to build a custom for our AST
    @Override
    public String toString(){

    }
}