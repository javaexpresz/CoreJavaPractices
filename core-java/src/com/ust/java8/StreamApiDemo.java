package com.ust.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiDemo {
public static void main(String[] args) {
	List<Integer> list = Arrays.asList(1,2,3,4,6,8);
	
	List<Employee> empList = Arrays.asList(
			new Employee(101, "Sachin","IT", Arrays.asList(111,2222)),
			new Employee(103, "Amit","IT", Arrays.asList(777,888)),
			new Employee(103, "Ajay","SALSE", Arrays.asList(777,345)),
			new Employee(102, "Pankaj","FINANCE", Arrays.asList(333,2245,999)), // {"IT " : [{}]}
			new Employee(104, "Siva","SALSE", Arrays.asList(9911,2277))
		);
	///Stream<List<Employee>> of = Stream.of(empList);
	//Stream<Employee> stream = empList.stream();
	//System.out.println(stream);
	//System.out.println(of);
	
	Stream<Employee> filter = empList.stream().filter(e->e.getName().startsWith("A"));//intermediate operation
	//System.out.println(collect);
	
	List<Employee> filteredEmpList = empList.stream().filter(e->e.getName().startsWith("A")).collect(Collectors.toList());
	System.out.println(filteredEmpList);
	
	List<String> upperCaseNames = empList.stream().filter(e->e.getName().startsWith("A")).map(e->e.getName().toUpperCase()).collect(Collectors.toList());
	System.out.println(upperCaseNames);
	
	List<Integer> phones = empList.stream().flatMap(e->e.getPhones().stream()).collect(Collectors.toList());
	System.out.println(phones);
	
	Integer min = list.stream().min((o1,o2)->o1.compareTo(o2)).get();
	//Integer max = list.stream().max((o1,o2)->o1.compareTo(o2)).get();
	System.out.println(min);
	//System.out.println(max);
	
	Map<String, List<Employee>> groupByEmp = empList.stream().collect(Collectors.groupingBy(e->e.getDept(),Collectors.toList()));
	System.out.println(groupByEmp);
	
	//List<Employee> sortedEmpList = empList.stream().sorted(Comparator.comparing()).collect(Collectors.toList());
	//System.out.println(sortedEmpList);
	

	
}
}

class Employee{
	private Integer id;
	private String name;
	private String dept;
	private List<Integer> phones;
	public Employee() {}
	public Employee(Integer id, String name,String dept, List<Integer> phones) {
		this.id = id;
		this.name = name;
		this.dept=dept;
		this.phones = phones;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getPhones() {
		return phones;
	}
	public void setPhones(List<Integer> phones) {
		this.phones = phones;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", phones=" + phones + "]";
	}
	
	
}