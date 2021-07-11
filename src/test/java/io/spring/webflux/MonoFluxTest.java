package io.spring.webflux;

import java.time.Duration;
import java.util.stream.IntStream;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

	
	@Test
	public void monoTest() {
		Mono<Integer> mono = Mono.just(1).log();
		mono.subscribe(System.out::println);		
	}
	
	@Test
	public void fluxTest() {
		Flux<Integer> flux = Flux.just(1,2,3,4,5).log();
		flux.subscribe(System.out::println);	
	}
	
	
}
