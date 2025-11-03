import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { CheckList } from '../interfaces/checklist';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {

  @Input() question:CheckList={question:"",answer:""}
  @Output() sendAnswer=new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }
  uploadAnswer(answer:any){
    this.question.answer=answer.target.value;
    this.sendAnswer.emit(this.question)
  }
}
