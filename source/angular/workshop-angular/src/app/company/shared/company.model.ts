import { UUID } from "crypto";

export default class Company {
    id: UUID;
    name: string;
    companyIdentifier: string;
    phoneNumber: number;
   
    constructor(id: UUID, name: string, companyIdentifier: string, phoneNumber: number) {
        this.id = id;
        this.name = name;
        this.companyIdentifier = companyIdentifier;
        this.phoneNumber = phoneNumber;
    }
}
