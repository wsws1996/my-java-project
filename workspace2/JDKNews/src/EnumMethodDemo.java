
public class EnumMethodDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Direction3 d1=Direction3.FRONT;
		Direction3 d2=Direction3.BEHIND;
		Direction3 d3=Direction3.RIGHT;
		Direction3 d4=Direction3.LEFT;
		System.out.println(d2.compareTo(d2));
		System.out.println("---------------");
		System.out.println(d1.name());
		System.out.println(d2.name());
		System.out.println(d1.ordinal());
		System.out.println(d2.ordinal());
		System.out.println("---------------");
		System.out.println(d1.toString());
		System.out.println("---------------");
		Direction3 d=Enum.valueOf(Direction3.class, "FRONT");
//		System.out.println(d.getName());
		Direction3[] num=Direction3.values();
		for (Direction3 direction3 : num) {
			System.out.println(direction3);
			System.out.println(direction3.getName());
		}
	}

}
