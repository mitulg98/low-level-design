package org.example;

public class FileDataSource implements DataSource {
    private String fileName;

    public FileDataSource(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeData(Data data) {

    }

    @Override
    public Data readData() {
        return null;
    }
}
