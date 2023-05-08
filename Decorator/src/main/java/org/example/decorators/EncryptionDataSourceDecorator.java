package org.example.decorators;

import org.example.Data;
import org.example.DataSource;

public class EncryptionDataSourceDecorator extends BaseDataSourceDecorator {
    public EncryptionDataSourceDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void writeData(Data data) {
        data = encrypt(data);
        super.writeData(data);
    }

    @Override
    public Data readData() {
        Data data = super.readData();
        return decrypt(data);
    }

    public Data decrypt(Data data) {
        System.out.println("Decrypting Data");
        return null;
    }

    public Data encrypt(Data data) {
        System.out.println("Encrypting Data");
        return null;
    }
}
