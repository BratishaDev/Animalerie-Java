import java.util.function.Consumer;

record OptionElement<T>(String label, Consumer<T> action) {}
