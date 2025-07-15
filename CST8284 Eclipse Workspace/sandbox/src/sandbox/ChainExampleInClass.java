package sandbox;

class ChainExampleInClass {

	private int student;
	private double grade;
	private String name;
	
	public ChainExampleInClass() {
		this(0.0);
	}
    public ChainExampleInClass(double grade) {
		this("No Name", grade);
	}
    public ChainExampleInClass(String name) {
		this(name, 0.0);
	}
    public ChainExampleInClass(String name, double grade) {
    	if (grade > 0.0) {
		this.grade = grade;}
    	this.name = name;
	}
	public ChainExampleInClass setValue(int value) {
        this.student = student;
        return this;
    }

    public int getValue() {
        return student;
    }

}
