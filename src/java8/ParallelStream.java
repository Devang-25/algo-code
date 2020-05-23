package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class ParallelStream {

  private static String process(int i) {
    try {
      Thread.sleep(8000);
    } catch (InterruptedException ie) {

    }
    return String.format("The number %d is formatted", i);
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException, CancellationException {
    List<Integer> list = IntStream.range(0, 10).boxed().collect(Collectors.toList());

    List<String> strList = list.parallelStream().map(val -> process(val)).collect(Collectors.toList());
    strList.forEach(System.out::println);

    List<String> strList2 = list.stream().map(val -> process(val)).collect(Collectors.toList());
    strList2.forEach(System.out::println);

    ListeningExecutorService executorService = MoreExecutors
        .listeningDecorator(Executors.newFixedThreadPool(list.size()));
    List<ListenableFuture<String>> list2 = new ArrayList<>();
    final CountDownLatch latch = new CountDownLatch(list.size());

    for (Integer val : list) {
      list2.add(executorService.submit(new Callable<String>() {
        @Override
        public String call() throws Exception {
          String p = process(val);
          // latch.countDown();
          return p;
        }
      }));
    }
    executorService.shutdown();
    // latch.await();
    list2.forEach((f) -> {
      try {
        System.out.println(f.get());
      } catch (Exception e) {

      }
    });

  }
}
