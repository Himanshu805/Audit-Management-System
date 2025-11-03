package com.audit.checklist.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.checklist.model.QuestionsEntity;
import com.audit.checklist.repository.QuestionRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepository;
	
	public void addQuestionsToDatabse(String filename) throws CsvValidationException, IOException {
		questionRepository.deleteAll();
		CSVReader sc = new CSVReader(new FileReader(filename));  
		while (true) 
		{  
			String[] data=sc.readNext();
			questionRepository.save(new QuestionsEntity(data[0],data[1]));
		}    
	}
	
	public List<QuestionsEntity> getQuestions(String auditType){
		return questionRepository.findByAuditType(auditType);
	}
	
}
