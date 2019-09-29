
public class DuckCall {

	QuackBehaviour quackBehaviour;
	
	public DuckCall() {
		quackBehaviour = new Quack();
	}
	
	public void performQuack() {
		quackBehaviour.quack();
	}

}
