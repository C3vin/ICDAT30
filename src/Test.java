public class Test {
	public interface Output {
		public String outMsg = "start output";
		public void out();
	}
	public interface Draw {
		public String drawMsg = "start drawing";
		public void draw();
	}
	public interface Tool {
		public void tool();
	}
	public class Car implements Output, Draw {
		public void draw() {
			System.out.println("Car " + Draw.drawMsg);
		}

		public void out() {
			System.out.println("Output: " + Output.outMsg);
		}
	}
	public interface Bike extends Tool, Draw {

	}
	public class OOO implements Bike {
		@Override
		public void tool() {
			System.out.println("tool");
		}

		@Override
		public void draw() {
			System.out.println("deaw");			
		}
	}
	public static void main(String[] args) {
		Test t = new Test();      
		Car c = t.new Car();
		c.draw();
		c.out();
		Bike b = t.new OOO();
		b.draw();
		b.tool();
		
		Output o = t.new Car();
		o.out();
	}
}
