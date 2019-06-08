package generic;

public class ObjectWrapper<T> {
    private T data;

    public ObjectWrapper(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
