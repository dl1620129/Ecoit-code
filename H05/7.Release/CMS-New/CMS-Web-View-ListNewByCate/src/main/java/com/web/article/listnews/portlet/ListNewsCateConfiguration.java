package com.web.article.listnews.portlet;


import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Modified;

import aQute.bnd.annotation.metatype.Configurable;
import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.web.article.listnews.portlet.ListNewsCateConfiguration")
public class ListNewsCateConfiguration {
	@Meta.AD(required = false)
	@Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
    	_configuration = Configurable.createConfigurable(ListNewsCateConfiguration.class, properties);
    }

    private volatile ListNewsCateConfiguration _configuration;
}
