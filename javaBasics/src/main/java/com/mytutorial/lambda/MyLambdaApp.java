package com.mytutorial.lambda;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MyLambdaApp {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		TestPerson person1 = new TestPerson("Horst", "Katzmeier");

		/** predicate **/
		Predicate<TestPerson> isMalePredicate = new Predicate<TestPerson>() {
			@Override
			public boolean test(TestPerson t) {
				return t.isMale();
			}
		};
		Predicate<TestPerson> isMalePredicateLambda = t -> t.isMale();
		Predicate<TestPerson> isMalePredicateMR = TestPerson::isMale;

		/** function **/
		Function<TestPerson, String> getNameFunction = new Function<TestPerson, String>() {
			@Override
			public String apply(TestPerson t) {
				return t.getName();
			}
		};
		Function<TestPerson, String> getNameFunctionLambda = p -> p.getName();
		Function<TestPerson, String> getNameFunctionMR = TestPerson::getName;

		/** consumer **/
		Consumer<TestPerson> consumer = new Consumer<TestPerson>() {

			@Override
			public void accept(TestPerson t) {
				t.doSomething();
			}

		};
		
		person1=null;
		
		Consumer<TestPerson> consumerLambda = n -> n.doSomething();
		Consumer<TestPerson> consumerMR = TestPerson::doSomething;

		/** supplier **/
		Supplier<TestPerson> supplier = new Supplier<TestPerson>() {

			@Override
			public TestPerson get() {
				return new TestPerson();
			}
		};

		Supplier<TestPerson> supplierLambda = () -> new TestPerson();
		Supplier<TestPerson> supplierMR = TestPerson::new;

		
		
		/** weitere Beispiele **/
		BiPredicate<String, String> spLambda = (s, t) -> s.equalsIgnoreCase(t);
		BiPredicate<String, String> spMR= String::equalsIgnoreCase;

		BiFunction<String, String, Boolean> sp2 = (s, t) -> s.equalsIgnoreCase(t);
		sp2=String::equalsIgnoreCase;
		
		Object objectPredicate = new Predicate<TestPerson>() {
			@Override
			public boolean test(TestPerson t) {
				return t.isMale();
			}
		}; 
		objectPredicate=(Predicate<TestPerson>)t -> t.isMale();

	}
}
