package cms.webview.news.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.software.cms.model.Article;
import com.software.cms.model.Category;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.cms.service.CategoryLocalServiceUtil;
import com.software.util.DataResponse;
import com.software.util.DataResponse.DataType;
import com.software.util.CMSPortalUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.software.util.NewsWorkflowConstants;
import com.software.util.ResponseCode;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;

import cms.webview.utils.ArticleObject;
import cms.webview.utils.AttachmentUtil;

public class NewResource {
	private JsonNodeFactory factory = JsonNodeFactory.instance;
	private ObjectMapper mapper = new ObjectMapper();

	@GET
	@Path("/list-new-by-category/getall/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse ListNewByCategoryConfig(@PathParam("groupId") int groupId,
			@DefaultValue("") @QueryParam("listCategoryId") String listCategoryId,
			@DefaultValue("10") @QueryParam("limit") int limit) {

		try {
			listCategoryId = HtmlUtil.escape(listCategoryId);

			if (groupId < 0 || limit < 0 || listCategoryId.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			String[] categoryIdLst = listCategoryId.split(",");
			ArrayNode dataArrRes = factory.arrayNode();

			for (String categoryItem : categoryIdLst) {
				long categoryId = Long.parseLong(categoryItem);
				ObjectNode objectNode = factory.objectNode();
				List<Article> result = new ArrayList<Article>();
				try {
					result = ArticleLocalServiceUtil.getListArticleByCaterory(groupId, categoryId, null, 0, limit);
				} catch (Exception e) {
					return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(),
							DataType.JSON_STR);
				}
				ArrayNode nodeArtArr = factory.arrayNode();
				for (Article article : result) {
					nodeArtArr.addPOJO(ArticleObject.ArticleNode(article));
				}
				objectNode.put("categoryId", categoryId);
				objectNode.putPOJO("data", nodeArtArr);
				dataArrRes.addPOJO(objectNode);
			}

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, dataArrRes, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/new-by-category/getall/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse ListNewByCategory(@PathParam("groupId") int groupId,
			@DefaultValue("-1") @QueryParam("categoryId") long categoryId,
			@DefaultValue("false") @QueryParam("slide_tin_chuyen_muc") Boolean slide_tin_chuyen_muc,
			@DefaultValue("false") @QueryParam("danh_sach_slide_tin_chuyen_muc") Boolean danh_sach_slide_tin_chuyen_muc,
			@DefaultValue("false") @QueryParam("check_remove_category") Boolean check_remove_category,
			@QueryParam("srcImgDefault") String srcImgDefault, @DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("10") @QueryParam("limit") int limit, @Context HttpServletRequest request) {
		try {

			if (groupId < 0 || start < 0 || limit < 0 || srcImgDefault == null || srcImgDefault.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}
			ObjectNode objectNode = factory.objectNode();
			if (categoryId >= 0) {
				Category cat = CategoryLocalServiceUtil.getCategory(categoryId);
				List<Article> resultHotNew = new ArrayList<Article>();
				List<Article> result = new ArrayList<Article>();
				int total = 0;
				if (slide_tin_chuyen_muc != null && slide_tin_chuyen_muc.equals("true")) {

					String artIds = "";
					try {

						resultHotNew = ArticleLocalServiceUtil.getArticleByCate(groupId, categoryId, 12);

						List<Long> articleIdLst = new ArrayList<>();
						for (Article article : resultHotNew) {
							articleIdLst.add(article.getArticleId());
						}
						artIds = StringUtils.join(articleIdLst, ",");

						if (danh_sach_slide_tin_chuyen_muc.equals("true")) {
							total = ArticleLocalServiceUtil.countArticleNew(groupId, categoryId, artIds);
							result = ArticleLocalServiceUtil.getArticleNew(groupId, categoryId, start, limit, artIds);

						}
					} catch (Exception e) {
						return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(),
								DataType.JSON_STR);
					}

					ArrayNode nodeArtArr = factory.arrayNode();
					for (Article article : result) {
						nodeArtArr.addPOJO(article.getModelAttributes());
					}

					ObjectNode nodeArticleCate = factory.objectNode();
					nodeArticleCate.putPOJO("data", nodeArtArr);
					nodeArticleCate.put("total", total);

					objectNode.putPOJO("searchContainerTinTucTrangChuyenMuc", nodeArticleCate);
					objectNode.putPOJO("resultHotNew", resultHotNew);
					objectNode.putPOJO("category", cat.getModelAttributes());
					objectNode.putPOJO("slide_tin_chuyen_muc", slide_tin_chuyen_muc);
					objectNode.putPOJO("danh_sach_slide_tin_chuyen_muc", danh_sach_slide_tin_chuyen_muc);

				} else {
					try {
						total = ArticleLocalServiceUtil.getCountArticleByCaterory(groupId, categoryId, null);
						result = ArticleLocalServiceUtil.getListArticleByCaterory(groupId, categoryId, null, start,
								total > start + limit ? start + limit : total);
					} catch (Exception e) {
						return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(),
								DataType.JSON_STR);
					}
					ArrayNode nodeArtArr = factory.arrayNode();
					for (Article article : result) {
						nodeArtArr.addPOJO(article.getModelAttributes());
					}

					ObjectNode nodeArticleCate = factory.objectNode();
					nodeArticleCate.putPOJO("data", nodeArtArr);
					nodeArticleCate.put("total", total);

					objectNode.putPOJO("searchContainerTinTucTrangChuyenMuc", nodeArticleCate);
					objectNode.putPOJO("category", cat.getModelAttributes());
					objectNode.putPOJO("slide_tin_chuyen_muc", slide_tin_chuyen_muc);

				}
				objectNode.putPOJO("check_remove_category", check_remove_category);

				// render view
				ObjectNode dataPage = factory.objectNode();

				String titleCateParent = "";
				String urlCatParent = "";
				if (cat.getParentId() > 0) {
					titleCateParent = CategoryLocalServiceUtil.getCategory(cat.getParentId()).getTitle();
					urlCatParent = CMSPortalUtil.getURLCategory(cat.getParentId());
				}

				if (cat != null || resultHotNew != null) {
					if (slide_tin_chuyen_muc != null && slide_tin_chuyen_muc == false) {
						ObjectNode nodeObj = factory.objectNode();
						List<Article> listArt = result;
						if (listArt == null)
							listArt = new ArrayList<Article>();
						String urlParent = CMSPortalUtil.getUrlArticle(listArt.get(0), cat.getCategoryId(), request,
								groupId, "/chi-tiet-tin");
						String urlImgParent = AttachmentUtil.viewDocument(listArt.get(0).getImage());
						String urlCat = CMSPortalUtil.getURLCategory(cat.getCategoryId());
						nodeObj.put("urlImgParent", urlImgParent);
						nodeObj.put("urlParent", urlParent);
						if (check_remove_category == false) {
							nodeObj.put("urlCat", urlCat);
							if (!titleCateParent.equals("")) {
								nodeObj.put("urlCatParent", urlCatParent);
							}
						}
						// view art

						ArrayNode arrViewArt = factory.arrayNode();

						for (Article art : listArt) {
							ObjectNode nodeObjArt = factory.objectNode();
							String urlImg = AttachmentUtil.viewDocument(listArt.get(0).getImage());
							String url = CMSPortalUtil.getUrlArticle(art, cat.getCategoryId(), request, groupId,
									"/chi-tiet-tin");
							nodeObjArt.put("url", url);
							if (!urlImg.equals(srcImgDefault)) {
								nodeObjArt.put("urlImg", urlImg);
							}

							nodeObjArt.put("title", art.getTitle());
							nodeObjArt.put("summary", art.getSummary());
							arrViewArt.addPOJO(nodeObjArt);
						}

						dataPage.putPOJO("nodeParent", nodeObj);
						dataPage.putPOJO("arrViewArt", arrViewArt);

					} else {
						ObjectNode nodeObj = factory.objectNode();
						String urlCat = CMSPortalUtil.getURLCategory(cat.getCategoryId());
						int sizeArtSlide = 0;
						nodeObj.put("urlCat", urlCat);
						nodeObj.put("sizeArtSlide", sizeArtSlide);
						try {
							sizeArtSlide = resultHotNew.size();
						} catch (Exception e) {
							sizeArtSlide = 0;
						}
						if (danh_sach_slide_tin_chuyen_muc == false) {
							if (check_remove_category == false) {
								nodeObj.put("title", cat.getTitle());
							}
						}
						// view art
						ArrayNode arrViewArt = factory.arrayNode();
						if (danh_sach_slide_tin_chuyen_muc == false) {
							int i = 0;
							for (i = 0; i < sizeArtSlide && i < 5; i++) {
								ObjectNode nodeObjArt = factory.objectNode();
								Article art = resultHotNew.get(i);
								String urlImg = AttachmentUtil.viewDocument(art.getImage());
								String url = CMSPortalUtil.getUrlArticle(art, cat.getCategoryId(), request, groupId,
										"/chi-tiet-tin");

								nodeObjArt.put("url", url);
								nodeObjArt.put("urlImg", urlImg);
								nodeObjArt.put("title", art.getTitle());
								nodeObjArt.put("summary", StringUtil.shorten(art.getSummary(), 160));
								arrViewArt.addPOJO(nodeObjArt);
							}

							for (int j = i; j < sizeArtSlide; j++) {
								ObjectNode nodeObjArt = factory.objectNode();
								Article art = resultHotNew.get(j);
								String url = CMSPortalUtil.getUrlArticle(art, cat.getCategoryId(), request, groupId,
										"/chi-tiet-tin");
								nodeObjArt.put("url", url);
								nodeObjArt.put("title", StringUtil.shorten(art.getTitle(), 120));
								arrViewArt.addPOJO(nodeObjArt);
							}

						} else {
							List<Article> listArt = result;
							if (listArt == null)
								listArt = new ArrayList<Article>();

							for (Article art : listArt) {
								ObjectNode nodeObjArt = factory.objectNode();
								String urlImg = AttachmentUtil.viewDocument(art.getImage());
								String url = CMSPortalUtil.getUrlArticle(art, cat.getCategoryId(), request, groupId,
										"/chi-tiet-tin");
								nodeObjArt.put("url", url);
								if (!urlImg.equals(srcImgDefault)) {
									nodeObjArt.put("urlImg", urlImg);
								}
								nodeObjArt.put("title", art.getTitle());
								nodeObjArt.put("summary", art.getSummary());
								arrViewArt.addPOJO(nodeObjArt);
							}

						}
						dataPage.putPOJO("nodeParent", nodeObj);
						dataPage.putPOJO("arrViewArt", arrViewArt);
					}
					return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, dataPage,
							DataType.JSON_STR);
				}
			} else {
				return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, "CATEGORY_ID ERROR",
						DataType.JSON_STR);
			}
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, "SYSTEM ERROR", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/new-by-category/getall/{groupId}/{locale}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse NewByCategory(@PathParam("groupId") long groupId,
			@DefaultValue("") @QueryParam("listCategoryId") String listCategoryId, @PathParam("locale") String locale,
			@DefaultValue("false") @QueryParam("cau_hinh_trang_chi_tiet") Boolean cau_hinh_trang_chi_tiet,
			@DefaultValue("false") @QueryParam("hien_thi_theo_thong_bao") Boolean hien_thi_theo_thong_bao,
			@DefaultValue("false") @QueryParam("hien_thi_theo_thong_bao_theo_slide") Boolean hien_thi_theo_thong_bao_theo_slide,
			@DefaultValue("false") @QueryParam("hien_thi_theo_dang_tabs") Boolean hien_thi_theo_dang_tabs,
			@DefaultValue("false") @QueryParam("day_bai_viet_thong_bao_len_menu") Boolean day_bai_viet_thong_bao_len_menu,
			@DefaultValue("0") @QueryParam("start") int start, @DefaultValue("10") @QueryParam("limit") int limit,
			@Context HttpServletRequest request) {
		try {
			locale = HtmlUtil.escape(locale);
			listCategoryId = HtmlUtil.escape(listCategoryId);

			if (groupId < 0 || start < 0 || limit < 0) {
				return DataResponse.PARAM_ERROR;
			}

			ObjectNode objectNodeResult = factory.objectNode();

			String[] categoryIdLst = listCategoryId.split(",");

			List<Article> listTinTheoChuyenMuc = new ArrayList<Article>();
			for (String categoryItem : categoryIdLst) {
				long categoryId = Long.parseLong(categoryItem);
				List<Article> result = ArticleLocalServiceUtil.getListArticleByCaterory(groupId, categoryId, null, 0,
						limit);
				listTinTheoChuyenMuc.addAll(result);
			}

			List<Article> listNotification = new ArrayList<Article>();
			List<Category> listCate = new ArrayList<Category>();
			if (listTinTheoChuyenMuc == null)
				listTinTheoChuyenMuc = new ArrayList<Article>();

			String categoryTitle = (String) request.getAttribute("categoryNameTypeTwo");
			if (categoryTitle == null)
				categoryTitle = "";
			long catId = 0;
			List<Category> listCategoryCon = new ArrayList<Category>();
			int lengthCatCon = 0;
			try {
				catId = Long.valueOf((String) request.getAttribute("categoryIdTypeTwo"));
				listCategoryCon = CategoryLocalServiceUtil.getCategoryHaveParentId(groupId, locale, catId);
			} catch (Exception e) {
			}
			if (listCategoryCon != null)
				lengthCatCon = listCategoryCon.size();

			int lengthNotification = listNotification != null ? listNotification.size() : 0;
			int lengthTinChuyenMuc = listTinTheoChuyenMuc.size();
			String title1 = "";
			Article art1 = null;
			Article art2 = null;
			if (lengthTinChuyenMuc > 0)
				art1 = listTinTheoChuyenMuc.get(0);
			if (lengthTinChuyenMuc > 1)
				art2 = listTinTheoChuyenMuc.get(1);
			String title2 = "";
			String img2 = "";
			String url2 = "";
			if (art2 != null) {
				title2 = art2.getTitle();
				if (art2.getImage() != null && !art2.getImage().equals("")) {
					img2 = AttachmentUtil.viewDocument(art2.getImage());
				}
				url2 = CMSPortalUtil.getUrlArticle(art2, catId, request, groupId, "");
			}

			if (art1 != null)
				title1 = art1.getTitle();

			String img1 = "";
			if (art1 != null) {
				String imgId = art1.getImage();
				img1 = AttachmentUtil.viewDocument(imgId);
			}

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String summary1 = "";
			if (art1 != null)
				summary1 = StringUtil.shorten(art1.getSummary(), 180);

			String url1 = "/";
			if (art1 != null) {
				url1 = CMSPortalUtil.getUrlArticle(art1, catId, request, groupId, "");
			}
			String siteURL = "/web" + GroupLocalServiceUtil.getGroup(groupId).getFriendlyURL();

			String urlCat1 = CMSPortalUtil.getURLCategory(catId);

			objectNodeResult.put("url", siteURL + urlCat1);
			objectNodeResult.put("categoryTitle", categoryTitle.toUpperCase());
			if (cau_hinh_trang_chi_tiet) {
				objectNodeResult.put("url1", url1);
				objectNodeResult.put("img1", img1);
				objectNodeResult.put("title1", title1);

				ArrayNode arrayTinChuyenMucChiTiet = factory.arrayNode();
				for (int i = 1; i < lengthTinChuyenMuc; i++) {
					Article art = listTinTheoChuyenMuc.get(i);
					String url = art.getFriendlyURL();
					ObjectNode nodeTinChuyenMucChiTiet = factory.objectNode();
					try {
						PortletURL portletURL = CMSPortalUtil.getPortletURLFromFriendURLAndPortletId(request, groupId,
								catId);
						portletURL.setParameter("categoryId", String.valueOf(catId));
						portletURL.setParameter("urlTitle", art.getFriendlyURL());
						url = portletURL.toString();
					} catch (Exception e) {
						e.printStackTrace();
					}
					nodeTinChuyenMucChiTiet.put("url", url);
					nodeTinChuyenMucChiTiet.put("title", art.getTitle());
					arrayTinChuyenMucChiTiet.addPOJO(nodeTinChuyenMucChiTiet);
				}
				objectNodeResult.putPOJO("tinChuyenMucChiTiet", arrayTinChuyenMucChiTiet);

			} else if (hien_thi_theo_thong_bao) {
				ArrayNode arrayTinChuyenMucThongBao = factory.arrayNode();
				for (int i = 0; i < lengthNotification; i++) {
					Article art = listNotification.get(i);
					String url = art.getFriendlyURL();
					ObjectNode nodeTinChuyenMucThongBao = factory.objectNode();
					try {
						PortletURL portletURL = CMSPortalUtil.getPortletURLFromFriendURLAndPortletId(request, groupId,
								catId);
						portletURL.setParameter("categoryId", String.valueOf(catId));
						portletURL.setParameter("urlTitle", art.getFriendlyURL());
						url = portletURL.toString();
					} catch (Exception e) {
						e.printStackTrace();
					}
					nodeTinChuyenMucThongBao.put("url", url);
					nodeTinChuyenMucThongBao.put("title", art.getTitle());
					arrayTinChuyenMucThongBao.addPOJO(nodeTinChuyenMucThongBao);
				}
				objectNodeResult.putPOJO("tinChuyenMucThongBao", arrayTinChuyenMucThongBao);
			} else if (hien_thi_theo_thong_bao_theo_slide) {
				ObjectNode tinChuyenMucThongBaoSlide = factory.objectNode();
				ArrayNode arrayTinChuyenMucThongBaoSlide = factory.arrayNode();
				tinChuyenMucThongBaoSlide.put("language", locale);
				for (int i = 0; i < lengthNotification; i++) {
					Article art = listNotification.get(i);
					String url = "";

					ObjectNode nodeTinChuyenMucThongBaoSlide = factory.objectNode();
					try {
						PortletURL portletURL = CMSPortalUtil.getPortletURLFromFriendURLAndPortletId(request, groupId,
								catId);
						portletURL.setParameter("categoryId", String.valueOf(catId));
						portletURL.setParameter("urlTitle", art.getFriendlyURL());
						url = portletURL.toString();
					} catch (Exception e) {
						e.printStackTrace();
					}

					nodeTinChuyenMucThongBaoSlide.put("url", url);
					nodeTinChuyenMucThongBaoSlide.put("title", art.getTitle());
					arrayTinChuyenMucThongBaoSlide.addPOJO(nodeTinChuyenMucThongBaoSlide);
				}
				tinChuyenMucThongBaoSlide.putPOJO("data", arrayTinChuyenMucThongBaoSlide);

				objectNodeResult.putPOJO("tinChuyenMucThongBaoSlide", tinChuyenMucThongBaoSlide);

			} else if (hien_thi_theo_dang_tabs) {
				ObjectNode nodeTinChuyenMucTabParent = factory.objectNode();
				ArrayNode arrayTinChuyenMucTabs = factory.arrayNode();
				for (int i = 0; i < listCate.size(); i++) {
					ObjectNode nodeTinChuyenMucTab = factory.objectNode();
					Category category = listCate.get(i);
					String UrlCat = CMSPortalUtil.getURLCategory(category.getCategoryId());
					nodeTinChuyenMucTab.put("url", siteURL + UrlCat);
					nodeTinChuyenMucTab.put("title", category.getTitle());
					arrayTinChuyenMucTabs.addPOJO(nodeTinChuyenMucTab);
				}

				nodeTinChuyenMucTabParent.put("url1", url1);
				nodeTinChuyenMucTabParent.put("title1", title1);
				nodeTinChuyenMucTabParent.put("img1", img1);
				nodeTinChuyenMucTabParent.put("summary1", HtmlUtil.extractText(summary1));
				nodeTinChuyenMucTabParent.putPOJO("tabs", arrayTinChuyenMucTabs);

				nodeTinChuyenMucTabParent.put("url2", url2);
				nodeTinChuyenMucTabParent.put("title2", title2);

				if (!locale.equals("en_US")) {
					nodeTinChuyenMucTabParent.put("img2", img2);
				}

				ArrayNode tinChuyenMucTabs = factory.arrayNode();
				for (int i = 2; i < lengthTinChuyenMuc; i++) {
					Article art = listTinTheoChuyenMuc.get(i);
					String url = art.getFriendlyURL();
					ObjectNode tinChuyenMucTab = factory.objectNode();
					try {
						PortletURL portletURL = CMSPortalUtil.getPortletURLFromFriendURLAndPortletId(request, groupId,
								catId);
						portletURL.setParameter("categoryId", String.valueOf(catId));
						portletURL.setParameter("urlTitle", art.getFriendlyURL());
						url = portletURL.toString();
					} catch (Exception e) {
						e.printStackTrace();
					}

					tinChuyenMucTab.put("url", url);
					tinChuyenMucTab.put("title", art.getTitle());
					tinChuyenMucTab.put("titleShort", StringUtil.shorten(art.getTitle(), 90));
					tinChuyenMucTabs.addPOJO(tinChuyenMucTab);
				}
				nodeTinChuyenMucTabParent.putPOJO("tinChuyenMucTabs", tinChuyenMucTabs);

				objectNodeResult.putPOJO("tinChuyenMucThongBaoTab", nodeTinChuyenMucTabParent);

			} else if (day_bai_viet_thong_bao_len_menu) {
				ArrayNode arrayTinChuyenMucMenu = factory.arrayNode();
				for (int i = 0; i < lengthTinChuyenMuc; i++) {
					Article article = listTinTheoChuyenMuc.get(i);
					String url = "";
					try {
						PortletURL portletURL = CMSPortalUtil.getPortletURLFromFriendURLAndPortletId(request, groupId,
								catId, "");
						portletURL.setParameter("categoryId", String.valueOf(catId));
						portletURL.setParameter("urlTitle", article.getFriendlyURL());
						url = portletURL.toString();
					} catch (Exception e) {
						e.printStackTrace();
					}
					ObjectNode tinChuyenMucMenu = factory.objectNode();
					tinChuyenMucMenu.put("url", url);
					tinChuyenMucMenu.put("title", article.getTitle());
					arrayTinChuyenMucMenu.addPOJO(arrayTinChuyenMucMenu);
				}
				objectNodeResult.putPOJO("tinChuyenMucMenu", arrayTinChuyenMucMenu);
			} else {

				objectNodeResult.put("url1", url1);
				objectNodeResult.put("img1", img1);
				objectNodeResult.put("title1", title1);

				ArrayNode arrayTinChuyenMuc = factory.arrayNode();
				for (int i = 1; i < lengthTinChuyenMuc; i++) {
					Article art = listTinTheoChuyenMuc.get(i);
					String url = art.getFriendlyURL();
					ObjectNode nodeTinChuyenMuc = factory.objectNode();
					try {
						PortletURL portletURL = CMSPortalUtil.getPortletURLFromFriendURLAndPortletId(request, groupId,
								catId);
						portletURL.setParameter("categoryId", String.valueOf(catId));
						portletURL.setParameter("urlTitle", art.getFriendlyURL());
						url = portletURL.toString();
					} catch (Exception e) {
						e.printStackTrace();
					}
					nodeTinChuyenMuc.put("url", url);
					nodeTinChuyenMuc.put("title", art.getTitle());
					nodeTinChuyenMuc.put("titleShort", StringUtil.shorten(art.getTitle(), 90));
					arrayTinChuyenMuc.addPOJO(nodeTinChuyenMuc);
				}
				objectNodeResult.putPOJO("tinChuyenMuc", arrayTinChuyenMuc);
			}

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNodeResult,
					DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

}
