package org.example.project.service.comparator;

import java.lang.reflect.Field;
import java.util.Comparator;

public class UniversalComparator<T> implements Comparator<T> {
    private final String fieldName;

    public UniversalComparator(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public int compare(T o1, T o2) {
        try {
            Field field = o1.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);

            Object value1 = field.get(o1);
            Object value2 = field.get(o2);

            if (value1 == null && value2 == null) { // Обработаем возможные null значения.
                return 0;
            } else if (value1 == null) {
                return -1;
            } else if (value2 == null) {
                return 1;
            }

            if (value1 instanceof Comparable) {
               return ((Comparable) value1).compareTo(value2);
            } else {
                throw new UnsupportedOperationException("Невозможно сравнить объекты типа: " + value1.getClass());
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Ошибка при сравнении объектов.", e);
        }
    }
}