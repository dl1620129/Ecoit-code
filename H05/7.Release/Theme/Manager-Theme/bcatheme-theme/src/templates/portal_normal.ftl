<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />	
	<link data-senna-track="permanent" rel="stylesheet" type="text/css" href="${css_folder}/architect.css"/>
	<script data-senna-track="permanent" type="text/javascript" src="${javascript_folder}/architect.js"></script>
	<@liferay_util["include"] page=top_head_include />
</head>

<body class="${css_class}">

<!--<@liferay_ui["quick-access"] contentId="#main-content" />-->

<@liferay_util["include"] page=body_top_include />
<@liferay.control_menu />


<div class="app-container app-theme-white body-tabs-shadow fixed-sidebar fixed-header" id="wrapper">
    <div class="app-header header-shadow">
	    <div class="app-header__logo">
            <div aria-level="1" class="site-title logo-src" role="heading">
				<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
					<img alt="${logo_description}" height="50" src="${site_logo}" width="50" />
				</a>

				<#if show_site_name>
					<span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						${site_name}
					</span>
				</#if>
			</div>
			<div class="header__pane ml-auto">
                <div>
                    <button type="button" class="hamburger close-sidebar-btn hamburger--elastic" data-class="closed-sidebar">
                        <span class="hamburger-box">
                            <span class="hamburger-inner"></span>
                        </span>
                    </button>
                </div>
            </div>
	    </div>
		<div class="app-header__mobile-menu">
            <div>
                <button type="button" class="hamburger hamburger--elastic mobile-toggle-nav">
                    <span class="hamburger-box">
                        <span class="hamburger-inner"></span>
                    </span>
                </button>
            </div>
        </div>
        <div class="app-header__menu">
            <span>
            	<button type="button" class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
					<span class="btn-icon-wrapper">
						<i class="fa fa-ellipsis-v fa-w-6"></i>
					</span>
                </button>
            </span>
        </div> 
		<div class="app-header__content">
            <div class="app-header-right">
                <div class="header-btn-lg pr-0">
                    <div class="widget-content p-0">
                        <div class="widget-content-wrapper">
							<#if !is_signed_in>
                            <div class="widget-content-left  ml-3 header-user-info">
                                <div class="widget-heading">
                                    <a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">${sign_in_text}</a>
                                </div>
                            </div>			
							<#else>
							<div aria-labelledby="theDropdownToggleId" class="dropdown-menu">
								<ul class="list-unstyled">
									<li><a class="active dropdown-item" href="#1">Selected Option</a></li>
									<li><a class="dropdown-item" href="#3">Normal Option</a></li>
									<li>
										<a class="disabled dropdown-item" href="#4" tabindex="-1"
											>Disabled Option</a
										>
									</li>
								</ul>
							</div>
							
							<div class="widget-content-left">
                                <div class="btn-group">
                                    <a id="userDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="p-0 btn">
                                        <img width="42" class="rounded-circle"  src="${images_folder}/avatar.png" alt="">
                                        <i class="fa fa-angle-down ml-2 opacity-8"></i>
                                    </a>
                                    <div tabindex="-1" role="menu" aria-hidden="true" class="dropdown-menu dropdown-menu-right">
                                        <a href="/group${themeDisplay.getLayout().getGroup().getFriendlyURL()}/update_user" tabindex="0" class="dropdown-item">Hồ sơ</a>
                                        <!--<a tabindex="0" class="dropdown-item">Đổi mật khẩu</a>-->
                                        <a href="${sign_out_url}" tabindex="0" class="dropdown-item">Thoát</a>
                                	</div>
                                </div>
                            </div>
                            <div class="widget-content-left  ml-3 header-user-info">
                                <div class="widget-heading">
                                    ${user_last_name +" "+ user_middle_name +" "+ user_first_name}
                                </div>
                            </div>
							</#if>

                        </div>
                    </div>
                </div>        
			</div>
        </div>
    </div>
	<!--<header id="banner" role="banner">
		
	</header>-->

    <div class="page-container app-main">
	    <div class="app-sidebar sidebar-shadow">
			<div class="app-header__logo">
				<div aria-level="1" class="site-title" role="heading">
					<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						<img alt="${logo_description}" height="50" src="${site_logo}" width="50" />
					</a>

					<#if show_site_name>
						<span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
							${site_name}
						</span>
					</#if>
				</div>
			</div>
			<div class="app-header__mobile-menu">
				<div>
					<button type="button" class="hamburger hamburger--elastic mobile-toggle-nav">
						<span class="hamburger-box">
							<span class="hamburger-inner"></span>
						</span>
					</button>
				</div>
			</div>
			<div class="app-header__menu">
				<span>
					<button type="button" class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
						<span class="btn-icon-wrapper">
							<i class="fa fa-ellipsis-v fa-w-6"></i>
						</span>
					</button>
				</span>
			</div> 
			<div class="scrollbar-sidebar">
                <div class="app-sidebar__inner">
				<#if has_navigation && is_setup_complete>
					<#include "${full_templates_path}/navigation.ftl" />
				</#if>
				</div>
		    </div>
		</div>
		<div class="app-main__outer">
            <div class="app-main__inner">
				<section id="content">
					<h2 class="hide-accessible" role="heading" aria-level="1">${the_title}</h2>

					<#if selectable>
						<@liferay_util["include"] page=content_include />
					<#else>
						${portletDisplay.recycle()}

						${portletDisplay.setTitle(the_title)}

						<@liferay_theme["wrap-portlet"] page="portlet.ftl">
							<@liferay_util["include"] page=content_include />
						</@>
					</#if>
				</section>
			</div>
	    </div>
	</div>
	<!--<footer id="footer" role="contentinfo" style="padding-left: 300px;">
		<p class="powered-by">
			<@liferay.language key="powered-by" /> <a href="ecoit.asia" rel="external">EcoIT</a>
		</p>
	</footer>-->
</div>
	<@liferay_util["include"] page=body_bottom_include />
	<@liferay_util["include"] page=bottom_include />
<script data-senna-track="permanent" src="/o/frontend-editor-ckeditor-web/ckeditor/ckeditor.js"></script>
<script>
$('#userDropdown').on('click', function(e){
	let $dropdownMenu = $('#userDropdown').parent().find('div.dropdown-menu');
	if ($dropdownMenu.hasClass('show')) {
		$dropdownMenu.removeClass('show');
	} else {
        $('#userDropdown').parent().find('div.dropdown-menu').addClass('show');
	}
});
</script>
</body>

</html>