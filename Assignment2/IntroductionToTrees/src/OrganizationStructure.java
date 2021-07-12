import java.util.*;


public class OrganizationStructure {
    public Employee ceo;

    public static class Employee {
        public String name;
        public String title;
        public List<Employee> directReports;
    }

    public OrganizationStructure(Employee ceo){
        this.ceo = ceo;
    }

    /**
     * print organization level by level
     */
    public void printOrganizationLevels(){
        Employee current = this.ceo;
        Queue<Employee> queue = new LinkedList<>();
        queue.add(current);
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                Employee currentEmployee = queue.poll();
                System.out.print(currentEmployee.name + ": " + currentEmployee.title);
                List<Employee> reports = currentEmployee.directReports;
                for(int j = 0; j < reports.size(); j++){
                    queue.add(reports.get(j));
                }
            }
            System.out.println();
        }
    }
    public int organizationLevelCount(){
        Employee current = this.ceo;
        Queue<Employee> queue = new LinkedList<>();
        queue.add(current);
        int levels = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            levels++;
            for(int i = 0; i < size; i++){
                Employee currentEmployee = queue.poll();
                List<Employee> reports = currentEmployee.directReports;
                for(int j = 0; j < reports.size(); j++){
                    queue.add(reports.get(j));
                }
            }
        }
        return levels;
    }
}
