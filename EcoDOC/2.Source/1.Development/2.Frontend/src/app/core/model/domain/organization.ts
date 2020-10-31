import { Category } from "./category";
import { Client } from "./client";

export class Organization { 
    id: number;
	name: string;
	phone: string;
	address: string;
	email: string;
	level: number;
	parentId: number;
	orgType: any;
	orgs: Organization[];
	expiryDate: string;
	order: number;
	active: any;
	selected = false;
	client
}