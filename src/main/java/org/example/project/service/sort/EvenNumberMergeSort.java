package org.example.project.service.sort;

import org.example.project.model.NumericFieldGetable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EvenNumberMergeSort<T> {

    public void evenMergeSort(List<T> list, Comparator comparator) {
        if (list.size() > 1) {
            int middle = list.size() / 2;

            List<T> left = new ArrayList<>(list.subList(0, middle));
            List<T> right = new ArrayList<>(list.subList(middle, list.size()));

            evenMergeSort(left, comparator);
            evenMergeSort(right, comparator);

            merge(list, left, right, comparator);
        }
    }

    private void merge(List<T> list, List<T> left, List<T> right, Comparator<T> comparator) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            T leftElement = left.get(i);
            T rightElement = right.get(j);

            // Get the numeric field value for each element
            Integer leftValue = ((NumericFieldGetable<Integer>) leftElement).getNumericField();
            Integer rightValue = ((NumericFieldGetable<Integer>) rightElement).getNumericField();

            // If both values are even, sort in natural order
            if (leftValue % 2 == 0 && rightValue % 2 == 0) {
                if (comparator.compare(leftElement, rightElement) <= 0) {
                    list.set(k++, leftElement);
                    i++;
                } else {
                    list.set(k++, rightElement);
                    j++;
                }
            }
            // If one value is even and the other is odd, prioritize the even one
            else if (leftValue % 2 == 0) {
                list.set(k++, leftElement);
                i++;
            } else {
                list.set(k++, rightElement);
                j++;
            }
        }

        // Handle remaining elements
        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }
//        <T extends NumericFieldGetable<N>, N extends Number> {
//
//    public void evenMergeSort(List<T> list, Comparator<T> comparator) {
//        if (list.size() > 1) {
//            int middle = list.size() / 2;
//
//            List<T> left = new ArrayList<>(list.subList(0, middle));
//            List<T> right = new ArrayList<>(list.subList(middle, list.size()));
//
//            evenMergeSort(left, comparator);
//            evenMergeSort(right, comparator);
//
//            merge(list, left, right, comparator);
//        }
//    }
//
//    private void merge(List<T> list, List<T> left, List<T> right, Comparator<T> comparator) {
//        int i = 0, j = 0, k = 0;
//
//        while (i < left.size() && j < right.size()) {
//            T leftElement = left.get(i);
//            T rightElement = right.get(j);
//
//            N leftNumericValue = leftElement.getNumericField();
//            N rightNumericValue = rightElement.getNumericField();
//
//            if (leftNumericValue.doubleValue() % 2 == 0 && rightNumericValue.doubleValue() % 2 == 0) {
//                // Оба элемента имеют четные числовые значения, сортировать в естественном порядке.
//                if (comparator.compare(leftElement, rightElement) <= 0) {
//                    list.set(k++, leftElement);
//                    i++;
//                } else {
//                    list.set(k++, rightElement);
//                    j++;
//                }
//            } else if (leftNumericValue.doubleValue() % 2 == 0) {
//                // Левый элемент имеет четное числовое значение, сортировать в естественном порядке.
//                list.set(k++, leftElement);
//                i++;
//            } else if (rightNumericValue.doubleValue() % 2 == 0) {
//                // Правый элемент имеет четное числовое значение, сортировать в естественном порядке.
//                list.set(k++, rightElement);
//                j++;
//            } else {
//                // Оба элемента имеют нечетные числовые значения, оставляем их в исходном порядке.
//                if (i < left.size()) {
//                    list.set(k++, leftElement);
//                    i++;
//                } else {
//                    list.set(k++, rightElement);
//                    j++;
//                }
//            }
//        }
//
//        while (i < left.size()) {
//            list.set(k++, left.get(i++));
//        }
//
//        while (j < right.size()) {
//            list.set(k++, right.get(j++));
//        }
//    }
}