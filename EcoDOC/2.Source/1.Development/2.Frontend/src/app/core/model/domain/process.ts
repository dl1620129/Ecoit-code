import { INode } from './node'
import { Organization } from './organization'

export class IProcess {
    id: number;
    active: boolean;
    createDate: string;
    updateDate: string;
    createBy: number;
    updateBy: number;
    orgId: number;
    org: Organization = new Organization()
    name: string;
    content: string = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" targetNamespace=\"\" xsi:schemaLocation=\"http://www.omg.org/spec/BPMN/20100524/MODEL http://www.omg.org/spec/BPMN/2.0/20100501/BPMN20.xsd\">\n  <process id=\"Process_0l7d3rj\">\n    <startEvent id=\"Event_000a9fg\">\n      <outgoing>Flow_1x3osg7</outgoing>\n    </startEvent>\n    <task id=\"Activity_0ictzx5\">\n      <incoming>Flow_1x3osg7</incoming>\n      <outgoing>Flow_1qaycfp</outgoing>\n    </task>\n    <sequenceFlow id=\"Flow_1x3osg7\" sourceRef=\"Event_000a9fg\" targetRef=\"Activity_0ictzx5\" />\n    <endEvent id=\"Event_0c6fm7l\">\n      <incoming>Flow_1qaycfp</incoming>\n    </endEvent>\n    <sequenceFlow id=\"Flow_1qaycfp\" sourceRef=\"Activity_0ictzx5\" targetRef=\"Event_0c6fm7l\" />\n  </process>\n  <bpmndi:BPMNDiagram id=\"sid-74620812-92c4-44e5-949c-aa47393d3830\">\n    <bpmndi:BPMNPlane id=\"sid-cdcae759-2af7-4a6d-bd02-53f3352a731d\" bpmnElement=\"Process_0l7d3rj\">\n      <bpmndi:BPMNEdge id=\"Flow_1qaycfp_di\" bpmnElement=\"Flow_1qaycfp\">\n        <omgdi:waypoint x=\"480\" y=\"180\" />\n        <omgdi:waypoint x=\"612\" y=\"180\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1x3osg7_di\" bpmnElement=\"Flow_1x3osg7\">\n        <omgdi:waypoint x=\"248\" y=\"180\" />\n        <omgdi:waypoint x=\"380\" y=\"180\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"Event_000a9fg_di\" bpmnElement=\"Event_000a9fg\">\n        <omgdc:Bounds x=\"212\" y=\"162\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_0ictzx5_di\" bpmnElement=\"Activity_0ictzx5\">\n        <omgdc:Bounds x=\"380\" y=\"140\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_0c6fm7l_di\" bpmnElement=\"Event_0c6fm7l\">\n        <omgdc:Bounds x=\"612\" y=\"162\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n    <bpmndi:BPMNLabelStyle id=\"sid-e0502d32-f8d1-41cf-9c4a-cbb49fecf581\">\n      <omgdc:Font name=\"Arial\" size=\"11\" isBold=\"false\" isItalic=\"false\" isUnderline=\"false\" isStrikeThrough=\"false\" />\n    </bpmndi:BPMNLabelStyle>\n    <bpmndi:BPMNLabelStyle id=\"sid-84cb49fd-2f7c-44fb-8950-83c3fa153d3b\">\n      <omgdc:Font name=\"Arial\" size=\"12\" isBold=\"false\" isItalic=\"false\" isUnderline=\"false\" isStrikeThrough=\"false\" />\n    </bpmndi:BPMNLabelStyle>\n  </bpmndi:BPMNDiagram>\n</definitions>";
    nodes: INode[] = [];
    typeDocument: string;
}
