package com.ediweb.education.protocol;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestUserSerialize {

    private static final Logger log = Logger.getLogger(User.class.getName());

    private User user;
    private User newUser;
    private ByteArrayOutputStream userXmlFile;

    private String xmlFilePath;
    private String xsdFilePath;
    private InputStream xmlFile;
    private InputStream xsdFile;
    private JAXBContext context;

    @Test
    @Before
    public void TestInitializeResources() {
        xmlFilePath = getClass().getResource("/xml/User.xml").getPath();
        xsdFilePath = getClass().getResource("/xsd/User.xsd").getPath();
        xmlFile = getClass().getResourceAsStream("/xml/User.xml");
        xsdFile = getClass().getResourceAsStream("/xml/User.xsd");
        userXmlFile = new ByteArrayOutputStream(1024);
    }

    @Test
    @Before
    public void TestInitializeJAXBContext() {
        try {
            context = JAXBContext.newInstance(User.class);
        } catch (JAXBException jaxbException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(jaxbException.getMessage());
        }
    }

    @Test
    @Before
    public void TestInitializeUser() {
        user = new User();
        user.setId(1);
        user.setName("Ivan");
        user.setFullName("Ivan Mataras");
        user.setOrganizationId(1);
        user.setRoleId(1);
        user.setPassword("1234");
    }

    @Test
    public void TestMarshallUserFromObjectToXmlWithXSD() {
        try {
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema userSchema = schemaFactory.newSchema(new File(xsdFilePath));
            marshaller.setSchema(userSchema);
            marshaller.marshal(user, userXmlFile);
        } catch (JAXBException | SAXException exception) {
            if (log.isLoggable(Level.SEVERE)) log.severe(exception.getMessage());
        }
    }

    @Test
    public void TestUnmarshallUserFromXmlToObjectWithXSD() {
        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema userSchema = schemaFactory.newSchema(new File(xsdFilePath));
            unmarshaller.setSchema(userSchema);
            newUser = (User) unmarshaller.unmarshal(new File(xmlFilePath));
        } catch (JAXBException | SAXException exception) {
            if (log.isLoggable(Level.SEVERE)) log.severe(exception.getMessage());
        }
    }

}
