package org.example.project.proxy_delete.impl;

import org.example.project.proxy_delete.ProductLoadable;

import java.util.List;

public class ProxyFromFileLoader implements ProductLoadable {
    RealFromFileLoader realFromFileLoader;
    String fileName;

    public ProxyFromFileLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> load() {
        if(realFromFileLoader == null){
            realFromFileLoader = new RealFromFileLoader(fileName);
        }
        return realFromFileLoader.load();
    }
}