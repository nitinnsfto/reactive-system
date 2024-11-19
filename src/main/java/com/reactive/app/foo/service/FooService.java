package com.reactive.app.foo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reactive.app.foo.Foo;
import com.reactive.app.foo.FooNameHelper;
import com.reactive.app.foo.FooQuantityHelper;
import com.reactive.app.foo.FooReporter;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;

public class FooService {
	
	private static Logger logger=LoggerFactory.getLogger(FooService.class);

	public void processFoo(Flux<Foo> flux)
	 {
		
		flux.map(FooNameHelper::concatFooName)
		.map(FooNameHelper::subStringFooName)
		.map(FooReporter::reportResults)
		.doOnError( error ->  {
			logger.error("The following error happened on processFoo method!", error);
		})
		.subscribe(foo-> {
			logger.debug("Finished processing Foo with Id", foo.getId());
		});
	 }

	public void processFooInAnotherScenario(Flux<Foo> flux)
	 {
		
		flux.map(FooNameHelper::subStringFooName)
		.map(FooQuantityHelper::divideFooQuantity)
		.subscribe();
	 }
	
	public static void main(String[] args) {
		List<String> elements = new ArrayList<>();
		
		Flux<Integer> just = Flux.just(1,2,3,4);

		Mono<Integer> just1 = Mono.just(1);
		
		Publisher<Integer> just2 = Mono.just(1);
		
		just
		.log()
		.map(i->i*2)
		.zipWith(Flux.range(0, Integer.MAX_VALUE), (one, two) -> String.format("First flux : %d, Second flux: %d", one, two))
		.subscribe(elements::add);
		
		elements.stream()
		.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);				
			}
			
		});
		
		assertThat(elements).containsExactly("First flux : 2, Second flux: 0",
				"First flux : 4, Second flux: 1",
				"First flux : 6, Second flux: 2",
				"First flux : 8, Second flux: 3");
		
		List<Integer> collected = Stream.of(1,2,3,4).collect(Collectors.toList());
		

	}
}
