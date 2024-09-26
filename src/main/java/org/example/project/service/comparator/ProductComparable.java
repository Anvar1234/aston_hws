package org.example.project.service.comparator;

import java.util.Comparator;

public interface ProductComparable<T> extends Comparator<T> { //TODO: возможно удалить этот интерфейс, если универсальное что-то не придумаю.
    @Override
    int compare(T o1, T o2);
}
