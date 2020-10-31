package com.web.quangcao.view.portlet;


import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Modified;

import aQute.bnd.annotation.metatype.Configurable;
import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.web.quangcao.view.portlet.QuangCaoConfig")
public class QuangCaoConfig {
	@Meta.AD(required = false)
	@Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
    	_configuration = Configurable.createConfigurable(QuangCaoConfig.class, properties);
    }

    private volatile QuangCaoConfig _configuration;
}
