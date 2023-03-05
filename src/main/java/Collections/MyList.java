package Collections;

public interface MyList<E> {

    int size();

    void clear();

    E remove(int index);

    E get(int index);


    void add(E e);
}
