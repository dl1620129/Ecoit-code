export class LegalType {
    public name: string;
    public typeId: number;
    public description: string;
    public parentId: number;
    public position: number;
    public child: Array<LegalType>;
    constructor() {};
}