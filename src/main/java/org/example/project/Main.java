package org.example.project;

import org.example.project.model.Book;
import org.example.project.model.Car;
import org.example.project.model.RootCrop;
import org.example.project.strategy.input.UniversalDataInput;
import org.example.project.strategy.input.impl.FileInputStrategy;
import org.example.project.strategy.input.impl.ManualInputStrategy;
import org.example.project.strategy.input.impl.RandomInputStrategy;
import org.example.project.strategy.parser.ProductParser;
import org.example.project.strategy.parser.impl.BookParser;
import org.example.project.strategy.parser.impl.CarParser;
import org.example.project.strategy.prompt.Promter;
import org.example.project.strategy.prompt.impl.BookPromptStrategy;
import org.example.project.strategy.random.RandomDataGenerator;
import org.example.project.strategy.random.impl.RandomBookStrategy;
import org.example.project.strategy.random.impl.RandomCarsStrategy;
import org.example.project.strategy.random.impl.RandomRootCropsStrategy;
import org.example.project.strategy.validation.DataValidator;
import org.example.project.strategy.validation.impl.BookValidationStrategy;
import org.example.project.strategy.validation.impl.CarValidationStrategy;
import org.example.project.strategy.validation.impl.RootCropValidationStrategy;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Это старый код, еще до параметризации интерфейсов и классов (используются сырые типы и явное приведение типов):
        DataValidator carValidation = new DataValidator(new CarValidationStrategy());
        RandomDataGenerator generator = new RandomDataGenerator(new RandomCarsStrategy());
        List<Car> cars = (List<Car>) generator.getRandomData(4);
        System.out.println(cars);
        for (Car car : cars) {
            System.out.println(carValidation.isValid(car));
        }

        DataValidator bookValidation = new DataValidator(new BookValidationStrategy());
        generator = new RandomDataGenerator(new RandomBookStrategy());
        List<Book> books = (List<Book>) generator.getRandomData(5);
        System.out.println(books);
        for (Book book : books) {
            System.out.println(bookValidation.isValid(book));
        }

        DataValidator rootCropValidation = new DataValidator(new RootCropValidationStrategy());
        generator = new RandomDataGenerator(new RandomRootCropsStrategy());
        List<RootCrop> rootCrops = (List<RootCrop>) generator.getRandomData(2);
        System.out.println(rootCrops);
        for (RootCrop rootCrop : rootCrops) {
            System.out.println(rootCropValidation.isValid(rootCrop));
        }

        //Парсинг из файла:
        ProductParser<Car> parser = new ProductParser<>(new CarParser());
        DataValidator<Car> carDataValidator = new DataValidator<>(new CarValidationStrategy());
        UniversalDataInput<Car> dataInput = new UniversalDataInput<>(new FileInputStrategy<>("autos.txt", parser, carDataValidator));
        List<Car> cars2;
        try {
            cars2 = dataInput.inputData(2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(cars2);

        //Ручной ввод:
        DataValidator<Book> bookValidator = new DataValidator<>(new BookValidationStrategy());
        ProductParser<Book> bookParser = new ProductParser<>(new BookParser());
        Promter promter = new Promter(new BookPromptStrategy());
        UniversalDataInput<Book> bookInput = new UniversalDataInput<>(new ManualInputStrategy<>(bookValidator, bookParser, promter));
        List<Book> books2;
        try {
           books2 = bookInput.inputData(2);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println(books2);

        //Рандомный ввод:
        RandomInputStrategy<RootCrop> randomInputStrategy = new RandomInputStrategy<>(new RandomDataGenerator<>(new RandomRootCropsStrategy()));
        List<RootCrop> rootCrops2 = randomInputStrategy.input(4);
        System.out.println(rootCrops2);
    }
}
