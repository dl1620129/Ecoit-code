package com.ecodoc.backend.core.config;

public enum NotificationHandleStatusEnum {
	DU_THAO("Dự thảo"),
	DA_TRINH_KY("Đã trình ký"),
	CHO_Y_KIEN("Chờ cho ý kiến"),
	DA_Y_KIEN("Đã cho ý kiến"),
	CHO_XU_LY("Chờ xử lý"),
	CHO_XU_LY_UQ("Ủy quyền - Chờ xử lý"),
	DA_XU_LY("Đã xử lý"),
	DA_THU_HOI("Đã bị thu hồi"),
	DA_TRA_LAI("Đã trả lại"),
	DA_BAN_HANH("Đã ban hành"),
	CHO_BAN_HANH("Chờ ban hành"),
	BI_TRA_LAI("Đã bị trả lại"),
	BI_TRA_LAI_UQ("Ủy quyền - Đã bị trả lại"),
	MOI_DEN("Mới đến"),
	HOAN_THANH("Hoàn thành"),
	NHAN_DE_BIET("Nhận để biết"),
	XU_LY_CHINH("Xử lý chính"),
	XU_LY_CHINH_UQ("Ủy quyền - Xử lý chính"),
	PHOI_HOP("Phối hợp"),
	PHOI_HOP_UQ("Ủy quyền - Phối hợp"),
	DA_THU_HOI_BH("Đã thu hồi"),
	KHOI_PHUC("Khôi phục"),
	NULL(null);

	private final String name;

	NotificationHandleStatusEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
