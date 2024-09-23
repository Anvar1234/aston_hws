package org.example.project.strategy.input.impl;

import org.example.project.strategy.input.InputStrategy;
import org.example.project.strategy.parser.ProductParser;
import org.example.project.strategy.validation.DataValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FileInputStrategy<T> implements InputStrategy<T> {
    private String fileName;
    private ProductParser<?> parser;
    private DataValidator<T> dataValidator;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setParser(ProductParser<?> parser) {
        this.parser = parser;
    }

    public void setDataValidator(DataValidator<T> dataValidator) {
        this.dataValidator = dataValidator;
    }

    @Override
    public List<T> input(int count) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }

        if (lines.isEmpty() || lines == null || count == 0 || count > lines.size()) {
            throw new RuntimeException("Запрошено некорректное количество данных или данных в файле недостаточно!");
        }

        List<T> dataList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            try {
//                if(parser.parseProduct(lines.get(i)).isPresent()){
                T object = (T) parser.parseProduct(lines.get(i)).get();
                dataList.add(object);
//                }else{
//                    throw new NoSuchElementException("Данные в файле некорректны!");
//                }
            } catch (NumberFormatException | NoSuchElementException e) {
                System.out.println("Данные в файле некорректны!" + e.getMessage()); // TODO нормально везде обработать, а не выводить в печать.
            }
        }
        return dataList;
    }
}


