package anicetnougaret.aavpj;

public class BTreeCS<T> {

    T value;
    BTreeCS<T> leftChild = null;
    BTreeCS<T> rightChild = null;
    BTreeCS<T> parent = null;

    BTreeCS() { }

    BTreeCS(T value) {
        this.value = value;
    }

    BTreeCS(T value, BTreeCS<T> parent) {
        this.value = value;
        this.parent = parent;
    }

    /* BTreeCS(T value, BTreeCS<T> leftChild, BTreeCS<T> rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    } */

    /* public boolean isEmpty() {
        return leftChild != null && rightChild != null;
    } */

    public T getRootValue(){
        return this.value;
    }

    public BTreeCS<T> getLeftTree(){
        return this.leftChild;
    }

    public BTreeCS<T> getRightTree(){
        return this.rightChild;
    }

    public BTreeCS<T> getParent(){
        return this.parent;
    }

    /* public T getLeftValue(){
        return this.leftChild.getRootValue();
    } */
    
    /* public T getRightValue(){
        return this.rightChild.getRootValue();
    } */

    /* public void setRootValue(T val){
        this.value = val;
    } */

    public void setLeftTree(BTreeCS<T> leftTree){
        this.leftChild = leftTree;
    }

    public void setRightTree(BTreeCS<T> rightTree){
        this.rightChild = rightTree;
    }

    /* public void setLeftValue(T leftSubRoot){
        this.leftChild.setRootValue(leftSubRoot);
    } */

    /* public void setRightValue(T rightSubRoot){
        this.rightChild.setRootValue(rightSubRoot);
    } */

    public void setParent(BTreeCS<T> parentRoot){
        this.parent = parentRoot;
    }
}