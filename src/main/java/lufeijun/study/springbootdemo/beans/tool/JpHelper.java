package lufeijun.study.springbootdemo.beans.tool;

public class JpHelper {

	public String name;

	public void setName(String name) {
		this.name = name;
	}

	public JpHelper() {
	}

	public JpHelper(String name) {
		this.name = name;
	}

	public void add() {
		System.out.println("this is add");
	}
}
