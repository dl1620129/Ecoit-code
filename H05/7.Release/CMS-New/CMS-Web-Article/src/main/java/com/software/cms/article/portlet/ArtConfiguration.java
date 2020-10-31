package com.software.cms.article.portlet;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Modified;

import aQute.bnd.annotation.metatype.Configurable;
import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.software.cms.article.portlet.ArtConfiguration")
public class ArtConfiguration {
	@Meta.AD(required = false)
	@Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
    	_configuration = Configurable.createConfigurable(ArtConfiguration.class, properties);
    }

    private volatile ArtConfiguration _configuration;
}
