import { AuditDetailsRequest } from "./auditDetailsRequest";

export interface AuditRequest{
	projectName:string,
	projectManagerName:string,
    applicationOwnername:string,
    auditDetails:AuditDetailsRequest
}