package org.example.decorators;

import org.example.Data;
import org.example.DataSource;

public class CompressionDataSourceDecorator extends BaseDataSourceDecorator {
    public CompressionDataSourceDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void writeData(Data data) {
        data = compress(data);
        super.writeData(data);
    }

    @Override
    public Data readData() {
        Data data = super.readData();
        return decompress(data);
    }

    public Data decompress(Data data) {
        System.out.println("Decompressing data");
        return null;
    }

    public Data compress(Data data) {
        System.out.println("Compressing data");
        return null;
    }
}
