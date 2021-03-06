//version 8: Javac 6 will error out due to `ChildBuilder` not existing before properly running lombok. Giving j6 support status, not worth fixing.
iimport java.util.List;

public class SuperBuilderWithCustomBuilderMethod {
	@lombok.experimental.SuperBuilder
	public static class Parent<A> {
		A field1;
		@lombok.Singular List<String> items;
	}
	
	@lombok.experimental.SuperBuilder
	public static class Child<A> extends Parent<A> {
		double field3;
		public static <A> ChildBuilder<A, ?, ?> builder() {
			return new ChildBuilderImpl<A>().item("default item");
		}
	}
	
	public static void test() {
		Child<Integer> x = Child.<Integer>builder().field3(0.0).field1(5).item("").build();
	}
}
