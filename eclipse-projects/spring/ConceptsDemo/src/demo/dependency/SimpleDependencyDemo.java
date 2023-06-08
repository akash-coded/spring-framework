package demo.dependency;

class DemoClass {
	
	private int dataMember; // dependency
	
	DemoClass(int param) {
		System.out.println("Constructor with args. Value of param = " + param);
	}

	public int getDataMember() {
		return dataMember;
	}

	public void setDataMember(int dataMember) {
		this.dataMember = dataMember;
	}
	
}

public class SimpleDependencyDemo {

	public static void main(String[] args) {
		DemoClass obj = new DemoClass(5);	
	}

}
