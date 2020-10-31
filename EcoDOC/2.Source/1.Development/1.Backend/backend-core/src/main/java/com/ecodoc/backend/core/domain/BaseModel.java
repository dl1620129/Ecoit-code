/**
 * 
 */
package com.ecodoc.backend.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.ecodoc.backend.core.auth.SecurityContext;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author EcoDOC
 *
 */
@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "clientId" })
public abstract class BaseModel extends RootModel implements Serializable {

	private static final long serialVersionUID = 1L;

    @Column(name = "client_id")
	private Long clientId;

	@PrePersist
	@PreUpdate
	public void addClient() {
		User user = SecurityContext.getCurrentUser();
    	if (user != null) {
    		this.clientId = user.getClientId();
    	}
	}
}
