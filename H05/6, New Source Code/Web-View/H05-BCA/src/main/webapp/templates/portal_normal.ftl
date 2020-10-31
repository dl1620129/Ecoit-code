<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />
	
	<@liferay_util["include"] page=top_head_include />

	<link data-afr-stylesheet="true" rel="stylesheet" type="text/css" afrres="true" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<!-- 
	<link rel="stylesheet" type="text/css" href="${css_folder}/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${css_folder}/all.css"/>
	<link rel="stylesheet" type="text/css" href="${css_folder}/fontawesome.min.css"/>	-->
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<div class="container-fluid" id="wrapper">
	<header class="hidden-xs" id="header">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
		<div  style="background: url(${images_folder}/user_page/ShowProperty-38ab4df33f2bc.png) no-repeat right; width: 100%; height: 130px; position: relative;">
			<div class="container " style="background: url(${images_folder}/user_page/ShowProperty-73212d22ec1c2.png) no-repeat; margin: auto;">
				<div class="row">
						<a class="logo col-sm-2" href="#">
							<img alt="img" src="${images_folder}/user_page/logo.png">
						</a>
						<div class="slogan col-sm-10">
							<h3>Cục công nghệ thông tin</h3>
							<h1>Bộ công an</h1>
							<h4 class="superme">Information technology department - ministry of public security vietnam</h4>
						</div>
				</div>
			</div>
		</div>
	</header>
	<#include "${full_templates_path}/navbar.ftl" />
	<section id="content">
		<h1 class="hide-accessible">${the_title}</h1>

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

	<footer id="footer" class="container-fluid" role="contentinfo">
			<#include "${full_templates_path}/footer.ftl" />
	</footer>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>