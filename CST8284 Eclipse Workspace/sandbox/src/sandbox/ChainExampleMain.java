package sandbox;

public class ChainExampleMain {

	public static void main(String[] args) {
		ChainExample example = new ChainExample();
		ChainExampleInClass exampleInClass = new ChainExampleInClass();
		int result = example.setValue(5).add(3).multiply(2).add(3).chain().getValue();
		int resultInClass = exampleInClass.getValue();
		System.out.println(result);
		System.out.println(resultInClass);
	}

}
