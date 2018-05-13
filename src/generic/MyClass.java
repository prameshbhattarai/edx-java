package generic;

public class MyClass<E> {

    private E attribute;

    MyClass(E var) {
        this.attribute = var;
    }

    public E get() {
        return this.attribute;
    }

    public void set(E value) {
        this.attribute = value;
    }

    public boolean equal(MyClass<E> other) {
        return other.get().equals(this.attribute);
    }

}
