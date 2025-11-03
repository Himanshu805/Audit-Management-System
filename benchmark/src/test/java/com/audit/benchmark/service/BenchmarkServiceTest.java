package com.audit.benchmark.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



import com.audit.benchmark.model.Benchmark;
import com.audit.benchmark.repository.BenchmarkRepository;




@SpringBootTest
@RunWith(SpringRunner.class)
public class BenchmarkServiceTest {

@Mock
private BenchmarkRepository benchmarkRepository;


@InjectMocks
private BenchmarkService benchmarkService;

Benchmark benchmark1=new Benchmark(12,"Internal",3,"no needed");
Benchmark benchmark2=new Benchmark(12,"SOX",2,"no needed");

@Test
public void addCSVToDatabase() {
Benchmark benchmark1=new Benchmark(12,"Internal",3,"no needed");
when(benchmarkRepository.save(benchmark1)).thenReturn(benchmark1);

}

@Test
public void getAcceptableNo() {
when(benchmarkRepository.findByAuditType(benchmark1.getAuditType()))
.thenReturn(benchmark1);
assertEquals(benchmark1,benchmarkService.getAcceptableNo(benchmark1.getAuditType()));





}




}