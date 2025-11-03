package com.audit.severity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsEntity {
	private int qid;
	private String question,answer;
	public QuestionsEntity(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}
	
}
