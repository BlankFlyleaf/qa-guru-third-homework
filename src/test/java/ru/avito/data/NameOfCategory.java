package ru.avito.data;

public enum NameOfCategory {
    cars("Автомобиль", "25985"),
    bikes("Мотоциклы и мототехника", "25986"),
    trucks("Грузовики и спецтехника", "26025");

    public final String description;
    public final String category;

    NameOfCategory(String description, String category) {
        this.description = description;
        this.category = category;
    }
}