package com.jiten.samples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Java8Samples {

    public static void main(String[] args) throws IOException {
        intStream();
        System.out.println();
        System.out.println();
        streamSamples();

        System.out.println();
        System.out.println("add strings and sort..");
        System.out.println();
		filterNumbers(Arrays.asList(1,2,3,4,5));
		System.out.println();
		//filter and soft customers
		System.out.println();
		filterAndSortCustomers();
		System.out.println();
		System.out.println();
		
		//creating an own Functional interface, and executing the abstract method in that
		MyFunct my = () -> System.out.println("Functional..!");
		my.myMethod();
        
    }

    public static void intStream(){
        //print 1 - 10 using IntStream.range
        IntStream
                .range(1,11)
                .forEach(System.out::print);

        System.out.println();
        //skip first five in the range
        IntStream
                .range(1,11)
                .skip(5)
                .forEach(System.out::print);

        System.out.println();

        //range with sum
        System.out.println( "sum = " +
        IntStream
                .range(1,6)
                .sum()
                          );
        System.out.println();

    }


    //stream functions
    public static void streamSamples() throws IOException {

        //using Stream.of
       Stream
               .of("Jiten","Sai","Chakram", "Latha", "Prabha")
               .sorted()
               .findFirst()
               .ifPresent(s -> System.out.println("first = " + s));

        System.out.println();

        //sort String[] using streams
        String[] names = new String[]{"Jiten","Sai","Chakram", "Latha", "Prabha"};
        Arrays.stream(names)
                .sorted((s,s1) -> s.compareTo(s1))
                .forEach(x -> System.out.print(x + " "));
        System.out.println();

        //filter names start with S
        String[] nameArr = new String[]{"Jiten","Sai","Chakram", "Latha", "Prabha", "SKeshav"};
        Arrays.stream(nameArr)
                .filter(t -> t.startsWith("S"))
                .sorted((s,s1) -> s.compareTo(s1))
                .forEach(x -> System.out.print(x + " "));
        System.out.println();


        //avg of squares
        int[] nums = new int[] {2,3,4,};
        Arrays.stream(nums)
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);
        System.out.println();

        //to lower case
//        String[] nameArr = new String[]{"Jiten","Sai","Chakram", "Latha", "Prabha", "SKeshav"};
        Arrays.stream(nameArr)
                .map(s -> s.toLowerCase())
                .filter(t -> t.startsWith("s"))
                .sorted((s,s1) -> s.compareTo(s1))
                .forEach(x -> System.out.print(x + " "));
        System.out.println();

        //read lines from file, and filter them
        Stream<String> lines = Files.lines(Paths.get("sample.txt"));
        lines
                .sorted()
                .filter(x -> x.length() > 3)
                .forEach(x -> System.out.print(x + " "));
        System.out.println();
        lines.close();


        //counting non empty rows in file
        Stream<String> lines1 = Files.lines(Paths.get("sample.txt"));
        int rowCount  = (int) lines1
                .sorted()
                .filter(x -> x.length() > 3)
                .count();
        System.out.println("rowCount = " + rowCount);
        lines.close();

        //find count of doubles
        System.out.println( "Total of doubles = " +
        Stream.of(3.5, 8.9, 10.2, 5.6, 8.9)
                .reduce(0.0, (a,b) -> a + b)
        );

        //find statistics
        System.out.println("Int Statistics = " +
        IntStream.of(10, 8, 22, 7, 34, 5,1)
                .summaryStatistics()
                          );
    }    
    
    
private static void filterNumbers(List<Integer> list) {
		
		List<Integer> newList = 
				list.stream()
		.filter(i -> (i%2 != 0))
		.map(i -> i * 2)
		.collect(Collectors.toList());
			
		newList.forEach(i -> System.out.print(i + " "));
//		{{1,2},{3,4},{5,6}} - {1,2,3,4,5}
//		flatmap(Collections::stream)
	}

	/**
	 * Create an object Customer with properties of age and name.
	Create a list of customers
	
	Using Java 8 features, print out a list of customers whose age is less than 35, sorted by name
	*/
	private static void filterAndSortCustomers() {
		List<Customer> custList = new ArrayList<>();
		custList.add(new Customer("Jit", 32));
		custList.add(new Customer("it1", 46));
		custList.add(new Customer("Nit", 33));
		custList.add(new Customer("Mit", 26));
		
		custList
		.stream()
		.filter(c -> c.getAge() <35)
		.sorted((c1,c2) -> c1.getName().compareTo(c2.getName()))
		.forEach(System.out::println);
	}
	
	//printing values of map
	public static void printValues() {
		Map<String,String> map = new HashMap<>();
		map.put("Jit", "Irving");
		map.put("Jiten", "75063");
		
		map.entrySet()
		.stream()
		.forEach(e -> System.out.println(e.getKey()+ " : "+ e.getValue()));
		
	}
}


class Customer {
	private int age;
	private String name;
	
	Customer(){
		
	}
	
	Customer(String name, int age){
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name + " : " + this.age;
	}
}

/**
 * My functional interface
 * @author jittu
 *
 */
interface MyFunct{
	void myMethod();
}




