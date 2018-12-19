package com.ediweb.education.protocol;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestUserSerialize {

    private static final Logger log = Logger.getLogger(User.class.getName());

    private User user;
    private ByteArrayOutputStream userXml;
    //private ByteArrayInputStream xmlUser;
    private byte[] xmlUser;
    private User userFromFile;
    private String filePath;

    @Test
    @Before
    public void testInitializeUser() {

        user = new User();
        user.setId(1);
        user.setName("Ivan");
        user.setFullName("Ivan Mataras");
        user.setOrganizationId(1);
        user.setRoleId(1);
        user.setPassword("12345");

        userXml = new ByteArrayOutputStream(1024);

    }

    @Test
    @Before
    @Ignore
    public void testInitializeUserXml() {

        String filePath = getClass().getResource("/user.xml").getPath();
        InputStream xmlFile = getClass().getResourceAsStream("/user.xml");

/*        int b;
        try {
            while ((b = xmlFile.read()) != -1) {
                userXml.write(b);
            }
        } catch (IOException ioException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(ioException.getMessage());
        }*/
    }

    @Test
    public void testUserFromObjectToXml() {
        try {
            JAXBContext context = JAXBContext.newInstance(User.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            //marshaller.marshal(user, new File(filePath));
            marshaller.marshal(user, userXml);
            xmlUser = userXml.toByteArray();
        } catch (JAXBException jaxbException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(jaxbException.getMessage());
        }
    }

    @Test
    @Ignore
    public void testUserFromXmlToObject() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            userFromFile = (User) unmarshaller.unmarshal(new ByteArrayInputStream(xmlUser));
        } catch (JAXBException jaxbException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(jaxbException.getMessage());
        }
    }

}
