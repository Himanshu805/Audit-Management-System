package com.audit.benchmark.service;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.benchmark.model.Benchmark;
import com.audit.benchmark.repository.BenchmarkRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class BenchmarkService {
	
	@Autowired
	private BenchmarkRepository benchmarkRepository;
	
	public Benchmark getAcceptableNo(String auditType) {
		return benchmarkRepository.findByAuditType(auditType);
	}
	
	public void addCSVToDatabase(String filename) throws CsvValidationException, IOException {
		benchmarkRepository.deleteAll();
		CSVReader sc = new CSVReader(new FileReader(filename));  
		while (true) 
		{  
			String[] data=sc.readNext();
			benchmarkRepository.save(new Benchmark(data[0],Integer.parseInt(data[1]),data[2]));
		}    
	}
}
