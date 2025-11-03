import { AuditDetails } from "./AuditDetails";

export interface ProjectAudit{
    projectId:number,
	projectName:string,
	projectManagerName:string,
    applicationOwnername:string,
    auditDetails:AuditDetails[]
}