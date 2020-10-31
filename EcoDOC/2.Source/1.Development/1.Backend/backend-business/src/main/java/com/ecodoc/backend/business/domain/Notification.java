package com.ecodoc.backend.business.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.ecodoc.backend.core.config.ModuleCodeEnum;
import com.ecodoc.backend.core.config.NotificationHandleStatusEnum;
import com.ecodoc.backend.core.domain.BaseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "NOTIFICATION", schema = "ecodoc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification extends BaseModel{
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "doc_id")
	private Long docId;

	@Column(name = "description")
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "doc_status")
	private NotificationHandleStatusEnum docStatus;

	public NotificationHandleStatusEnum getDocStatus() {
		if (this.docStatus == null) {
			return NotificationHandleStatusEnum.NULL;
		}
		return this.docStatus;
	}

	@Column(name = "read") //Trạng thái xem
	private Boolean read;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "module_code")
	private ModuleCodeEnum moduleCode;

	@PrePersist
	public void prePersist() {
		this.read = false;
	}
}