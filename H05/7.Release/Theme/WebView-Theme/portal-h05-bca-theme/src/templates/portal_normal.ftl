<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>
	<meta content="initial-scale=1.0, width=device-width, shrink-to-fit=no" name="viewport" />
	<link rel="stylesheet" href="${css_folder}/font-awesome.min.css">
	<link rel="stylesheet" href="${css_folder}/bootstrap.min.css">
	<script type="text/javascript" src="${javascript_folder}/jquery.min.js"></script>
	<script type="text/javascript" src="${javascript_folder}/bootstrap.min.js"></script>
	<@liferay_util["include"] page=top_head_include />
	<!--<#if permissionChecker.isOmniadmin()>
	<#else>
		<link rel="stylesheet" href="${css_folder}/main.css">
		<link rel="stylesheet" href="${css_folder}/style.css">
		<link rel="stylesheet" href="${css_folder}/sm-blue.css">
		<link rel="stylesheet" href="${css_folder}/sm-core-css.css">
	</#if>-->
</head>

<body class="${css_class}">
<!--<@liferay_ui["quick-access"] contentId="#main-content" />-->
<!--<#if permissionChecker.isOmniadmin()>-->
	<@liferay_util["include"] page=body_top_include />
	<@liferay.control_menu />
<!--</#if>-->
<div class="wrapper">
	<header>
	<@liferay_portlet["runtime"]
	    portletName="Header_HeaderPortlet"
	/>
		<!--<div class="header-middle">
			<div class="container position-relative">
				<div class="row">
					<a href="${site_default_url}" class="logo col-sm-2"><img src="${site_logo}" alt=""></a>
						<div class="slogan col-sm-8">
								<h3>Cục công nghệ thông tin</h3>
								<h1>Bộ công an</h1>
								<h4 class="superme">Information technology department - ministry of public security vietnam</h4>
						</div>
					<div class="header-search position-absolute col-sm-2">
						<p><a href="/hoi-dap">Hỏi đáp</a> | <a href="">English</a></p>
						<form action="/search" class="form-search-header">
							<input class="search-ip" type="search" placeholder="Tìm kiếm" name="keyword" aria-label="Search">
							<button type="submit"><i class="icon-search"></i></button>
						</form>
					</div>
				</div>
			</div>
		</div>-->
		<#if has_navigation && is_setup_complete>
			<#include "${full_templates_path}/navigation.ftl" />
		</#if>
	</header>
	<!-- e: header -->
	<main class="main-content">
		<div class="bg-main-content">
			
				<#if selectable>
					<@liferay_util["include"] page=content_include />
				<#else>
					${portletDisplay.recycle()}

					${portletDisplay.setTitle(the_title)}

					<@liferay_theme["wrap-portlet"] page="portlet.ftl">
						<@liferay_util["include"] page=content_include />
					</@>
				</#if>
			
		</div>
	</main>
	<@liferay_portlet["runtime"]
	    portletName="Footer_FooterPortlet"
	/>
	<!--<footer>
		<div class="footer-top">
			<div>
				<div class="row align-items-md-center">
					<div class="col-md-12">
						<div class="copyright text-center">
							<h4 class="text-uppercase bold text-red">Cục công nghệ thông tin </h4>
							<h4 class="text-uppercase bold text-red">Bộ công an</h4>
						</div>
					</div>
				</div>
				<div class="text-center bg-tr-white">
					Địa chỉ: 47 Phạm Văn Đồng, Mai Dịch, Cầu giấy, Hà Nội<br/>
					Điện thoại: xxxx.xxxx.xxxx    *    Fax: xxxx.xxxx.xxxx <br/>
					Email: xxxx@bca.gov.vn
				</div>
			</div>
		</div>
		<div class="footer-bottom bg-red text-center">
			<p style="margin-bottom: 0;">Bản quyền thuộc về Bộ Công An. Khi sử dụng lại thông tin, đề nghị ghi rõ nguồn "Cổng TTĐT Bộ Công An"</p>
		</div>
	</footer>-->
</div>

<script type="text/javascript" src="${javascript_folder}/jquery.smartmenus.min.js"></script>
<script type="text/javascript" src="${javascript_folder}/custom.js"></script>


<@liferay_util["include"] page=body_bottom_include />
<@liferay_util["include"] page=bottom_include />

<!--<script type="text/javascript" src="${javascript_folder}/popper.min.js"></script>-->
</body>

</html>