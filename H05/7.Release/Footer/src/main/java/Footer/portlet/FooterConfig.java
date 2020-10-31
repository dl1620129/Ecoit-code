package Footer.portlet;


import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Modified;

import aQute.bnd.annotation.metatype.Configurable;
import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "Footer.portlet.FooterConfig")
public class FooterConfig {
	@Meta.AD(required = false)
	@Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
    	_configuration = Configurable.createConfigurable(FooterConfig.class, properties);
    }

    private volatile FooterConfig _configuration;
}
