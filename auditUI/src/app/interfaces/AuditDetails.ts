import { CheckList } from "./checklist";

export interface AuditDetails{
    aid:number,
    auditType:string,
    auditDate:Date
    executionStatus:string,
    remedialAction:string,
}