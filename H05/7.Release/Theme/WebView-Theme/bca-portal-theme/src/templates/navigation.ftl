<nav class="navigation" id="navigation">
	<div class="container">
		<button class="icon-toggle" type="button">
			<span></span>
		</button>
		<div class="menu">
			<ul id="main-menu" class="sm sm-blue">
				<#list nav_items as nav_item>
					<#assign
					nav_item_attr_has_popup = ""
					nav_item_css_class = ""
					nav_item_layout = nav_item.getLayout()
					/>
					<#if nav_item.isSelected()>
						<#assign
						nav_item_attr_has_popup = "aria-haspopup='true'"
						nav_item_css_class = "active"
						/>
					</#if>
					<#if nav_item.getName() == 'Trang chủ' || nav_item.getName() == 'Home'>
						<li class="menu-item-home">
							<a href="/web${themeDisplay.getLayout().getGroup().getFriendlyURL()}" class="${nav_item_css_class}">
								<i class="icon-home d-none d-lg-inline-block"></i>
								<span class="text-menu d-lg-none">Trang chủ</span>
							</a>
						</li>
					<#else>
						<li>
							<a class="${nav_item_css_class}" aria-labelledby="layout_${nav_item.getLayoutId()}" href="${nav_item.getURL()}" ${nav_item.getTarget()}>
								<span><@liferay_theme["layout-icon"] layout=nav_item_layout /> ${nav_item.getName()}</span>
							</a>
							<#if nav_item.hasChildren()>
								<ul>
									<#list nav_item.getChildren() as nav_child>
										<#assign
										nav_child_css_class = ""
										/>

										<#if nav_item.isSelected()>
											<#assign
											nav_child_css_class = "active"
											/>
										</#if>
										<li class="${nav_child_css_class} ">
											<a href="${nav_child.getURL()}" ${nav_child.getTarget()}>${nav_child.getName()}</a>
											<#if nav_child.hasChildren()>
												<ul>
													<#list nav_child.getChildren() as nav_childs>
														<li >
															<a href="${nav_childs.getURL()}" ${nav_childs.getTarget()}>${nav_childs.getName()}</a>
															<#if nav_childs.hasChildren()>
																<ul >
																	<#list nav_childs.getChildren() as nav_child_child>
																		<li >
																			<a href="${nav_child_child.getURL()}" ${nav_child_child.getTarget()}>${nav_child_child.getName()}</a>
																		</li>
																	</#list>
																</ul>
															</#if>
														</li>
													</#list>
												</ul>
											</#if>
										</li>
									</#list>
								</ul>
							</#if>
						</li>
					</#if>
				</#list>
				<#if theme_display.isSignedIn()>
					<li>
						<a href="/c/portal/logout">Đăng xuất</a>
					</li>

				<#else>
					<li>
						<a href="/c/portal/login">Đăng nhập</a>
					</li>
				</#if>
			</ul>
		</div>
		<div class="search-form-container d-lg-none">
			<form class="search-form" action="/search" method="">
				<input class="form-control" name="keyword" placeholder="Tìm kiếm">
				<button class="search-form-submit"><i class="fa fa-search"></i></button>
			</form>
		</div>
	</div>
</nav>

<#--<nav class="${nav_css_class}" id="navigation" role="navigation">-->
<#--	<ul aria-label="<@liferay.language key="site-pages" />" role="menubar">-->
<#--		<#list nav_items as nav_item>-->
<#--			<#assign-->
<#--				nav_item_attr_has_popup = ""-->
<#--				nav_item_css_class = ""-->
<#--				nav_item_layout = nav_item.getLayout()-->
<#--			/>-->

<#--			<#if nav_item.isSelected()>-->
<#--				<#assign-->
<#--					nav_item_attr_has_popup = "aria-haspopup='true'"-->
<#--					nav_item_css_class = "selected"-->
<#--				/>-->
<#--			</#if>-->

<#--			<li class="${nav_item_css_class}" id="layout_${nav_item.getLayoutId()}" role="presentation">-->
<#--				<a aria-labelledby="layout_${nav_item.getLayoutId()}" ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem"><span><@liferay_theme["layout-icon"] layout=nav_item_layout /> ${nav_item.getName()}</span></a>-->

<#--				<#if nav_item.hasChildren()>-->
<#--					<ul class="child-menu" role="menu">-->
<#--						<#list nav_item.getChildren() as nav_child>-->
<#--							<#assign-->
<#--								nav_child_css_class = ""-->
<#--							/>-->

<#--							<#if nav_item.isSelected()>-->
<#--								<#assign-->
<#--									nav_child_css_class = "selected"-->
<#--								/>-->
<#--							</#if>-->

<#--							<li class="${nav_child_css_class}" id="layout_${nav_child.getLayoutId()}" role="presentation">-->
<#--								<a aria-labelledby="layout_${nav_child.getLayoutId()}" href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem">${nav_child.getName()}</a>-->
<#--							</li>-->
<#--						</#list>-->
<#--					</ul>-->
<#--				</#if>-->
<#--			</li>-->
<#--		</#list>-->
<#--	</ul>-->
<#--</nav>-->