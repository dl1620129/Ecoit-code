package com.web.article.newsbycategory.portlet;


import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Modified;

import aQute.bnd.annotation.metatype.Configurable;
import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.web.article.newsbycategory.portlet.NewCateConfiguration")
public class NewCateConfiguration {
	@Meta.AD(required = false)
	@Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
    	_configuration = Configurable.createConfigurable(NewCateConfiguration.class, properties);
    }

    private volatile NewCateConfiguration _configuration;
}
