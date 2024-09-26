package org.example.project.service.sort.impl;

import org.example.project.model.impl.Car;
import org.example.project.service.comparator.UniversalComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort<T> {

      public void mergeSort(List<T> list, UniversalComparator comparator) {
        if (list.size() > 1) {
            int middle = list.size() / 2;

            List<T> left = new ArrayList<>(list.subList(0, middle));
            List<T> right = new ArrayList<>(list.subList(middle, list.size()));

            mergeSort(left, comparator);
            mergeSort(right, comparator);

            merge(list, left, right, comparator);
        }
    }

    private void merge(List<T> list, List<T> left, List<T> right, Comparator<T> comparator) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }
}
