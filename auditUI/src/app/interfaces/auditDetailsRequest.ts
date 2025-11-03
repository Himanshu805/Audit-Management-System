import { CheckList } from "./checklist";

export interface AuditDetailsRequest{
    auditType:string
    auditDate:Date
    questions:CheckList[]
}