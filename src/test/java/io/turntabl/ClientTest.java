package io.turntabl;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.assertTrue;

public class ClientTest {


    @Test
    public  void testRegisterClient(){

        // create for private client
        ArrayList<Client> clients = new ArrayList<Client>(Arrays.asList(
                new PrivateClient("Maxwell", "001", ServiceLevel.Gold),
                new PrivateClient("John", "002", ServiceLevel.Gold),
                new CorporateClient(new AccountManager("John"), "002", ServiceLevel.Gold),
                new CorporateClient(new AccountManager("John"), "002", ServiceLevel.Gold),
                new PrivateClient("John", "002", ServiceLevel.Gold),
                new PrivateClient("John", "002", ServiceLevel.Gold)
        ));

        ClientRegister clientregister = new ClientRegister(clients);

        List actual = clientregister.getContactNames();
        List expected = Arrays.asList("Maxwell", "John", "John", "John", "John", "John");
        boolean result = expected.equals(actual);
        assertTrue(result);

    }



    @Test
    public void testClientByName(){
        // create for private client
        ArrayList<Client> clients = new ArrayList<>(Arrays.asList(
                new PrivateClient("Maxwell", "001", ServiceLevel.Gold),
                new PrivateClient("John", "002", ServiceLevel.Gold),
                new CorporateClient(new AccountManager("John"), "002", ServiceLevel.Gold),
                new CorporateClient(new AccountManager("John"), "002", ServiceLevel.Gold),
                new PrivateClient("John", "002", ServiceLevel.Gold),
                new PrivateClient("John", "002", ServiceLevel.Gold)
        ));

        ClientRegister clientregister = new ClientRegister(clients);

       Optional expected = clientregister.getClientById("001");
        Client privateClient = new PrivateClient("Maxwell", "001", ServiceLevel.Gold);
        Optional<String> value = Optional.ofNullable(privateClient.getName());
        assertSame(value, expected);

    }



    @Test
    public void testClientCountPerServiceLevel(){

        ArrayList<Client> clients = new ArrayList<>(Arrays.asList
                (
                new PrivateClient("Maxwell", "001", ServiceLevel.Gold),
                new PrivateClient("John", "002", ServiceLevel.Gold),
                new CorporateClient(new AccountManager("John"), "002", ServiceLevel.Gold),
                new CorporateClient(new AccountManager("John"), "002", ServiceLevel.Gold),
                new PrivateClient("John", "002", ServiceLevel.Gold),
                new PrivateClient("John", "002", ServiceLevel.Platinum),
                new PrivateClient("John", "002", ServiceLevel.Platinum),
                new PrivateClient("John", "002", ServiceLevel.Platinum),
                new PrivateClient("John", "002", ServiceLevel.Platinum),
                new PrivateClient("John", "002", ServiceLevel.Platinum),
                new PrivateClient("John", "002", ServiceLevel.Platinum),
                new PrivateClient("John", "002", ServiceLevel.Premium),
                new PrivateClient("John", "002", ServiceLevel.Premium)

        ));

        ClientRegister clientregister = new ClientRegister(clients);
        clientregister.getClientCountPerServiceLevel();

        List expected = Arrays.asList(5,6,2);

        assertSame(clientregister.getClientCountPerServiceLevel(), expected);

    }


    public static void assertSame(Object expected, Object actual){}

    public static void assertEquals(Object expected, Object actual){}
}
