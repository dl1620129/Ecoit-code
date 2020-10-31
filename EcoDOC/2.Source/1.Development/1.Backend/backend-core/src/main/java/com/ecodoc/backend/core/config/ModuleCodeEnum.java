package com.ecodoc.backend.core.config;

public enum ModuleCodeEnum {
	PROCESS("PROCESS"), //Luồng
	RETAKE("RETAKE"), // Thu hồi
	DELEGATE("DELEGATE"), // Uỷ quyền
	USER("USER"), //Người dùng
	ORG("ORG"), //Đơn vị
	CATEGORY("CATEGORY"), //Danh mục
	DELEGATE_FLOW("DELEGATE_FLOW"), //Luồng ủy quyền
	DOCUMENT_BOOK("DOCUMENT_BOOK"), //Sổ văn bản

	DOC_OUT_RETAKE("DOC_OUT_RETAKE"), //Thu hồi văn bản đi
	DOC_IN_RETAKE("DOC_IN_RETAKE"), //Thu hồi văn bản đến
	//Văn bản đi
	DOCUMENT_IN("DOCUMENT_IN"), //Văn bản đi
	DRAFT_LIST("DRAFT_LIST"), //Văn bản trình ký
	DRAFT_HANDLE("DRAFT_HANDLE"), //Văn bản xử lý
	DOCUMENT_IN_LIST("DOCUMENT_IN_LIST"), //Danh sách văn bản đi
	DRAFT_ISSUED("DRAFT_ISSUED"), //Văn bản ban hành
	//Văn bản đến
	DOC_OUT_LIST("DOC_OUT_LIST"), //Tiếp nhận văn bản
	DOC_OUT_MAIN("DOC_IN_MAIN"), //Xử lý chính
	DOC_OUT_COMBINE("DOC_IN_SUPPORT"), //Xử lý phối hợp
	DOC_OUT_KNOW("DOC_IN_KNOW"), //Nhận để biết
	DOC_OUT_DONE("DOC_OUT_DONE"), //Đã xử lý
	DOC_OUT_WAIT("DOC_OUT_WAIT"), //Chờ xử lý
	//Ủy quyền
	DELEGATE_MANAGE("DELEGATE_MANAGE"), //Quản lý ủy quyền
	DOC_IN_DELEGATE("DOC_IN_DELEGATE"), //Văn bản đến ủy quyền
	DOC_OUT_DELEGATE("DOC_OUT_DELEGATE"), //Văn bản đi ủy quyền
	
	//Theo dõi văn bản
	TRACK_DOC_IN("TRACK_DOC_IN"), //Theo dõi văn bản đến
	TRACK_DOC_OUT("TRACK_DOC_OUT"); //Theo dõi văn bản đi

	private final String name;

	ModuleCodeEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

