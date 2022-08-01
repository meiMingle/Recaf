package me.coley.recaf.util;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Convenience calls for the error-able lambda types.
 *
 * @author Matt Coley
 */
public class Unchecked {
	/**
	 * @param runnable
	 * 		Runnable.
	 */
	public static void run(Runnable runnable) {
		runnable.run();
	}

	/**
	 * @param supplier
	 * 		Supplier.
	 * @param <T>
	 * 		Supplier type.
	 *
	 * @return Supplied value.
	 */
	public static <T> T get(UncheckedSupplier<T> supplier) {
		return supplier.get();
	}

	/**
	 * @param consumer
	 * 		Consumer.
	 * @param value
	 * 		Consumed value.
	 * @param <T>
	 * 		Consumer type.
	 */
	public static <T> void accept(UncheckedConsumer<T> consumer, T value) {
		consumer.accept(value);
	}

	/**
	 * @param fn
	 * 		Function.
	 * @param value
	 * 		Function value.
	 * @param <T>
	 * 		Input type.
	 * @param <R>
	 * 		Output type.
	 */
	public static <T, R> R map(UncheckedFunction<T, R> fn, T value) {
		return fn.apply(value);
	}

	/**
	 * @param fn
	 * 		Function.
	 * @param t
	 * 		First function value.
	 * @param u
	 * 		Second function value.
	 * @param <T>
	 * 		First input type.
	 * @param <U>
	 * 		Second input type.
	 * @param <R>
	 * 		Output type.
	 */
	public static <T, U, R> R bmap(UncheckedBiFunction<T, U, R> fn, T t, U u) {
		return fn.apply(t, u);
	}

	/**
	 * Helper method to created unchecked runnable.
	 *
	 * @param runnable
	 * 		Unchecked runnable.
	 *
	 * @return Unchecked runnable.
	 */
	public static Runnable runnable(UncheckedRunnable runnable) {
		return runnable;
	}

	/**
	 * Helper method to created unchecked consumer.
	 *
	 * @param consumer
	 * 		Unchecked consumer.
	 *
	 * @return Unchecked consumer.
	 */
	public static <T> Consumer<T> consumer(UncheckedConsumer<T> consumer) {
		return consumer;
	}

	/**
	 * Helper method to created unchecked function.
	 *
	 * @param fn
	 * 		Unchecked function.
	 *
	 * @return Unchecked function.
	 */
	public static <T, R> Function<T, R> function(UncheckedFunction<T, R> fn) {
		return fn;
	}

	/**
	 * Helper method to created unchecked function.
	 *
	 * @param fn
	 * 		Unchecked function.
	 *
	 * @return Unchecked function.
	 */
	public static <T, U, R> BiFunction<T, U, R> bfunction(UncheckedBiFunction<T, U, R> fn) {
		return fn;
	}
}