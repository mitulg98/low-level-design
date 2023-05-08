package org.example;

import org.example.decorators.CompressionDataSourceDecorator;
import org.example.decorators.EncryptionDataSourceDecorator;
public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new FileDataSource("xyz.mp4");
        dataSource = new CompressionDataSourceDecorator(dataSource);
        dataSource = new EncryptionDataSourceDecorator(dataSource);
        dataSource.writeData(new Data());
        dataSource.readData();
    }
}