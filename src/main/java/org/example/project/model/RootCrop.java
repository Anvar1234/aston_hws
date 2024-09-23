package org.example.project.model;

import org.example.project.util.ValidationUtil;

public class RootCrop implements Comparable<RootCrop> {
    private final String type;
    private final int weight;
    private final String color;

    private RootCrop(RootCropBuilder builder) {
        this.type = builder.type;
        this.weight = builder.weight;
        this.color = builder.color;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
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
        return "RootCrop [type=" + type + ", weight=" + weight + ", color=" + color + "]";
    }

    // Внутренний класс билдер
    public static class RootCropBuilder {
        private String type;
        private int weight;
        private String color;

        public RootCropBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public RootCropBuilder setWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public RootCropBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public RootCrop build() {
            // Валидация
            if (!ValidationUtil.validateRootCropData(type, weight, color)) {
                throw new IllegalArgumentException("Некорректные данные для создания корнеплода.");
            }
            return new RootCrop(this);
        }
    }
}