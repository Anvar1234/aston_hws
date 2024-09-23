package org.example.project.proxy_delete.impl;

import org.example.project.proxy_delete.ProductLoadable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class RealFromFileLoader implements ProductLoadable {
    private final String fileName;

    public RealFromFileLoader(String fileName) {
        this.fileName = fileName;
    }

    private List<String> loadProduct(){
        List<String> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                dataList.add(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
        return dataList;
    }

    @Override
    public List<String> load() {
        return new ArrayList<>(loadProduct());
    }
}