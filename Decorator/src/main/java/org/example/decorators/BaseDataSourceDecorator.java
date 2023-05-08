package org.example.decorators;

import org.example.Data;
import org.example.DataSource;

public abstract class BaseDataSourceDecorator implements DataSource {
    private final DataSource dataSource;

    public BaseDataSourceDecorator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void writeData(Data data) {
        dataSource.writeData(data);
    }

    @Override
    public Data readData() {
        return dataSource.readData();
    }
}
