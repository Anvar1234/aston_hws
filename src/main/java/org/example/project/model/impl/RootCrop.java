package org.example.project.model.impl;

import org.example.project.model.ComparatorGetable;
import org.example.project.model.FieldsNamesGetable;
import org.example.project.model.NumericFieldGetable;
import org.example.project.service.comparator.UniversalComparator;

import java.util.Comparator;
import java.util.List;

public class RootCrop implements Comparable<RootCrop>, FieldsNamesGetable, NumericFieldGetable<Double>, ComparatorGetable<RootCrop> {
    private final String type;
    private final double weight;
    private final String color;

    private RootCrop(RootCropBuilder builder) {
        this.type = builder.type;
        this.weight = builder.weight;
        this.color = builder.color;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int compareTo(RootCrop other) {
        return this.type.compareTo(other.type); // Сортировка по типу по умолчанию
    }

    @Override
    public String toString() {
        return "Корнеплод: тип= " + type + ", вес= " + weight + ", цвет= " + color;
    }

    @Override
    public List<String> getFieldsNames() {
        return List.of("type", "weight", "color");
    } //TODO: тоже поудалять.

    @Override
    public Double getNumericField() {
        return getWeight();
    }

    @Override
    public Comparator<RootCrop> getComparator() {
        return new UniversalComparator<>("weight");
    }

    // Внутренний класс билдер
    public static class RootCropBuilder {
        private String type;
        private double weight;
        private String color;

        public RootCropBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public RootCropBuilder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public RootCropBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public RootCrop build() {
            return new RootCrop(this);
        }
    }
}