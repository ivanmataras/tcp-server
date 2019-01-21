package com.ediweb.education.protocol;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestUserSerialize {

    private static final Logger log = Logger.getLogger(User.class.getName());

    private User user;
    private User newUser;
    private ByteArrayOutputStream userXml;
    //private ByteArrayInputStream xmlUser;
    private byte[] xmlUser;
    private User userFromFile;
    private String filePath;

    private String xmlFile;
    private String xsdFile;
    private JAXBContext jaxbContext;

    @Test
    @Before
    public void TestInitializeJAXBContext() {

        xmlFile = getClass().getResource("/xml/User.xml").getPath();
        xsdFile = getClass().getResource("/xsd/User.xsd").getPath();

        try {
            jaxbContext = JAXBContext.newInstance(User.class);
        } catch (JAXBException jaxbException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(jaxbException.getMessage());
        }

    }

    @Test
    @Before
    @Ignore
    public void TestInitializeUser() {

        user = new User();
        user.setId(1);
        user.setName("Ivan");
        user.setFullName("Ivan Mataras");
        user.setOrganizationId(1);
        user.setRoleId(1);
        user.setPassword("1234");

        userXml = new ByteArrayOutputStream(1024);

    }

    @Test
    @Before
    @Ignore
    public void TestInitializeUserXml() {

        String filePath = getClass().getResource("/xml/User.xml").getPath();
        InputStream xmlFile = getClass().getResourceAsStream("/xml/User.xml");

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
    @Ignore
    public void TestUserFromObjectToXml() {
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
    public void TestUserFromXmlToObject() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            userFromFile = (User) unmarshaller.unmarshal(new ByteArrayInputStream(xmlUser));
        } catch (JAXBException jaxbException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(jaxbException.getMessage());
        }
    }

    @Test
    public void TestJaxbXmlFileToUserObject() {

        try {
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema userSchema = schemaFactory.newSchema(new File(xsdFile));
            jaxbUnmarshaller.setSchema(userSchema);
            newUser = (User) jaxbUnmarshaller.unmarshal(new File(xmlFile));
        } catch (JAXBException | SAXException exception) {
            if (log.isLoggable(Level.SEVERE)) log.severe(exception.getMessage());
        }

    }

    @Test
    public void TestJaxbUserFromObjectToXml() {
        try {
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema userSchema = schemaFactory.newSchema(new File(xsdFile));
            jaxbMarshaller.setSchema(userSchema);
            //marshaller.marshal(user, new File(filePath));
            jaxbMarshaller.marshal(user, userXml);
            xmlUser = userXml.toByteArray();
        } catch (JAXBException | SAXException exception) {
            if (log.isLoggable(Level.SEVERE)) log.severe(exception.getMessage());
        }
    }

}
