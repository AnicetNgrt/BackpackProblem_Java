package anicetnougaret.aavpj;

public class BTreeCA<T> {

    T value;
    BTreeCA<T> leftChild;
    BTreeCA<T> rightChild;

    BTreeCA() { }

    BTreeCA(T value) {
        this.value = value;
        this.leftChild = new BTreeCA<T>();
        this.rightChild = new BTreeCA<T>();
    }

    BTreeCA(T value, BTreeCA<T> leftChild, BTreeCA<T> rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public boolean isEmpty() {
        return leftChild != null && rightChild != null;
    }

    public T getRootValue() throws Exception {
        return this.value;
    }

    public BTreeCA<T> getLeftTree() throws Exception {
        return this.leftChild;
    }

    public BTreeCA<T> getRightTree() throws Exception {
        return this.rightChild;
    }

    public T getLeftValue() throws Exception {
        return this.leftChild.getRootValue();
    }

    public T getRightValue() throws Exception {
        return this.rightChild.getRootValue();
    }

    public void setRootValue(T val) throws Exception {
        this.value = val;
    }

    public void setLeftTree(BTreeCA<T> leftTree) throws Exception {
        this.leftChild = leftTree;
    }

    public void setRightTree(BTreeCA<T> rightTree) throws Exception {
        this.rightChild = rightTree;
    }

    public void setLeftValue(T leftSubRoot) throws Exception {
        this.leftChild.setRootValue(leftSubRoot);
    }

    public void setRightValue(T rightSubRoot) throws Exception {
        this.rightChild.setRootValue(rightSubRoot);
    }
}