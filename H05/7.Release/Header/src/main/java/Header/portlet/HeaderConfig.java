package Header.portlet;


import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Modified;

import aQute.bnd.annotation.metatype.Configurable;
import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "Footer.portlet.FooterConfig")
public class HeaderConfig {
	@Meta.AD(required = false)
	@Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
    	_configuration = Configurable.createConfigurable(HeaderConfig.class, properties);
    }

    private volatile HeaderConfig _configuration;
}
