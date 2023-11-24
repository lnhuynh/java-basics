package javaadvanced;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

public class JavaStream {
  public static void main(String[] args) throws IOException {
//    We should use the empty() method in case of the creation of an empty stream
    Stream<String> streamEmpty = Stream.empty();

//    We can also create a stream of any type of Collection (Collection, List, Set)
    Collection<String> collection = Arrays.asList("a", "b", "c");
    Stream<String> streamOfCollection = collection.stream();

//    An array can also be the source of a stream
    Stream<String> streamOfArray = Stream.of("a", "b", "c");
//    We can also create a stream out of an existing array or of part of an array
    String[] arr = new String[]{"a", "b", "c"};
    Stream<String> streamOfArrayFull = Arrays.stream(arr);
    Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

//    When builder is used, the desired type should be additionally specified in the right part of the statement,
//    otherwise the build() method will create an instance of the Stream<Object>
    Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();

//    Another way of creating an infinite stream is by using the iterate() method
    Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);

//    Stream<T> is a generic interface, and there is no way to use primitives as a type parameter with generics,
//    three new special interfaces were created: IntStream, LongStream, DoubleStream
    IntStream intStream = IntStream.range(1, 3); // 1, 2
    LongStream longStream = LongStream.rangeClosed(1, 3); // 1, 2, 3
    Random random = new Random();
    DoubleStream doubleStream = random.doubles(3);

//    Java NIO class Files allows us to generate a Stream<String> of a text file through the lines() method.
//    Every line of the text becomes an element of the stream
    Path path = Paths.get("C:\\file.txt");
    Stream<String> streamOfStrings = Files.lines(path);
    Stream<String> streamWithCharset = Files.lines(path, StandardCharsets.UTF_8);

//    An attempt to reuse the same reference after calling the terminal operation will trigger the IllegalStateException
//    We designed streams to apply a finite sequence of operations to the source of elements in a functional style, not to store elements.
//    Stream<String> stream = Stream.of("a", "b", "c").filter(element -> element.contains("b"));
//    Optional<String> anyElement = stream.findAny();
//    Optional<String> firstElement = stream.findFirst();
//    Above code should be correct like this
    List<String> elements = Stream.of("a", "b", "c")
      .filter(element -> element.contains("b"))
      .toList();
    Optional<String> anyElement = elements.stream().findAny();
    Optional<String> firstElement = elements.stream().findFirst();

//    Parallel Streams

//    When the source of a stream is a Collection or an array, it can be achieved with the help of the parallelStream() method
    Stream<Product> parallelStreamOfCollection = CollectExample.productList.parallelStream();
    boolean isParallel1 = parallelStreamOfCollection.isParallel();
    boolean bigPrice = parallelStreamOfCollection
      .map(product -> product.getPrice() * 12)
      .anyMatch(price -> price > 200);

//    If the source of a stream is something other than a Collection or an array, the parallel() method should be used
    IntStream intStreamParallel = IntStream.range(1, 150).parallel();
    boolean isParallel2 = intStreamParallel.isParallel();
  }
}

class Product {
  @Override
  public String toString() {
    return "Product{" +
      "price=" + price +
      ", name='" + name + '\'' +
      '}';
  }

  int price;

  public int getPrice() {
    return price;
  }

  String name;

  public Product(int price, String name) {
    this.price = price;
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
class CollectExample {

  static List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
    new Product(14, "orange"), new Product(13, "lemon"),
    new Product(23, "bread"), new Product(13, "sugar"));

  public static void main(String[] args) {
//    Converting a stream to the Collection (Collection, List or Set)
    List<String> collectorCollection = productList.stream().map(Product::getName).toList();

//    Reducing to String
    String listToString = productList
      .stream()
      .map(Product::getName)
      .collect(Collectors.joining(", ", "[", "]"));

//    Processing the average value of all numeric elements of the stream
    double averagePrice = productList.stream().collect(Collectors.averagingInt(Product::getPrice));

//    Processing the sum of all numeric elements of the stream
    int summingPrice = productList.stream().collect(Collectors.summingInt(Product::getPrice));

//    Collecting statistical information about stream’s elements
    IntSummaryStatistics statistics = productList.stream().collect(Collectors.summarizingInt(Product::getPrice));

//    Grouping of stream’s elements according to the specified function
    Map<Integer, List<Product>> collectorMapOfLists = productList.stream().collect(Collectors.groupingBy(Product::getPrice));

//    Dividing stream’s elements into groups according to some predicate
    Map<Boolean, List<Product>> mapPartioned = productList.stream().collect(Collectors.partitioningBy(element -> element.getPrice() > 15));

//    Pushing the collector to perform additional transformation
    Set<Product> unmodifiableSet = productList.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));

//    Custom collector
//    Collector.of is a static factory method in the Collector interface, allowing you to create a custom collector.
//    LinkedList::new is the supplier, providing a new LinkedList instance for the accumulation of elements.
//    LinkedList::add is the accumulator, specifying how to add an element to the collection.
//    The third argument is a combiner, used when parallel streams are involved. In this case, it combines two partial results.
//    The result type is LinkedList<Product>.
    Collector<Product, ?, LinkedList<Product>> toLinkedList =
    Collector.of(LinkedList::new, LinkedList::add,
      (first, second) -> {
         first.addAll(second);
         return first;
      });
    LinkedList<Product> linkedListOfProducts =
      productList.stream().collect(toLinkedList);
  }
}
