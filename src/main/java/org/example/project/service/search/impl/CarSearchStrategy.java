package org.example.project.service.search.impl;

import org.example.project.model.impl.Car;
import org.example.project.service.search.BinarySearchable;

import java.util.List;
import java.util.Optional;

public class CarSearchStrategy implements BinarySearchable<Car> {
    @Override
    public Optional<Car> binarySearch(List<Car> sortedList, String target) {
        int left = 0;
        int right = sortedList.size() - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            Car midElement = sortedList.get(middle);

            int comparison = target.compareTo(midElement.getModel());

            if (comparison == 0) {
                return Optional.of(sortedList.get(middle));  // Найденный элемент
            } else if (comparison < 0) {
                right = middle - 1;  // Искомый элемент в левой части
            } else {
                left = middle + 1;  // Искомый элемент в правой части
            }
        }

        return Optional.empty();  // Элемент не найден
    }
}
