
public abstract class Direction2 {
	public static final Direction2 FRONT=new Direction2("FRONT"){
		@Override
		public void show() {
			System.out.println("FRONT");
		};
	};
	public static final Direction2 BEHIND=new Direction2("BEHIND"){
		@Override
		public void show() {
			System.out.println("BEHIND");
		};
	};
	public static final Direction2 LEFT=new Direction2("LEFT"){
		@Override
		public void show() {
			System.out.println("LEFT");
		};
	};
	public static final Direction2 RIGHT=new Direction2("RIGHT"){
		@Override
		public void show() {
			System.out.println("RIGHT");
		};
	};
	
	private Direction2(String name){
		this.name=name;
	}
	private String name;
	public String getName() {
		return name;
	}
	public abstract void show();
}
