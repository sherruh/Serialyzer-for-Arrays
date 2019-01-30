public class Main {
    public static void main(String[] args) {
        ArrayListForSerialyzer employees=new ArrayListForSerialyzer();
        employees.add(new Employee("Ivan",25,1500));
        employees.add(new Employee("Petya",54,500));
        employees.add(new Employee("John",34,2500));

        Serialyzer serialyzer=new Serialyzer();

        serialyzer.serializeXml(employees);
        employees=serialyzer.deserializeXml();
        System.out.println(employees);

        serialyzer.serializeJson(employees);
        employees=serialyzer.deserializeJson();
        System.out.println(employees);
    }
}
