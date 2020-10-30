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

    public void setLeftTree(BTreeCS<T> leftTree){
        this.leftChild = leftTree;
    }

    public void setRightTree(BTreeCS<T> rightTree){
        this.rightChild = rightTree;
    }

    public void setParent(BTreeCS<T> parentRoot){
        this.parent = parentRoot;
    }
}