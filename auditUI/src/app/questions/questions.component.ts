import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { CheckList } from '../interfaces/checklist';
import { ChecklistService } from '../services/checklist.service';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  @Input() questions:CheckList[]=[]
  @Output() sendAnswers=new EventEmitter();
  constructor(private service:ChecklistService) { }

  ngOnInit(): void {
  }

  uploadAnswer(question:CheckList){
    for(let i=0;i<this.questions.length;i++){
      if(this.questions[i].question.match(question.question)){
        this.questions[i].answer=question.answer;
      }
    }
    this.sendAnswers.emit(this.questions);
  }

  
}
