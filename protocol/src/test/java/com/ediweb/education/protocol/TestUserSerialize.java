package com.ediweb.education.protocol;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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

class TestUserSerialize {

    private static final Logger log = Logger.getLogger(User.class.getName());

    private User user;
    private User newUser;
    private static ByteArrayOutputStream userXmlFile;

    private static String xmlFilePath;
    private static String xsdFilePath;
    private static InputStream xmlFile;
    private static InputStream xsdFile;
    private static JAXBContext context;

    @Test
    @BeforeAll
    static void TestInitializeResources() {
        xmlFilePath = TestUserSerialize.class.getResource("/xml/User.xml").getPath();
        xsdFilePath = TestUserSerialize.class.getResource("/xsd/User.xsd").getPath();
        xmlFile = TestUserSerialize.class.getResourceAsStream("/xml/User.xml");
        xsdFile = TestUserSerialize.class.getResourceAsStream("/xsd/User.xsd");
        userXmlFile = new ByteArrayOutputStream(1024);
    }

    @Test
    @BeforeAll
    static void TestInitializeJAXBContext() {
        try {
            context = JAXBContext.newInstance(User.class);
        } catch (JAXBException jaxbException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(jaxbException.getMessage());
        }
    }

    @Test
    void TestInitializeUser() {
        user = new User();
        user.setId(1);
        user.setName("Ivan");
        user.setFullName("Ivan Mataras");
        user.setOrganizationId(1);
        user.setRoleId(1);
        user.setPassword("1234");
    }

    @Test
    void TestMarshallUserFromObjectToXmlWithXSD() {
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
    void TestUnmarshallUserFromXmlToObjectWithXSD() {
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
