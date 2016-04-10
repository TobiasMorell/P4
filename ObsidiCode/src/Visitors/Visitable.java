package Visitors;

/**
 * Created by morell on 4/10/16.
 */
public interface Visitable {
    public Object Accept(AbstractVisitor v);
}
