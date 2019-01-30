import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;

@XmlRootElement
public class ArrayListForSerialyzer extends ArrayList<Employee> implements Serializable {
    public ArrayListForSerialyzer(){}

    @XmlElement
    public ArrayList<Employee> getEmployee() {
        return this;
    }

}
