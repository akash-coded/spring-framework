/**
 * 
 */
package demo.dependency;

import java.util.Arrays;

/**
 * @author Akash
 *
 */
class PojoDemo {
	
	String name;
	String[] expertise;
	
	{
		this.expertise = new String[]{"Java Full Stack", "MERN", "MEAN", "PHP", "SQL", "Data Engineering", "Python", "R", "NLP", "ML", "Laravel", "Matlab"};
	}
	
	PojoDemo() {
		this.name = "Akash Das";
	}
	
	PojoDemo(String[] expertise) {
		this.name = "Akash Das";
		this.expertise = expertise;
	}
	
	PojoDemo(String name, String[] expertise) {
		this.name = name;
		this.expertise = expertise;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the expertise
	 */
	public String[] getExpertise() {
		return expertise;
	}

	/**
	 * @param expertise the expertise to set
	 */
	public void setExpertise(String[] expertise) {
		this.expertise = expertise;
	}

	@Override
	public String toString() {
		return "PojoDemo [name=" + name + ", expertise=" + Arrays.toString(expertise) + "]";
	}
	
}

class DependentClass {
	
	PojoDemo dependency1;
	
	public DependentClass() {}
	
	/**
	 * @param dependency1
	 */
	public DependentClass(PojoDemo dependency1) {
		this.dependency1 = dependency1;
	}
	
	/**
	 * @param dependency1 the dependency1 to set
	 */
	public void setDependency1(PojoDemo dependency1) {
		this.dependency1 = dependency1;
	}

	@Override
	public String toString() {
		return "DependentClass [dependency1=" + dependency1 + "]";
	}
	
}

public class DependencyResolutionDemo {

	/**
	 * 
	 */
	public DependencyResolutionDemo() {}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PojoDemo pojo1 = new PojoDemo();
		
		// Method-1: Property Resolution
		DependentClass obj1 = new DependentClass();
		obj1.dependency1 = pojo1;
		System.out.println(obj1);
		
		// Method-2: Constructor Resolution
		DependentClass obj2 = new DependentClass(pojo1);
		System.out.println(obj2);
		
		// Method-3: Setter Resolution
		DependentClass obj3 = new DependentClass();
		obj3.setDependency1(pojo1);
		System.out.println(obj3);

	}

}
