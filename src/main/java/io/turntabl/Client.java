package io.turntabl;

public abstract class Client {
    private String name;
    private String ID;
    private ServiceLevel serviceLevel;



    public Client(String ID, ServiceLevel serviceLevel){
        this.ID = ID;
        this.serviceLevel = serviceLevel;
    }

    public ServiceLevel getServiceLevel() {
        return serviceLevel;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }



}
