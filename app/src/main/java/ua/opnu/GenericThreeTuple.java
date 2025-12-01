package ua.opnu;

public class GenericThreeTuple<T, V, S> {

    public final GenericTwoTuple<T, V> tuple2;
    public final S three;

    public GenericThreeTuple(T first, V second, S three) {
        this.tuple2 = new GenericTwoTuple<>(first, second);
        this.three = three;
    }

    @Override
    public String toString() {
        return "(" + tuple2.first + ", " + tuple2.second + ", " + three + ')';
    }
}