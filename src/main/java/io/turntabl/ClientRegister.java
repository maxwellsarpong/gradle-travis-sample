package io.turntabl;

import java.util.*;
import java.util.stream.Collectors;

public class ClientRegister {
    private List<Client> clients = new ArrayList<>();

    public ClientRegister(List<Client> clients) {
        this.clients = clients;
    }

    public List<String> getContactNames() {
        return clients.stream().filter(c -> c.getServiceLevel().equals(ServiceLevel.Gold)).map(c -> c.getName()).collect(Collectors.toList());
    }

    public Optional<Client> getClientById(String id) {

        Optional<Client> clientById = clients.stream().filter(s -> s.getID() == id).findFirst();
        if (clientById.isPresent()) {
            System.out.println(clientById);
            return clientById;
        } else {
            System.out.println("user does not exist");
            return Optional.empty();
        }


    }


    public List<Client> getClientCountPerServiceLevel() {
        int goldCount =  clients.stream().filter(c -> c.getServiceLevel().equals(ServiceLevel.Gold)).collect(Collectors.toList()).size();

        int platinum =  clients.stream().filter(c -> c.getServiceLevel().equals(ServiceLevel.Platinum)).collect(Collectors.toList()).size();

        int premium =   clients.stream().filter(c -> c.getServiceLevel().equals(ServiceLevel.Premium)).collect(Collectors.toList()).size();

        List result = Arrays.asList(goldCount,platinum,premium);

        return result;
        //System.out.println("Gold Count: " + goldCount + ", " + "Platinum Count: " + platinum + " Premium Count: " + premium);
        //System.out.println(clients.stream().collect(Collectors.groupingBy(c -> c.getServiceLevel())));

    }


}



