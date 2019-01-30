import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

public class Serialyzer {
    public void serializeXml(ArrayListForSerialyzer employees) {
        try {

            File file = new File("employees.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(ArrayListForSerialyzer.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(employees, file);
            jaxbMarshaller.marshal(employees, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public ArrayListForSerialyzer deserializeXml() {
        ArrayListForSerialyzer employees = null;
        try {

            File file = new File("employees.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(ArrayListForSerialyzer.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            employees = (ArrayListForSerialyzer) jaxbUnmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public void serializeJson(ArrayListForSerialyzer employees) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("employees.json"), employees);
            String jsonInString=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employees);
            System.out.println(jsonInString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayListForSerialyzer deserializeJson() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayListForSerialyzer employees = null;
        try {
            employees = mapper.readValue(new File("employees.json"), ArrayListForSerialyzer.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }
}
