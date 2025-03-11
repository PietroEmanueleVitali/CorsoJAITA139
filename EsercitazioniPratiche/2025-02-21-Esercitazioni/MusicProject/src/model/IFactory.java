package model;

public interface IFactory <F, P>{

    <T extends F> T make(Class<T> type, P... params);

}
