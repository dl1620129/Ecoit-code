<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link type="text/css" href="${css_folder}/bootstrap.min.css" rel="stylesheet"/>
	<link rel="stylesheet" href="${css_folder}/font-awesome.css">
	<link rel="stylesheet" href="${css_folder}/slick.css">
	<link rel="stylesheet" href="${css_folder}/bootstrap-datepicker.min.css">
	<link rel="stylesheet" href="${css_folder}/tokenize2.min.css">
	<link type="text/css" href="${css_folder}/style.css" rel="stylesheet"/>
	<link type="text/css" href="${css_folder}/sm-core-css.css" rel="stylesheet"/>
	<link type="text/css" href="${css_folder}/sm-blue.css" rel="stylesheet"/>
	<link rel="icon" type="image/png" href="${images_folder}/favicon.png"/>
	<script src="${javascript_folder}/jquery.min.js"></script>
	<@liferay_util["include"] page=top_head_include />

</head>

<body class="${css_class}">
<@liferay_ui["quick-access"] contentId="#main-content" />
<@liferay_util["include"] page=body_top_include />
<@liferay.control_menu />
<header class="header-page">

		<@liferay_portlet["runtime"]
			portletName="Header_HeaderPortlet"
		/>

	<#if has_navigation && is_setup_complete>
		<#include "${full_templates_path}/navigation.ftl" />
	</#if>
</header>
<main class="main-content">
	<div class="container">
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
<script type="text/javascript" src="${javascript_folder}/popper.min.js"></script>
<script type="text/javascript" src="${javascript_folder}/bootstrap.min.js"></script>
<script type="text/javascript" src="${javascript_folder}/slick.js"></script>
<script type="text/javascript" src="${javascript_folder}/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="${javascript_folder}/tokenize2.min.js"></script>
<script type="text/javascript" src="${javascript_folder}/jquery.smartmenus.min.js"></script>
<script type="text/javascript" src="${javascript_folder}/customs.js"></script>
<script>
	function updateDateTime() {
		var currentTime = new Date();

		var currentDay = currentTime.getDay();
		var currentDate = currentTime.getDate();
		var currentMon = currentTime.getMonth() + 1;
		var currentYr = currentTime.getFullYear();
		var currentHours = currentTime.getHours();
		var currentMinutes = currentTime.getMinutes();
		var currentSeconds = currentTime.getSeconds();

		//// Pad the minutes and seconds with leading zeros, if required
		currentMinutes = (currentMinutes < 10 ? "0" : "") + currentMinutes;
		currentSeconds = (currentSeconds < 10 ? "0" : "") + currentSeconds;
		currentHours = (currentHours < 10 ? "0" : "") + currentHours;
		currentDate = (currentDate < 10 ? "0" : "") + currentDate;
		currentMon = (currentMon < 10 ? "0" : "") + currentMon;

		//// Choose either "AM" or "PM" as appropriate
		var timeOfDay = (currentHours < 24) ? "" : "";

		// Convert the hours component to 12-hour format if needed
		//currentHours = (currentHours > 12) ? currentHours - 12 : currentHours;
		if (currentDay == 0) {
			currentDay = "Chủ nhật, ";
		};
		if (currentDay == 1) {
			currentDay = "Thứ hai, ";
		};
		if (currentDay == 2) {
			currentDay = "Thứ ba, ";
		};
		if (currentDay == 3) {
			currentDay = "Thứ tư, ";
		};
		if (currentDay == 4) {
			currentDay = "Thứ năm, ";
		};
		if (currentDay == 5) {
			currentDay = "Thứ sáu, ";
		};
		if (currentDay == 6) {
			currentDay = "Thứ bảy, ";
		};
		var textday;
		textday = "ngày";
		// Convert an hours component of "0" to "12"
		currentHours = (currentHours == 0) ? 12 : currentHours;

		//// Compose the string for display
		var currentTimeString = currentHours + ":" + currentMinutes + ":" + currentSeconds + " " + timeOfDay;
		var currentDateString = currentDay + currentDate + "/" + currentMon + "/" + currentYr

		//// Update the time display
		var textTimer = currentTimeString +currentDateString;
		document.getElementById("timer").innerHTML = currentDateString;
	}
	updateDateTime();
	setInterval("updateDateTime()", 1000);
</script>
<@liferay_util["include"] page=body_bottom_include />
<@liferay_util["include"] page=bottom_include />

</body>

</html>
