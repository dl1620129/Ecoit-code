<nav id="main-nav">
	<div class="container">
		<button class="ic-toggler" type="button">
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
						<li class="home">
							<a style="padding: 8px;" class="active" href="/web${themeDisplay.getLayout().getGroup().getFriendlyURL()}"><i class="ico-2"></i></a>
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
			</ul>
		</div>
	</div>
</nav>