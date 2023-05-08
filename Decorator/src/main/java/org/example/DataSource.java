package org.example;

public interface DataSource {
    void writeData(Data data);
    Data readData();
}
