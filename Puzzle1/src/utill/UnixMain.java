package utill;

public class UnixMain {

	public static void main(String[] args) {
		StringFormatter formatter = new StringFormatter("/home/a/./x/../fff/b//c/");
		System.out.println(formatter.toUnix());
	}

}

