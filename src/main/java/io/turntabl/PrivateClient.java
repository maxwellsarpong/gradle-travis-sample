package io.turntabl;

public class PrivateClient extends Client{
    private String name;


    public PrivateClient(String name, String ID, ServiceLevel serviceLevel) {
        super(ID, serviceLevel);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PrivateClient{" +
                "name='" + name + '\'' +
                '}';
    }
}
